package com.tayssir.cosmetiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tayssir.cosmetiques.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
