package com.asliutkarsh.jsonvsproto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asliutkarsh.jsonvsproto.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
