package com.vuetrello.vuetrello.user.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LoginResponse {
	private final String accessToken;

	public LoginResponse(String accessToken) {
		this.accessToken = accessToken;
	}
}
