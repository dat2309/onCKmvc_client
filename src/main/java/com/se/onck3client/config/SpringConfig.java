package com.se.onck3client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.se.onck3client")
@PropertySource("classpath:application.properties")
public class SpringConfig implements WebMvcConfigurer{
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");
		return view;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry handler) {
		
		handler.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	

}
