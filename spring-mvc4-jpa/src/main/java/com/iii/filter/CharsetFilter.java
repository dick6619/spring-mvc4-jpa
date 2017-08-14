package com.iii.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;

public class CharsetFilter implements Filter {
	private String encoding;

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("charset");
		if (StringUtils.isBlank(encoding)) {
			encoding = "UTF-8";
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		res.setContentType("charset=" + encoding);
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
	}

}
