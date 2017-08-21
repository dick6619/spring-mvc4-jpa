package com.iii.framework.core.tools.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * spring 自己的濾器實作的內容跟最後一樣
 * */
public class CharacterEncodingFilter implements Filter {
	private String encoding;

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		if (StringUtils.isBlank(encoding)) {
			encoding = "UTF-8";
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// request
		if (null == req.getCharacterEncoding()) {
			req.setCharacterEncoding(encoding);
		}
		// response
		res.setCharacterEncoding(encoding);
		// do
		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
	}

}
