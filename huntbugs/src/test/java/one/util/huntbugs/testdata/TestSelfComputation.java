/*
 * Copyright 2015, 2016 Tagir Valeev
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package one.util.huntbugs.testdata;

import one.util.huntbugs.registry.anno.AssertNoWarning;
import one.util.huntbugs.registry.anno.AssertWarning;

/**
 * @author lan
 *
 */
public class TestSelfComputation {
    @AssertWarning(type="SelfComputation")
    public int test(int a, int b) {
        return (a-b) - (a-b);
    }

    @AssertWarning(type="SelfComputation")
    public int test(int[] x) {
        return x[1] - x[1];
    }
    
    @AssertNoWarning(type="SelfComputation")
    public int test(int[] x, int idx) {
        return x[idx++] - x[idx++];
    }
}