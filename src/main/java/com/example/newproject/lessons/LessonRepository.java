package com.example.newproject.lessons;

import com.example.newproject.courses.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<LessonEntity,String>
{
    public List<LessonEntity> findByCourseId(String id);


}
