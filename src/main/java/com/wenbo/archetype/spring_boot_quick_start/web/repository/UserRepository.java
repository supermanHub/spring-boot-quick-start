package com.wenbo.archetype.spring_boot_quick_start.web.repository;

import com.wenbo.archetype.spring_boot_quick_start.support.jpa.CustomJpaRepository;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.User;

/**
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */
public interface UserRepository extends CustomJpaRepository<User, Long> {

	/**
	 * Find user by username
	 * 
	 */
	public User findByUsername(String username);
}
