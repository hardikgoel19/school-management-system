package com.school.management.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.model.StudentPersonal;
import com.school.management.repository.StudentPersonalRepository;

@Service
public class StudentPersonalService {
	
	@Autowired
	private StudentPersonalRepository studentPersonalRepository;
	
	public StudentPersonal save(StudentPersonal student) {
		//SET ID
		int currentYear = getCurrentYear();
		int idsCount = studentPersonalRepository.getMaxIdByDateOfAdmission(currentYear);
		String newId = String.format("%d%d", 
				currentYear - 2000,
				idsCount + 1
		);
		student.setId(newId);
		
		//SET DATE OF ADMISSION
		String dateOfAdmission = getFormattedCurrentDate();
		student.setDateOfAdmission(dateOfAdmission);
		
		//SAVE IN DATABASE
		return studentPersonalRepository.save(student);
	}
	
	public StudentPersonal update(StudentPersonal updatedStudent) {
		Optional<StudentPersonal> stuOptional = findById(updatedStudent.getId());
		if(stuOptional.isPresent()) {
			return studentPersonalRepository.save(updatedStudent);
		}
		throw new IllegalArgumentException(updatedStudent.getId() + " was be found");
	}

	public Optional<StudentPersonal> findById(String id) {
		return studentPersonalRepository.findById(id);
	}
	
	public List<StudentPersonal> findAll() {
		return studentPersonalRepository.findAll();
	}
	
	
	private String getFormattedCurrentDate() {
		LocalDate dateNow = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return formatter.format(dateNow);
	}
	
	private int getCurrentYear() {
		LocalDate dateNow = LocalDate.now();
		return dateNow.getYear();
	}
}
