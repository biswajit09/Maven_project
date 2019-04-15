package com.legato.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.legato.demo.pojo.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
