package com.javatpoint.ecormspringboot.buyer.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.javatpoint.ecormspringboot.buyer.service.ITokenAuthenticationService;


/*Writing filter cho Security Web*/
/*OncePerRequestFilter chỉ thực hiện một lần filter trong mỗi request.*/
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	ITokenAuthenticationService tokenAuthenticationService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication authentication = this.tokenAuthenticationService.getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
	}

}
