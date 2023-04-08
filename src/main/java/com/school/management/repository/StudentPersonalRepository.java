package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.management.model.StudentPersonal;

@Repository
public interface StudentPersonalRepository extends JpaRepository<StudentPersonal, String>{
	
	@Query(" Select count(id) " 
			+ " From StudentPersonal studentpersonal where " 
			+ " studentpersonal.dateOfAdmission like %?1%")
	public int getMaxIdByDateOfAdmission(int year);
}
