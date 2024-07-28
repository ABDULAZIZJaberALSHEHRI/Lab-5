package com.example.lab5q1;

import com.example.lab5q1.Model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class Lab5Q1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab5Q1Application.class, args);}

		ArrayList<Student> students = new ArrayList<Student>();
		//Student student1 = new Student("Abdulaziz",25,"bachelor",true);


//	@Qualifier("1")
//	public String name(){
//		System.out.println(student1.getName());
//		return student1.getName();
//	}



}
