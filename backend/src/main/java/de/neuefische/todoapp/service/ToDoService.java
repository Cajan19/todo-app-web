package de.neuefische.todoapp.service;

import de.neuefische.todoapp.database.ToDoDB;
import de.neuefische.todoapp.model.Description;
import de.neuefische.todoapp.model.ToDoMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class ToDoService {

    private final ToDoDB toDoDatabase;


    @Autowired
    public ToDoService(ToDoDB toDoDatabase){
        this.toDoDatabase = toDoDatabase;
    }

    public List<ToDoMessage> getAllMessages(){
        return toDoDatabase.getAllMessages();
    }

    public ToDoMessage addAMessage(Description someDescription){
        return toDoDatabase.addMessageToDB(someDescription);
    }

    public void deleteMessageByID(String id){
        toDoDatabase.removeMessageByID(id);
    }








}
