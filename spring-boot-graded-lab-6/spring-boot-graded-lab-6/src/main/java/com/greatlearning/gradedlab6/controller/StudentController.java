package com.greatlearning.gradedlab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.gradedlab6.entity.Student;
import com.greatlearning.gradedlab6.studentService.StudentService;

@Controller

public class StudentController {
	
	@Autowired
	
	StudentService studentService;
	
	@GetMapping("/")
	
	public String listStudents(Model model) {
		
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	
	public String createStudentForm(Model model) {
		
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	
	public String saveEmployee(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/students/edit/{id}")
	
	public String editStudentForm(@PathVariable int id, Model model) {
		
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
		
		studentService.updateStudent(id, student);
		return "redirect:/";
	}
	
	@GetMapping("/students/{id}")
	
	public String deleteStudent(@PathVariable int id) {
		
		studentService.deleteStudentById(id);
		return "redirect:/";
	}
}
