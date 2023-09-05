package com.vuetrello.vuetrello.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vuetrello.vuetrello.common.auth.service.JwtService;
import com.vuetrello.vuetrello.user.dto.LoginRequest;
import com.vuetrello.vuetrello.user.dto.LoginResponse;
import com.vuetrello.vuetrello.user.model.User;
import com.vuetrello.vuetrello.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final JwtService jwtService;

	private final UserService userService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest) {
		String email = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		User user = userService.findUser(email);

		if (user == null || !user.getPassword().equals(password)) {
			throw new IllegalStateException("login failed.");
		}

		httpServletRequest.getSession().setAttribute("id", user.getId());
		String jwt = jwtService.createJwt(user.getId());

		return ResponseEntity.ok(new LoginResponse(jwt));
	}
}
