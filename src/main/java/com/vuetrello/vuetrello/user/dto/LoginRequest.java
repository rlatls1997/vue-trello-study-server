package com.vuetrello.vuetrello.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginRequest {
	private final String email;
	private final String password;
}
