package com.example.demo.Model.BO;

import com.example.demo.Model.BEAN.Class;
import com.example.demo.Model.DAO.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<Class> findAll(){
        Class t = new Class();
        return classRepository.findAll();
    }
    public Class findByIDClass(int IdClass){
        return classRepository.getReferenceById(IdClass);
    }

}
