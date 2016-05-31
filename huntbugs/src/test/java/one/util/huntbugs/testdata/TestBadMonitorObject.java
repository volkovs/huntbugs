/*
 * Copyright 2016 HuntBugs contributors
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

import one.util.huntbugs.registry.anno.AssertWarning;

/**
 * @author Tagir Valeev
 *
 */
public class TestBadMonitorObject {
    @AssertWarning("SynchronizationOnBoxedNumber")
    public void syncNumber() {
        Integer num = 1;
        synchronized(num) {
            System.out.println("In lock");
        }
    }

    @AssertWarning("SynchronizationOnUnsharedBoxed")
    public void syncUnsharedNumber() {
        synchronized(new Integer(1)) {
            System.out.println("In lock");
        }
    }

    @AssertWarning("SynchronizationOnUnsharedBoxed")
    public void syncUnsharedBoolean() {
        synchronized(new Boolean(true)) {
            System.out.println("In lock");
        }
    }
    
    @AssertWarning("SynchronizationOnBoolean")
    public void syncBoolean() {
        synchronized(Boolean.TRUE) {
            System.out.println("In lock");
        }
    }
}
