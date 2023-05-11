package com.crud.repository;

import com.crud.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users , Long> {
    Optional<Users> findByUserEmail(String userEmail);
}
