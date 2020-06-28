package org.alitaptap.mmsu_ns.worker;

public class ActiveServiceDirectory {

  private static final ActiveServiceDirectory instance = new ActiveServiceDirectory();
  private final CircularServiceTask activeServiceTasks = new CircularServiceTask();

  public static ActiveServiceDirectory getInstance() {
    return instance;
  }

  public void register(WebAccessorTask webAccessorTask) {
    activeServiceTasks.put(webAccessorTask);
  }

  public void unregister(String studentId) {
    activeServiceTasks.remove(studentId);
  }

  /** Runs the current task and shifts to next task. */
  public void runCurrentTask() {
    activeServiceTasks.next().call();
  }
}
