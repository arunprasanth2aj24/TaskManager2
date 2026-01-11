package TaskManager;

public class Task {

    private String taskDescription;
    private String status;

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.status = "TO_DO";
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
