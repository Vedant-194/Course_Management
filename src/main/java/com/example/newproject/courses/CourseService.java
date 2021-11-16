package com.example.newproject.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


       public List<Course> getAllCourses(String topicId)
       {

           List<Course> courses=new ArrayList<>();
           courseRepository.findByTopicId(topicId).forEach(courses::add);
           return courses;
       }

    public List<Course> getAllCourses()
    {
        List<Course> courses=new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }
        public Course getCourse(String id)
        {
            //return topics.stream().filter(x->x.getId().equals(id)).findFirst().get();
            /*Optional<Topic> topic = topicRepository.findById(id);
            if( topic.isPresent() ){
                return topic.get();
            }else{
                return null;
            }*/
            return courseRepository.findById(id).get();
        }

        public void addCourse(Course course)
        {
            courseRepository.save(course);
        }

        public void updateCourse(Course course)
        {
            courseRepository.save(course);
        }

        public void deleteCourse(String id)
        {
            courseRepository.deleteById(id);
        }
}
