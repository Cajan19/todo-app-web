package de.neuefische.todoapp.database;

import de.neuefische.todoapp.enums.StatusEnum;
import de.neuefische.todoapp.model.ToDoMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ToDoDB {

    List<ToDoMessage> toDoMessageList = new ArrayList<>();

    public List<ToDoMessage> getAllMessages() {
        return toDoMessageList;
    }


    public ToDoMessage addMessageToDB(ToDoMessage toDoMessage1) {
        toDoMessage1.setId(UUID.randomUUID().toString());
        toDoMessage1.setStatus(StatusEnum.OPEN);
        toDoMessageList.add(toDoMessage1);
        return toDoMessage1;
    }

    public void removeMessageByID(String id) {
        toDoMessageList.removeIf(message -> message.getId().equals(id));
    }

    public ToDoMessage updateMessageStatus(String id, ToDoMessage updateToDo) {
        for (ToDoMessage horst : toDoMessageList) {
            if (horst.getId().equals(id)) {
                horst.setStatus(updateToDo.getStatus());
                return horst;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


    public void clearDB() {
        toDoMessageList.clear();
    }
}

