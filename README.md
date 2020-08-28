# FragmentStateManagerBehaviorChange
Demo of behavior change when enabling the new state manager in alpha08

When the new State Manager behavior is enabled, the order of fragment lifecycle events
as seen by FragmentLifecycleCallbacks is different. Specifically the order of a parent
Fragment's onResume() call is observed after the child's onResume() call. This only appears to happen
when the ParentFragment is navigated to using fragment animations.

However the order of the actual onResume() calls are still in the correct order, 
just the callback class is notified in reversed order.

Below are the logs from LoggingCallbacks (instance of FragmentLifecycleCallbacks) with both behaviors:

|  enableNewStateManager(true):           | enableNewStateManager(false): 
|-----------------------------------------|----------------------------------------|
| onFragmentCreated: ParentFragment       | onFragmentCreated: ParentFragment      |
| onFragmentViewCreated: ParentFragment   | onFragmentViewCreated: ParentFragment  |
| onFragmentStarted: ParentFragment       | onFragmentStarted: ParentFragment      |
| onFragmentPreAttached: ChildFragment{1} | onFragmentResumed: ParentFragment      |
| onFragmentViewCreated: ChildFragment{1} | onFragmentCreated: ChildFragment{1}    |
| onFragmentPreAttached: ChildFragment{2} | onFragmentCreated: ChildFragment{2}    |
| onFragmentCreated: ChildFragment{2}     | onFragmentViewCreated: ChildFragment{1}|
| onFragmentViewCreated: ChildFragment{2} | onFragmentStarted: ChildFragment{1}    |
| onFragmentStarted: ChildFragment{2}     | onFragmentResumed: ChildFragment{1}    |
| onFragmentResumed: ChildFragment{1}     | onFragmentViewCreated: ChildFragment{2}|
| onFragmentResumed: ChildFragment{2}     | onFragmentStarted: ChildFragment{2}    |
| onFragmentResumed: ParentFragment       | onFragmentResumed: ChildFragment{2}    |
