package com.emmakatwebaze.spring.data.jpapractice.repository;

import com.emmakatwebaze.spring.data.jpapractice.entity.Course;
import com.emmakatwebaze.spring.data.jpapractice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Lee")
                .lastName("Rang")
                //.courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }

}