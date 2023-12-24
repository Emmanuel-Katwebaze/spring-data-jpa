package com.emmakatwebaze.spring.data.jpapractice.repository;

import com.emmakatwebaze.spring.data.jpapractice.entity.Guardian;
import com.emmakatwebaze.spring.data.jpapractice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest normally use this but this time we want to effect our database, and we
// don't want to create an entire REST API to interact with the database
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("emma@gmail.com")
                .firstName("Emmanuel")
                .lastName("Katwebaze")
//                .guardianName("Yeon")
//                .guardianEmail("yeon@gmail.com")
//                .guardianMobile("999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Yeon")
                .email("yeon@gmail.com")
                .mobile("999999999")
                .build();

        Student student = Student.builder()
                .firstName("Maria")
                .emailId("maria@gmail.com")
                .lastName("Posa")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Maria");
        System.out.println("students = " + students);

    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("ar");
        System.out.println("students = " + students);

    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Yeon");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("maria@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("maria@gmail.com");
        System.out.println("student = " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("maria@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("maria@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("mariposa", "maria@gmail.com");
    }

}