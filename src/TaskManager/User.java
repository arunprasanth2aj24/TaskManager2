package TaskManager;

public class User {
    private String userName;
    private Task [] taskArray = new Task [10];


    public User(String user){
        this.userName = user;
    }

    public String getUserName(){
        return this.userName;
    }

    public Task [] getTaskArray(){
        return this.taskArray;
    }
}

