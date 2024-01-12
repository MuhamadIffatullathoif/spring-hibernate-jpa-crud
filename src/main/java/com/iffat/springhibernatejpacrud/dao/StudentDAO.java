package com.iffat.springhibernatejpacrud.dao;

import com.iffat.springhibernatejpacrud.entity.Student;

public interface StudentDAO {

    void save(Student studentDao);
    Student findById(Integer id);
}
