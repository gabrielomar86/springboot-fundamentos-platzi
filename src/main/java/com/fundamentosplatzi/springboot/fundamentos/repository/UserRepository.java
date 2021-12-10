package com.fundamentosplatzi.springboot.fundamentos.repository;

import java.util.List;
import java.util.Optional;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = ?1")
    Optional<User> findByUserEmail(String email);

    @Query("select u from User u where u.name like ?1%")
    Optional<List<User>> findAndSort(String name, Sort sort);

    Optional<List<User>> findByName(String name);
}

