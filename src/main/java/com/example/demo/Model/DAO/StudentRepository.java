package com.example.demo.Model.DAO;

import com.example.demo.Model.BEAN.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "SELECT s FROM Student s WHERE s.aclass.id=:IDClass")
    List<Student> findStudentsByIDClass(@Param("IDClass") Integer IDClass);


}
