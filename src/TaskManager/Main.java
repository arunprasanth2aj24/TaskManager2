package TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User[] userArray = new User[7];
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to TaskManager");
            System.out.println("Enter your name ");
            String userName = scan.nextLine();

            boolean isExistingUser = false;
            int userPosition = 0;

            for (int count = 0; count < userArray.length; count++) {
                if (userArray[count] == null) {
                    continue;
                }
                if (userArray[count].getUserName().equals(userName)) {
                    isExistingUser = true;
                    userPosition = count;
                    break;
                }
            }

            User currentUser;
            if (isExistingUser == false) {
                currentUser = new User(userName);
                for (int count = 0; count < userArray.length; count++) {
                    if (userArray[count] != null) {
                        continue;
                    }
                    userArray[count] = currentUser;
                    break;
                }
            } else {
                currentUser = userArray[userPosition];
            }

            Integer choice = 0;

            while (choice != 5) {

                System.out.print("Welcome ");
                System.out.println(currentUser.getUserName());

                System.out.println("1.Add Task");
                System.out.println("2.List all my tasks");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.println("Select a choice from above list");

                choice = new Integer(scan.nextLine());


                if (choice == 1) {

                    boolean checker = false;
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null) {
                            System.out.print(count + 1);
                            System.out.print(". ");
                            System.out.println(currentUser.getTaskArray()[count].getTaskTittle());
                            System.out.print("  ");
                            System.out.print(currentUser.getTaskArray()[count].getTaskDescription());
                            System.out.print(" [");
                            System.out.print(currentUser.getTaskArray()[count].getStatus());
                            System.out.println("]");
                            checker = true;
                        }
                    }
                    if (checker == false) {
                        System.out.println("There is no task yet");
                    }

                        try {
                            System.out.println("Do you want to continue (yes / exit)");
                            String confirm = scan.nextLine();

                            if (confirm.equals("exit")) {
                                throw new Exception();
                            }
                            if (!confirm.equals("yes")) {
                                throw new Exception();
                            }

                            System.out.println("Enter your Task Tittle ");
                            String taskTittle = scan.nextLine();

                            if (taskTittle.equals("exit")) {
                                throw new Exception();
                            }

                            System.out.println("Enter your Task Description ");
                            String taskDescription = scan.nextLine();

                            if (taskDescription.equals("exit")) {
                                throw new Exception();
                            }

                            Task userTask = new Task(taskDescription, taskTittle);

                            for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                                if (currentUser.getTaskArray()[count] == null) {
                                    currentUser.getTaskArray()[count] = userTask;
                                    currentUser.getTaskArray()[count].setTaskTittle(taskTittle);
                                    System.out.println("Task added sucessfully");
                                    break;
                                }
                            }

                        } catch (Exception e) {
                            System.out.println("EXIT FROM CURRENT ACTION");
                        }
                    }


                else if (choice == 2) {

                    boolean checker1 = false;
                    boolean checker2 = false;
                    boolean checker3 = false;

                    System.out.println("------------- To-Do Tasks -------------");
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null &&
                                currentUser.getTaskArray()[count].getStatus().equals("To-Do")) {

                            System.out.print(count + 1);
                            System.out.print(". ");
                            System.out.println(currentUser.getTaskArray()[count].getTaskTittle());
                            checker1 = true;
                        }
                    }
                    if (checker1 == false) {
                        System.out.println("There is no To-Do tasks");
                    }

                    System.out.println("------------- In-Progress Tasks -------------");
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null &&
                                currentUser.getTaskArray()[count].getStatus().equals("In-Progress")) {

                            System.out.print(count + 1);
                            System.out.print(". ");
                            System.out.println(currentUser.getTaskArray()[count].getTaskTittle());
                            checker2 = true;
                        }
                    }
                    if (checker2 == false) {
                        System.out.println("There is no In-Progress tasks");
                    }

                    System.out.println("------------- Done Tasks -------------");
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null &&
                                currentUser.getTaskArray()[count].getStatus().equals("Done")) {

                            System.out.print(count + 1);
                            System.out.print(". ");
                            System.out.println(currentUser.getTaskArray()[count].getTaskTittle());
                            checker3 = true;
                        }
                    }
                    if (checker3 == false) {
                        System.out.println("There is no Done tasks");
                    }
                }


                else if (choice == 3) {
                    boolean taskChecker = false;
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null) {
                            System.out.print(count + 1);
                            System.out.print(". ");
                            System.out.println(currentUser.getTaskArray()[count].getTaskTittle());
                            System.out.print("  ");
                            System.out.print(currentUser.getTaskArray()[count].getTaskDescription());
                            System.out.print(" [");
                            System.out.print(currentUser.getTaskArray()[count].getStatus());
                            System.out.println("]");
                            taskChecker = true;
                        }

                    }
                    if (taskChecker == false) {
                        System.out.println("There is no task still now, add new tasks to update");
                        continue;
                    }
                        try {
                            System.out.println("Do you want to continue (yes / exit)");
                            String confirm = scan.nextLine();

                            if (confirm.equals("exit")) {
                                throw new Exception();
                            }
                            if (!confirm.equals("yes")) {
                                throw new Exception();
                            }

                            System.out.println("Enter your choice from the list to update");
                            String input = scan.nextLine();

                            if (input.equals("exit")) {
                                throw new Exception();
                            }

                            int updateChoice = Integer.parseInt(input);

                            if (currentUser.getTaskArray()[updateChoice - 1] == null) {
                                throw new Exception();
                            }

                            System.out.println("1.Update Description");
                            System.out.println("2.Update Status");
                            Integer uChoice = new Integer(scan.nextLine());

                            if (uChoice == 1) {
                                System.out.println("Enter new task description to update");
                                String newTask = scan.nextLine();

                                if (newTask.equals("exit")) {
                                    throw new Exception();
                                }

                                currentUser.getTaskArray()[updateChoice - 1].setTaskDescription(newTask);
                                System.out.println("New task updated sucessfully");
                            }

                            if (uChoice == 2) {
                                System.out.println("1.To-Do");
                                System.out.println("2.In-Progress");
                                System.out.println("3.Done");

                                Integer statusChoice = new Integer(scan.nextLine());

                                if (statusChoice == 1) {
                                    currentUser.getTaskArray()[updateChoice - 1].setStatus("To-Do");
                                }
                                if (statusChoice == 2) {
                                    currentUser.getTaskArray()[updateChoice - 1].setStatus("In-Progress");
                                }
                                if (statusChoice == 3) {
                                    currentUser.getTaskArray()[updateChoice - 1].setStatus("Done");
                                }
                            }

                        } catch (Exception e) {
                            System.out.println("EXIT FROM CURRENT ACTION");
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
                            System.out.println(currentUser.getTaskArray()[count].getTaskTittle());
                            System.out.print("  ");
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
                        continue;
                    }

                        try {
                            System.out.println("Do you want to continue (yes / exit)");
                            String confirm = scan.nextLine();

                            if (confirm.equals("exit")) {
                                throw new Exception();
                            }
                            if (!confirm.equals("yes")) {
                                throw new Exception();
                            }

                            System.out.println("Enter your choice from the list to delete");
                            String input = scan.nextLine();

                            if (input.equals("exit")) {
                                throw new Exception();
                            }

                            Integer deleteChoice = new Integer(input);

                            if (currentUser.getTaskArray()[deleteChoice - 1] == null) {
                                throw new Exception();
                            }

                            currentUser.getTaskArray()[deleteChoice - 1] = null;
                            System.out.println("Task deleted sucessfully");

                        } catch (Exception e) {
                            System.out.println("EXIT FROM CURRENT ACTION");
                        }
                    }

                    else if (choice == 5) {
                        System.out.println("Thanks for using our app");
                    }
                }
            }
        }
    }
