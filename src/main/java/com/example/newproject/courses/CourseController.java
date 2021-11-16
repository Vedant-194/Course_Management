package com.example.newproject.courses;

import com.example.newproject.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Also by using @RestController the return Type is directly converted into json
@RestController
public class CourseController
{
    @Autowired
    private CourseService courseService;

    @RequestMapping("topic/{id}/course")
    public List<Course> getAllCoursesForTopic(@PathVariable String id)
    {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/course")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }

    @RequestMapping("/topic/{topicId}/course/{id}")
    public Course getCourse(@PathVariable String id)
    {
        return courseService.getCourse(id);
    }

    @PostMapping("/topic/{topicId}/course")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @PutMapping("/topic/{topicId}/course/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id,@PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);

    }

    @DeleteMapping("/topic/{topicId}/course/{id}")
    public void deleteCourse(@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }
}
