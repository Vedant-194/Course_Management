package com.example.newproject.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//Also by using @RestController the return Type is directly converted into json
@RestController
public class TopicController
{
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topic")
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopic();
    }

    @RequestMapping("/topic/{id}")
    public Topic getTopic(@PathVariable String id)
    {
        return topicService.getTopic(id);
    }

    @PostMapping("/topic")
    public void addTopic(@RequestBody Topic topic)
    {
        topicService.addTopic(topic);
    }

    @PutMapping("/topic/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
    {
        topicService.updateTopic(topic,id);
    }

    @DeleteMapping("/topic/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        topicService.deleteTopic(id);
    }
}
