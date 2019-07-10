package com.ahci.filterdemo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This filter will be installed with FilterConfig
 * and only work with the given urls
 * @author ahci
 *
 */

public class UrlFilter implements Filter {

	private final static Logger LOG = LoggerFactory.getLogger(UrlFilter.class);

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		LOG.info("Initializing filter :{}", this);
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		LOG.info("Before doFilter for req :{}", req.getRequestURI());
		chain.doFilter(request, response);
		LOG.info("After doFilter for req :{}", req.getRequestURI());
	}

	@Override
	public void destroy() {
		LOG.warn("Destructing filter :{}", this);
	}
}