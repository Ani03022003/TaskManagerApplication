package com.TaskManagerProject;

public class Task {
    int task_id;
    String task_desc;
    String task_priority;
    String task_status;
    public Task(int task_id,String task_desc,String task_priority,String task_status){
        this.task_id=task_id;
        this.task_desc=task_desc;
        this.task_priority=task_priority;
        this.task_status=task_status;
    }
    public int get_task_id(){
        return task_id;
    }
    public String get_task_desc(){
        return task_desc;
    }
    public String get_task_priority(){
        return task_priority;
    }
    public String get_task_status(){
        return task_status;
    }
    public void set_task_status(String task_status){
        this.task_status=task_status;
    }
    public void set_task_priority(String task_priority){
        this.task_priority=task_priority;
    }
    public void set_task_desc(String task_desc){
        this.task_desc=task_desc;
    }
    public void set_task_id(int task_id){
        this.task_id=task_id;
    }
    @Override
    public String toString(){
        return "Task ID: "+task_id+"\nTask Description: "+task_desc+"\nTask Priority: "+task_priority+"\nTask Status: "+task_status;
    }
}
