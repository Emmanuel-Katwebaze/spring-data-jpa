package com.emmakatwebaze.spring.data.jpapractice.repository;

import com.emmakatwebaze.spring.data.jpapractice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
