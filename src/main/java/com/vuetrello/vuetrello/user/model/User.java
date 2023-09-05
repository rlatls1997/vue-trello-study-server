package com.vuetrello.vuetrello.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {
	private final long id;
	private final String email;
	private final String password;
}
