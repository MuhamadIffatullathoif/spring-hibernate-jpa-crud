package com.iffat.springhibernatejpacrud;

import com.iffat.springhibernatejpacrud.dao.StudentDAO;
import com.iffat.springhibernatejpacrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudent(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> responseStudents = studentDAO.findByLastName("Wick");

        // display list of students
        for (Student student: responseStudents) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student student: theStudents) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating student ...");
        Student student = new Student("Joni","Doe","joni@gmail.com");

        // save the student
        System.out.println("Saving student ...");
        studentDAO.save(student);

        // display id of the saved student
        int id = student.getId();
        System.out.println("Saved Student. Generated id : " + id);

        // retrieve student based on the id: primary key
        System.out.println("Retrieve student with id: " + id);
        Student responseStudent = studentDAO.findById(id);

        // display student
        System.out.println("Found the student: " + responseStudent);
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
        Student student = new Student("John","Wick","doe@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }
}
