package com.tayssir.cosmetiques.service;

import com.tayssir.cosmetiques.entities.Role;
import com.tayssir.cosmetiques.entities.User;

public interface UserService {
	void deleteAllusers();

	void deleteAllRoles();

	User saveUser(User user);

	User findUserByUsername(String username);

	Role addRole(Role role);

	User addRoleToUser(String username, String rolename);
}