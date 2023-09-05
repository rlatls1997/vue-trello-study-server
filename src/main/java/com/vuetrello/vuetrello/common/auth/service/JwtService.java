package com.vuetrello.vuetrello.common.auth.service;

public interface JwtService {

	String createJwt(long userId);

	boolean isNotJwtValid(String jwt);
}
