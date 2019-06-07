package com.serving.qweater;

import com.serving.qweater.entity.Message;
import com.serving.qweater.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller    // This means that this class is a Controller
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String greeting(){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> map) {
        Iterable<Message> messages = messageRepository.findAll();

        map.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tags, Map<String, Object> map) {
        Message message = new Message(text, tags);

        // save message to the database;
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();

        map.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String add(@RequestParam String filter, Map<String, Object> map) {
        Iterable<Message> messages;

        // Заглушка, если пользователь не задал фильтр
        if (filter == null || filter.isEmpty()) {
            messages = messageRepository.findAll();
        } else {
            messages = messageRepository.findByTags(filter);
        }
        map.put("messages", messages);
        return "main";
    }
}