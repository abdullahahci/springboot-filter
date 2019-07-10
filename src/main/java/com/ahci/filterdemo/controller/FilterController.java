package com.ahci.filterdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FilterController {

	private static final Logger LOG = LoggerFactory.getLogger(FilterController.class);

	@GetMapping("/test1")
	public String getFilterTest1() {
		LOG.info("This filter will use UrlFilter, RequestDetailFilter and ComponentFilter");
		return "test1";
	}

	@GetMapping("/test2")
	public String getFilterTest2() {
		LOG.info("This filter will only use UrlFilter and ComponentFilter");
		return "test2";
	}
	
	@GetMapping("/test3")
	public String getFilterTest3() {
		LOG.info("This filter will only use ComponentFilter registered with config");
		return "test3";
	}
}