package com.emmakatwebaze.spring.data.jpapractice.repository;

import com.emmakatwebaze.spring.data.jpapractice.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
