package workflow.implementation;

import activity.contract.GreetingActivities;
import com.uber.cadence.workflow.Workflow;
import workflow.contract.GreetingWorkflow;

/** GreetingWorkflow implementation that calls GreetingsActivities#composeGreeting. */
public class GreetingWorkflowImpl implements GreetingWorkflow {

  /**
   * Activity stub implements activity interface and proxies calls to it to Cadence activity
   * invocations. Because activities are reentrant, only a single stub can be used for multiple
   * activity invocations.
   */
  private final GreetingActivities activities =
      Workflow.newActivityStub(GreetingActivities.class);

  @Override
  public String getGreeting(String name) {
    // This is a blocking call that returns only after the activity has completed.
    return activities.composeGreeting("Hello", name);
  }
}
