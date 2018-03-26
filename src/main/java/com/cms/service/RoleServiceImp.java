package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Role;
import com.cms.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired RoleRepository roleRepository;
	
	
	@Override
	public Role addUserRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

}
