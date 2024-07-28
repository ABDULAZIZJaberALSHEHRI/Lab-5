package com.example.lab5q1.Controller;

import com.example.lab5q1.Model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student> students = new ArrayList<Student>();

    @PostMapping("/add-student")
    public String addCustomer(@RequestBody Student student){
        students.add(student);
        return "Successfully added customer";
    }
    @GetMapping("/name/{index}")
    public String getStudentname(@PathVariable int index) {
        return "Student Name : " + students.get(index).getName();
    }

    @GetMapping("/age/{index}")
    public String getStudentAge(@PathVariable int index) {
        return "Student Age : " + students.get(index).getAge();
    }

    @GetMapping("/degree/{index}")
    public String getStudentdegree(@PathVariable int index) {
        return "Student degree : " + students.get(index).getDegree();
    }

    @GetMapping("/isgraduated/{index}")
    public String isStudentGraduate(@PathVariable int index) {
        if (students.get(index).getStatus().equals("Graduated")){
            return "TRUE";
        }else return "FALSE";
    }

    @GetMapping("/get-students")
    public ArrayList<Student> getStudents() {
        return students;
    }


}
