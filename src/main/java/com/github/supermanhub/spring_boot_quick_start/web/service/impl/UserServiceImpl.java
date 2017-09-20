package com.github.supermanhub.spring_boot_quick_start.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.supermanhub.spring_boot_quick_start.web.entity.User;
import com.github.supermanhub.spring_boot_quick_start.web.repository.UserRepository;
import com.github.supermanhub.spring_boot_quick_start.web.service.UserService;

/**
 * User service implementation
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private @Autowired UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Assert.hasText(username, "User name must not be empty");

		User user = userRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("User is not found");
		} else {
			return user;
		}
	}

}
