package com.mehedi.maad.api.repositories;

import com.mehedi.maad.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
