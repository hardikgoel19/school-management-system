package com.school.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_personal")
@Getter
@Setter
@NoArgsConstructor
public class StudentPersonal {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "middlename")
	private String middleName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "address_id")
	private String addressId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "aadhar")
	private String aadhar;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "date_of_admission")
	private String dateOfAdmission;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "mother_mobile")
	private String motherMobile;
	
	@Column(name = "mother_occupation")
	private String motherOccupation;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "father_mobile")
	private String fatherMobile;
	
	@Column(name = "father_occupation")
	private String fatherOccupation;
	
		
}
