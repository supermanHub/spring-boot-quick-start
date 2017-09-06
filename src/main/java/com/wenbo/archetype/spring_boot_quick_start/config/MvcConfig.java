package com.wenbo.archetype.spring_boot_quick_start.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * MVC configurations of application.
 * 
 * You can configure your application MVC features by this class when .yml file
 * configurations can not meet your requirement
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addFormatters(FormatterRegistry registry) {

		registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
	}
}
