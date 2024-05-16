package com.TaskManagerProject;
import java.util.*;

public class TaskManager {
    
    static Scanner sc = new Scanner(System.in);
    List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
    public Task searchId(int id){
        for(Task task : tasks){
            if(task.get_task_id() == id){
                return task;
            }
        }
        return null;
    }
    public void addTask(){
        System.out.println("Enter Task Id: ");
        int taskId = sc.nextInt();
        System.out.println("Enter Task Name: ");
        String taskName = sc.next();
        System.out.println("Enter Task Priority(High/Medium/Low): ");
        String taskPriority = sc.next();
        System.out.println("Enter Task Status(Pending,Running,Finished): ");
        String taskStatus = sc.next();
        Task task = new Task(taskId,taskName,taskPriority,taskStatus);
        tasks.add(task);
        //System.out.println(task);
    }
    public void editTask(Task task){
        if(task == null){
            System.out.println("Task not found");
            return;
        }
        else{
            System.out.println("Enter Task Name(Leave blank to keep existing): ");
            String taskName = sc.nextLine();
            System.out.println("Enter Task Priority(Leave blank to keep existing): ");
            String taskPriority = sc.nextLine();
            System.out.println("Enter Task Status(Leave blank to keep existing): ");
            String taskStatus = sc.nextLine();
            if(!taskName.isEmpty()){
                task.set_task_desc(taskName);
            }
            if(!taskPriority.isEmpty()){
                task.set_task_priority(taskPriority);
            }
            if(!taskStatus.isEmpty()){
                task.set_task_status(taskStatus);
            }
            //System.out.println(task);
        }
    }
    public void deleteTask(Task task){
        if(task == null){
            System.out.println("Task not found");
            return;
        }
        tasks.remove(task);
    }
    public void viewTaskById(Task task){
        if(task == null){
            System.out.println("Task not found");
            return;
        }
        System.out.println(task);
    }
    public void viewAllTasks(){
        for(Task task : tasks){
            System.out.println(task);
        }
    }
    public void viewAllTasksByStatus(String status){
        for(Task task : tasks){
            if(task.get_task_status().equals(status)){
                System.out.println(task);
            }
        }
    }
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        int choice;
        while(true){
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Task By Id");
            System.out.println("5. View All Tasks");
            System.out.println("6. View All Tasks By Status");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1: tm.addTask();
                    break;
                case 2:
                    System.out.println("Enter Task Id: ");
                    int taskId = sc.nextInt();
                    sc.nextLine();
                    tm.editTask(tm.searchId(taskId));
                    break;
                case 3:
                    System.out.println("Enter Task Id: ");
                    int taskId1 = sc.nextInt();
                    tm.deleteTask(tm.searchId(taskId1));
                    break;
                case 4:
                    System.out.println("Enter Task Id: ");
                    int taskId2 = sc.nextInt();
                    tm.viewTaskById(tm.searchId(taskId2));
                    break;
                case 5:
                    tm.viewAllTasks();
                    break;
                case 6:
                    System.out.println("Enter Task Status: ");
                    sc.nextLine();
                    String taskStatus = sc.nextLine();
                    tm.viewAllTasksByStatus(taskStatus);
                    break;
                case 7:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
