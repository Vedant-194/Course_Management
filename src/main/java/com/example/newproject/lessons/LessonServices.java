package com.example.newproject.lessons;

import com.example.newproject.courses.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LessonServices {

    @Autowired
    private LessonRepository lessonRepository;

    public List<LessonEntity> getAllCourses(String id)
    {
        List<LessonEntity> lessonEntities=new ArrayList<>();
        lessonRepository.findByCourseId(id).forEach(lessonEntities::add);
        return lessonEntities;
    }

    public LessonEntity getLesson(String id)
    {
        return lessonRepository.findById(id).get();
    }

    public void addLesson(LessonEntity lessonEntity)
    {
        lessonRepository.save(lessonEntity);
    }

    public void updateLesson(LessonEntity lessonEntity)
    {
        lessonRepository.save(lessonEntity);
    }

    public void deleteLesson(String id)
    {
        lessonRepository.deleteById(id);
    }
}
