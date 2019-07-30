package com.system.user.repository;

import com.system.user.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    UserData findByPhoneNumber(String phoneNumber);

}