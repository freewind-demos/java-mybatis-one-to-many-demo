package com.example;

import com.example.entities.Message;
import com.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class HelloController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("")
    public List<Message> index() {
        return this.messageService.findAll();
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable String id) {
        return this.messageService.findById(id);
    }

    @PostMapping("")
    public Integer save(@RequestBody @Validated Message message) {
        this.messageService.create(message);
        return message.id;
    }

}
