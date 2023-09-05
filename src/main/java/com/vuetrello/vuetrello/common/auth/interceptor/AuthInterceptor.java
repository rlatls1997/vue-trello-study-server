package com.vuetrello.vuetrello.common.auth.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.vuetrello.vuetrello.common.auth.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

	private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";

	private final JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (isOptionsMethod(request)) {
			return true;
		}

		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (authorizationHeader == null || authorizationHeader.isBlank()) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}

		if (request.getSession().getAttribute("id") == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}

		String jwt = authorizationHeader.substring(AUTHORIZATION_HEADER_PREFIX.length());

		if (jwtService.isNotJwtValid(jwt)) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}

		return true;
	}

	// preflight 요청처리
	public boolean isOptionsMethod(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString());
	}

}
