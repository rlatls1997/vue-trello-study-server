package com.vuetrello.vuetrello.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vuetrello.vuetrello.user.model.User;

@Service
public class UserServiceImpl implements UserService {
	private static final List<User> users = List.of(
		User.builder()
			.id(1)
			.email("a@a.a")
			.password("password")
			.build(),
		User.builder()
			.id(2)
			.email("b@b.b")
			.password("password")
			.build(),
		User.builder()
			.id(3)
			.email("c@c.c")
			.password("password")
			.build());

	@Override
	public User findUser(String email) {
		return users.stream()
			.filter(user -> user.getEmail().equals(email))
			.findFirst()
			.orElse(null);
	}
}
