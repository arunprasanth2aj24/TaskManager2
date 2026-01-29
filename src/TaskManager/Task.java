package TaskManager;

public class Task {

    private String taskDescription;
    private String taskTittle;
    private String status = "To-Do";

    public Task(String taskDescription, String tittle) {
        this.taskDescription = taskDescription;
        this.taskTittle = tittle;
    }
    public Task( String tittle) {
        this.taskTittle = tittle;
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

    public String getTaskTittle() {
        return taskTittle;
    }

    public void setTaskTittle(String taskTittle) {
        this.taskTittle = taskTittle;
    }
}
