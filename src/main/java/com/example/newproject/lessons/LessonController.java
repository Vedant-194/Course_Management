package com.example.newproject.lessons;

import com.example.newproject.courses.Course;
import com.example.newproject.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController
{
    @Autowired
    private LessonServices lessonServices;

    @RequestMapping("topic/{topicId}/course/{id}/lesson")
    public List<LessonEntity> getAllLesson(@PathVariable String id)
    {
        return lessonServices.getAllCourses(id);
    }

    @RequestMapping("/topic/{topicId}/course/{courseId}/lesson/{id}")
    public LessonEntity getLesson(@PathVariable String id)
    {
        return lessonServices.getLesson(id);
    }

    @PostMapping("/topic/{topicId}/course/{courseId}/lesson")
    public void addLesson(@RequestBody LessonEntity lessonEntity, @PathVariable String courseId)
    {
        lessonEntity.setCourse(new Course(courseId,"","",""));
        lessonServices.addLesson(lessonEntity);
    }

    @PutMapping("/topic/{topicId}/course/{courseId}/lesson/{id}")
    public void updateLesson(@RequestBody LessonEntity lessonEntity, @PathVariable String id,@PathVariable String courseId)
    {
        lessonEntity.setCourse(new Course(courseId,"","",""));
        lessonServices.updateLesson(lessonEntity);

    }

    @DeleteMapping("/topic/{topicId}/course/{courseId}/lesson/{id}")
    public void deleteLesson(@PathVariable String id)
    {
        lessonServices.deleteLesson(id);
    }

}
