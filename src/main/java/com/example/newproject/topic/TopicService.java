package com.example.newproject.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.*;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


       public List<Topic> getAllTopic()
       {

           List<Topic> topics=new ArrayList<>();
           topicRepository.findAll().forEach(topics::add);
           return topics;
       }
        public Topic getTopic(String id)
        {
            //return topics.stream().filter(x->x.getId().equals(id)).findFirst().get();
            /*Optional<Topic> topic = topicRepository.findById(id);
            if( topic.isPresent() ){
                return topic.get();
            }else{
                return null;
            }*/
            return topicRepository.findById(id).get();
        }
        
        public void addTopic(Topic topic)
        {
            topicRepository.save(topic);
        }

        public void updateTopic(Topic topic, String id)
        {
            topicRepository.save(topic);
        }

        public void deleteTopic(String id)
        {
            topicRepository.deleteById(id);
        }
}
