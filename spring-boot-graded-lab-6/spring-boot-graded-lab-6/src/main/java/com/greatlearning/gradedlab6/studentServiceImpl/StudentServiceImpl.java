package com.greatlearning.gradedlab6.studentServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.gradedlab6.entity.Student;
import com.greatlearning.gradedlab6.repository.StudentRepository;
import com.greatlearning.gradedlab6.studentService.StudentService;

@Service

public class StudentServiceImpl implements StudentService{

	@Autowired
	
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(int id, Student student) {
		
		// TODO Auto-generated method stub
		Student updatedStudentInfo = getStudentById(id);
		updatedStudentInfo.setFirstName(student.getFirstName());
		updatedStudentInfo.setLastName(student.getLastName());
		updatedStudentInfo.setCourse(student.getCourse());
		updatedStudentInfo.setCountry(student.getCountry());
		return saveStudent(updatedStudentInfo);
	}

	@Override
	public void deleteStudentById(int id) {
		
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);	
	}
}
