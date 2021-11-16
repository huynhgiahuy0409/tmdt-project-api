package com.javatpoint.ecormspringboot.buyer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface ITokenAuthenticationService {
	Authentication getAuthentication(HttpServletRequest request);

	String getTokenFromHeader(HttpServletRequest request);
}
