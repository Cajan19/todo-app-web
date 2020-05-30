package de.neuefische.todoapp.service;

import de.neuefische.todoapp.database.ToDoDB;
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

    public ToDoMessage addAMessage(ToDoMessage toDoMessage){
        return toDoDatabase.addMessageToDB(toDoMessage);
    }

    public void deleteMessageByID(String id){
        toDoDatabase.removeMessageByID(id);
    }

    public ToDoMessage updateMessageStatus(String id, ToDoMessage horst){
        return toDoDatabase.updateMessageStatus(id, horst);
    }








}
