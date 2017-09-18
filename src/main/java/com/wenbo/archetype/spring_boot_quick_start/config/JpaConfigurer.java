package com.wenbo.archetype.spring_boot_quick_start.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import com.wenbo.archetype.spring_boot_quick_start.support.jpa.CustomRepositoryFactoryBean;
import com.wenbo.archetype.spring_boot_quick_start.support.jpa.SpringSecurityAuditorAware;
import com.wenbo.archetype.spring_boot_quick_start.web.entity.User;


/**
 * <b>Custom Spring Data JPA Configuration</b><br>
 * If you use default JPA, then you can delete this configuration.<br>
 * 
 * I provider 2 ways to setup the custom JPA repositories implementation, the
 * 1st is recommended.<br>
 * Because of Spring Boot tries to guess the location of your {@link Repository}
 * , based on the {@link EnableAutoConfiguration} annotation it finds. So if you
 * don't place {@link EnableJpaRepositories} annotation below
 * {@link EnableAutoConfiguration}, you have declare the basePackages
 * explicitly.
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.wenbo.archetype.spring_boot_quick_start.web.repository", repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
// @EnableJpaRepositories(basePackages =
// "com.wenbo.archetype.spring_boot_quick_start.web.repository",
// repositoryBaseClass = CustomJpaRepositoryImpl.class)
@EnableJpaAuditing
public class JpaConfigurer {

	@Bean
	public AuditorAware<User> auditorAware() {
		return new SpringSecurityAuditorAware();
	}
}
