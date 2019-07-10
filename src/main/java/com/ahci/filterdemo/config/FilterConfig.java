package com.ahci.filterdemo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ahci.filterdemo.filter.RequestDetailFilter;
import com.ahci.filterdemo.filter.UrlFilter;

@Configuration
public class FilterConfig {

	// UrlFilter will work before RequestDetailFilter for request test1 because it is defined before
	@Bean
	public FilterRegistrationBean<UrlFilter> loggingFilter() {
		FilterRegistrationBean<UrlFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new UrlFilter());

		registrationBean.addUrlPatterns("/filter/test1");
		registrationBean.addUrlPatterns("/filter/test2");

		return registrationBean;

	}
	
	@Bean
	public FilterRegistrationBean<RequestDetailFilter> loggingRequestDetailFilter() {
		FilterRegistrationBean<RequestDetailFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestDetailFilter());

		registrationBean.addUrlPatterns("/filter/test1");

		return registrationBean;

	}

}