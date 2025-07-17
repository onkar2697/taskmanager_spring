package com.example.taskmanager_spring.service;

import com.example.taskmanager_spring.entities.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public class TaskService  {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskid =1;

    void addTask(String title, String description,String deadline){
        TaskEntity task = new TaskEntity();
        task.setId(taskid);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(new Date(deadline));
        task.setCompleted(false);
        tasks.add(task);
        taskid++;
    }

    ArrayList<TaskEntity> getTask(){
        return tasks;
    }
    TaskEntity getTaskById(int id){
        for(TaskEntity task: tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }
}
