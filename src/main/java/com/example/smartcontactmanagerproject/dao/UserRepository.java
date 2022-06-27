package com.example.smartcontactmanagerproject.dao;

import com.example.smartcontactmanagerproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM USER WHERE email = :n", nativeQuery = true)
    User getUserByEmailNative(@Param("n") String email);
}
