package com.example.demo.Model.BEAN;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
@Data
@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Override
    public String toString(){
        return this.name;
    }

//    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
//    private Collection<Student> students;
}
