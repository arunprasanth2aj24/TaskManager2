package TaskManager;

public class Task {

    private String taskDescription;
    private String status = "To-Do";

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public Task(){

    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
