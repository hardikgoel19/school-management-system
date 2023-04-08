package com.school.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.model.StudentPersonal;
import com.school.management.service.StudentPersonalService;

@RestController
@RequestMapping("/student/personal")
public class StudentPersonalController {
	
	@Autowired
	private StudentPersonalService studentPersonalService;
	
	@PostMapping("/save")
	public ResponseEntity<StudentPersonal> saveStudent(@RequestBody StudentPersonal student) {
		return getResponseEntity(studentPersonalService.save(student), HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<StudentPersonal> updateStudent(@RequestBody StudentPersonal updatedStudent) {
		try {
			return getResponseEntity(studentPersonalService.update(updatedStudent), HttpStatus.ACCEPTED);
		} catch(final Exception ex) {
			System.out.println(ex);
			return getResponseEntity(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findById/{studentId}")
	public ResponseEntity<StudentPersonal> getById(@PathVariable("studentId") String id) {
		Optional<StudentPersonal> optionalStudentPersonal = studentPersonalService.findById(id);
		
		if(optionalStudentPersonal.isPresent()) {
			StudentPersonal studentPersonal = optionalStudentPersonal.get();
			return getResponseEntity(studentPersonal, HttpStatus.OK);
		} else {
			return getResponseEntity(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<StudentPersonal>> findAll() {
		List<StudentPersonal> studentPersonals = studentPersonalService.findAll();
		return getResponseEntity(studentPersonals, HttpStatus.OK);
	}
	
	private <T> ResponseEntity<T> getResponseEntity(T t, HttpStatus status) {
		ResponseEntity<T> sp = new ResponseEntity<T>(t, status);
		return sp;
	}
	
}
