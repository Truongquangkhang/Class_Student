package com.example.demo;

import com.example.demo.Model.BEAN.Student;
import com.example.demo.Model.BO.StudentService;
import com.example.demo.Model.DAO.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Demo2Application.class, args);
//        StudentService studentService = context.getBean(StudentService.class);
//        List<Student> temp = studentService.FindAllStudent();
//        for(Student i:temp){
//            System.out.println(i.getName());
//        }
//        StudentRepository studentRepository = context.getBean(StudentRepository.class);
//        studentRepository.findAll().forEach(p->{System.out.println(p.getName());});

    }

}
