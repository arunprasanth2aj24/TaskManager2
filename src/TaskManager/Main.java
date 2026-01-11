package TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // User Array created to store the User
        // It helps to not to create new user every time
        User[] userArray = new User[7];
        Scanner scan = new Scanner(System.in);
        //we need to run this code even after exiting app so while used
        while (true) {
            //Getting userName using Nextlint method and storing it in a variable
            System.out.println("Welcome to TaskManager");
            System.out.println("Enter your name ");
            String userName = scan.nextLine();

            boolean isExistingUser = false;
            int userPosition = 0;


            //this loop is used here to check inside array if there is any user
            for (int count = 0; count < userArray.length; count++) {
                if (userArray[count] == null) {
                    //this condition  checks the null value
                    continue;
                }
                // If the above conditionn becomes false this block executes
                if (userArray[count].getUserName().equals(userName)) {
                    //this condition checks the existing user's position in the user index
                      isExistingUser = true;
                      userPosition = count;
                      break;

                }
            }
            // If the user is new user this block executes
            User currentUser;
            if (isExistingUser == false) {
                currentUser = new User(userName);
                //this loop checks the if the index holds any User
                for (int count = 0; count < userArray.length; count++) {
                    if (userArray[count] != null) {
                        continue;
                    }
                    //Stores the currentUser in userArray and stops the loop
                    userArray[count] = currentUser;
                    break;
                }
            }
            //if the user is existing user else block executes
            //it gets the position of user and stores in current user var
            else {
                currentUser = userArray[userPosition];
            }
            //Here printing no of options we have and getting input as choice to perform the action
                Integer choice = 0;
            //This while loop runs untill the user gives choice as 5 i.e Exit
                while (choice != 6 ) {
                    System.out.print("Welcome ");
                    System.out.println(currentUser.getUserName());

                    System.out.println("1.Add Task");
                    System.out.println("2.List all my tasks");
                    System.out.println("3.Update");
                    System.out.println("4.Delete");
                    System.out.println("5.Update Status");
                    System.out.println("6.Exit");
                    System.out.println("Select a choice from above list");
                    choice = new Integer(scan.nextLine());


                    if (choice == 1) {
                        boolean checker = false;
                        // This loop used to print all the Existing task descripion that user have
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.print(currentUser.getTaskArray()[count].getTaskDescription());
                                System.out.print(" [");
                                System.out.print(currentUser.getTaskArray()[count].getStatus());
                                System.out.println("]");
                                checker = true;
                            }
                        }
                        // If there is no task this block executes
                        if (checker == false) {
                            System.out.println("There is no task yet");
                        }
                        // This block executes always when user choice is 1
                        // It gets the task description and stores in a variable
                        System.out.println("_____________________");
                        System.out.println("Enter your Task Description ");
                        String taskDescription = scan.nextLine();
                        Task userTask = new Task(taskDescription);
                        // this loop is used to store the task description only where the index is null
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] == null) {
                                  // Here it stpres the taskDescription inside TaskArray using counter variable
                                // And stops the loop after storing the task description
                                currentUser.getTaskArray()[count] = userTask;
                                System.out.println("Task added sucessfully ");
                                break;
                            }
                        }
                    }
                    //If the user choice is 6 this condition executes
                    else if (choice == 6) {
                        System.out.println("Thanks for using our app");
                    }

                    else if (choice == 2) {
                        boolean taskChecker = false;
                        // This block executes to print all the existing task descriptions
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            // This if block executes only the Task Array is not null
                            // If it runs even it is null it throws an error because there is no value to print
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.print(currentUser.getTaskArray()[count].getTaskDescription());
                                System.out.print(" [");
                                System.out.print(currentUser.getTaskArray()[count].getStatus());
                                System.out.println("]");
                                taskChecker = true;
                            }
                        }
                        // Flag is used to check if the printing of all tasks are printed or not
                        // If not the flag remains false then this block will executes
                        if (taskChecker == false) {
                            System.out.println("There is no task still now, add new tasks to list");
                        }
                    }
                    else if (choice == 3) {
                        boolean taskChecker = false;
                        // This block is used to display all the tasks the user stored
                        // To get choice from the user to update the task
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.print(currentUser.getTaskArray()[count].getTaskDescription());
                                System.out.print(" [");
                                System.out.print(currentUser.getTaskArray()[count].getStatus());
                                System.out.println("]");
                                taskChecker = true;
                            }

                            }

                        // here the flag is used to check if the extisting tasks are printed or not
                        if (taskChecker == false) {
                            System.out.println("There is no task still now, add new tasks to update");
                        }
                        // This block is used to get the choice from the user
                       else if (taskChecker == true){
                            System.out.println("Enter your choice from the list to update");
                            Integer updateChoice = new Integer(scan.nextLine());

                            // this if condition is used to check if the user given the correct choice
                            // if the user gives the choice that not in the listed Tasks it executes this block
                            if (currentUser.getTaskArray()[updateChoice-1] == null){

                                System.out.println("Enter a valid choice");
                            }
                             // This block gets the task description and stores in a variable
                            // And accessing the Task array using user choice as index and updates that taskDescription
                            else{
                            System.out.println("Enter new task description to update");
                            String newTask = (scan.nextLine());
                            currentUser.getTaskArray()[updateChoice - 1].setTaskDescription(newTask);
                            System.out.println("New task updated sucessfully ");
                            }
                        }
                    }
                    else if (choice == 4) {
                        boolean taskChecker = false;
                        // This block is used to display all the tasks the user stored
                        // To get choice from the user to update the task -
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.print(currentUser.getTaskArray()[count].getTaskDescription());
                                System.out.print(" [");
                                System.out.print(currentUser.getTaskArray()[count].getStatus());
                                System.out.println("]");
                                taskChecker = true;
                            }
                        }
                         // If there is no tasksDescriptions in the array it executes this condition that we get to know using the flag
                        if (taskChecker == false) {
                            System.out.println("There is no task to delete");
                        }
                        // If there is taskDescription this block will execute
                        if (taskChecker == true){
                            // this gets the choice to delete and stores in a variable
                            System.out.println("Enter your choice from the list to delete");
                            Integer deleteChoice = new Integer(scan.nextLine());
                            // This condition checks if the given user choicd is a correct choice as it is listed in the Task Lists
                            if (currentUser.getTaskArray()[deleteChoice - 1]==null){
                                System.out.println("Enter a valid choice");
                            }
                            else{
                                // If user given a choice it need to be -1 to access the correct index value
                                // To delete the Task it need to be changed to its default value as null
                                // It will delete the task object and make the index as null
                            currentUser.getTaskArray()[deleteChoice - 1]=(null);
                            System.out.println("Task deleted sucessfully");
                            }
                        }
                    }
                    else if (choice == 5){
                        boolean taskChecker = false;
                        for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                            if (currentUser.getTaskArray()[count] != null) {
                                System.out.print(count + 1);
                                System.out.print(". ");
                                System.out.print(currentUser.getTaskArray()[count].getTaskDescription());
                                System.out.print(" [");
                                System.out.print(currentUser.getTaskArray()[count].getStatus());
                                System.out.println("]");
                                taskChecker = true;
                            }
                        }if (!taskChecker){
                            System.out.println("There is no task to update status");
                        }
                        if (taskChecker){
                            System.out.println("Select a task from the above list to update its status");
                            Integer updateChoice = new Integer (scan.nextLine());


                            System.out.println("1.To-Do");
                            System.out.println("2.In-Progress");
                            System.out.println("3.Done");
                            System.out.println("Select status progress");

                            Integer statusChoice = new Integer (scan.nextLine());

                            Task selectedStatus = currentUser.getTaskArray()[updateChoice - 1];

                            if (statusChoice == 1){
                                selectedStatus.setStatus("To-Do");
                            }
                            else if (statusChoice == 2){
                                selectedStatus.setStatus("In-Progress");
                            }
                            else if (statusChoice == 3){
                                selectedStatus.setStatus("Done");
                            }
                            else {
                                System.out.println("Enter a valid status progress");
                            }


                        }
                    }
                }
        }
    }
}
