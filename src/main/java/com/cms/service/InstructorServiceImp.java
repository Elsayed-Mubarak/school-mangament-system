package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Instructor;
import com.cms.repository.InstructorRepository;

@Service
public class InstructorServiceImp implements InstructorService{

	@Autowired InstructorRepository instructorRepository;
	
	
	@Override
	public Instructor createInstructor(Instructor instructor) {
		return instructorRepository.saveAndFlush(instructor);
	}
	

}
