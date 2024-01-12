package com.iffat.springhibernatejpacrud;

import com.iffat.springhibernatejpacrud.dao.StudentDAO;
import com.iffat.springhibernatejpacrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            createMultipleStudent(studentDAO);
        };
    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        // create multiple student
        System.out.println("Creating 3 objects ...");
        Student student1 = new Student("John","Doe","doe@gmail.com");
        Student student2 = new Student("Marry","Doe","marry@gmail.com");
        Student student3 = new Student("Bon","Doe","bon@gmail.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object ...");
        Student student = new Student("John","Doe","doe@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
