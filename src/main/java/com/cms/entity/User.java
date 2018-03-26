package com.cms.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String address;

	private int age;

	
	@Column(length=255)
	private String email;
	
	@Column(name="first_name", length=255)
	@NotEmpty(message = "*Please provide your name")
	private String firstName;

	@Column(length=255)
	private String gender;

	@Column(name="birth_date")
	private String birthDate;



	@Column(name="last_name", length=255)
	private String lastName;

	@Column(name="mobile_number", length=255)
	private String mobileNumber;

	@Column(length=255)
	private String password;

	@Column(length=255)
	private String status;

	@Column(name="user_name", length=255)
	private String userName;

	@Column(length=255)
	private int active;


	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Column(name="user_type")
	private int userType;

	//bi-directional many-to-one association to Instructor
	@OneToMany(mappedBy="user")
	private Set<Instructor> instructors;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="users")
	private Set<Role> roles;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="user")
	private Set<Student> students;

	
	
	
	
	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserType() {
		return this.userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public Set<Instructor> getInstructors() {
		return this.instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor addInstructor(Instructor instructor) {
		getInstructors().add(instructor);
		instructor.setUser(this);

		return instructor;
	}

	public Instructor removeInstructor(Instructor instructor) {
		getInstructors().remove(instructor);
		instructor.setUser(null);

		return instructor;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setUser(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setUser(null);

		return student;
	}

}