package com.vuetrello.vuetrello.user.service;

import com.vuetrello.vuetrello.user.model.User;

public interface UserService {

	User findUser(String email);
}
