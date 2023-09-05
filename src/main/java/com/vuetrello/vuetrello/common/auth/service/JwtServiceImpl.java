package com.vuetrello.vuetrello.common.auth.service;

import java.time.Duration;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {

	private static final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz1234567890abcdefghijklmnopqrstuvwxyz";

	@Override
	public String createJwt(long userId) {
		Date now = new Date();

		return Jwts.builder()
			.setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
			.claim("id", userId)
			.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
			.compact();
	}

	public boolean isNotJwtValid(String jwt) {
		return !isJwtValid(jwt);
	}

	public boolean isJwtValid(String jwt) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(SECRET_KEY)
				.build()
				.parseClaimsJws(jwt)
				.getBody();

			return true;
		} catch (Exception exception) {
			return false;
		}
	}
}
