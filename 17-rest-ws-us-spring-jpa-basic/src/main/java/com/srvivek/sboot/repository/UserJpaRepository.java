package com.srvivek.sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srvivek.sboot.bean.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>{

}
