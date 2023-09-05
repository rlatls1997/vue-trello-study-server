package com.vuetrello.vuetrello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.vuetrello.vuetrello.common.auth.interceptor.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebAppConfiguration implements WebMvcConfigurer {

	private final AuthInterceptor authInterceptor;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:3000")
			.allowCredentials(true);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/login");
	}
}
