package de.neuefische.todoapp.database;

import de.neuefische.todoapp.enums.StatusEnum;
import de.neuefische.todoapp.model.Description;
import de.neuefische.todoapp.model.ToDoMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ToDoDB {

    List<ToDoMessage> toDoMessageList = new ArrayList<>();

    public List<ToDoMessage> getAllMessages() {
        return toDoMessageList;
    }


    public ToDoMessage addMessageToDB(Description someDescription) {
        String uuid = UUID.randomUUID().toString();
        String text = someDescription.getDescription();
        ToDoMessage message = new ToDoMessage(uuid, text, StatusEnum.OPEN);
        toDoMessageList.add(message);
        return message;
    }

    public void removeMessageByID(String id){
        toDoMessageList.removeIf(message -> message.getId().equals(id));
    }





    public void clearDB() {
        toDoMessageList.clear();
    }
}

