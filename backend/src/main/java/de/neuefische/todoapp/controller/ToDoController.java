package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.model.ToDoMessage;
import de.neuefische.todoapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/todo")

public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDoMessage> getMessages() {
        return toDoService.getAllMessages();

    }

    @PutMapping
    public ToDoMessage addMessage(@RequestBody ToDoMessage toDoMessage) {
        return toDoService.addAMessage(toDoMessage);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id){
        toDoService.deleteMessageByID(id);
    }

    @PutMapping("{id}/status")
    public ToDoMessage updateMessageStatus (@PathVariable String id, @RequestBody ToDoMessage horst){
        return toDoService.updateMessageStatus(id, horst);
    }


}






