package com.example.demo.Model.BO;

import com.example.demo.Model.BEAN.Class;
import com.example.demo.Model.BEAN.Student;
import com.example.demo.Model.DAO.StudentRepository;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> FindAllStudent(){
        return studentRepository.findAll();
    }
    public List<Student> FindStudentByIDClass(int idClass){
        return  studentRepository.findStudentsByIDClass(idClass);
    }
    public void AddStudent(String name, Class aClass){
        Student temp = new Student();
        temp.setName(name);
        temp.setAclass(aClass);
        studentRepository.save(temp);

    }
    public void UpdateStudent(Student temp){

        Student newStudent = studentRepository.getReferenceById(temp.getId());
        newStudent.setAclass(temp.getAclass());
        newStudent.setName(temp.getName());
        studentRepository.save(newStudent);

    }
    public void DeleteStudent(int IdStudent){
        studentRepository.deleteById(IdStudent);
    }
    public Student findById(int Id){
        return studentRepository.getReferenceById(Id);
    }

}
