package com.firstproject.DemoProject.repository;

import com.firstproject.DemoProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
