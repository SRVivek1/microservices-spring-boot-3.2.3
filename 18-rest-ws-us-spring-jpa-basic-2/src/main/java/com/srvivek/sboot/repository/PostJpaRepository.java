package com.srvivek.sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srvivek.sboot.bean.Post;

@Repository
public interface PostJpaRepository extends JpaRepository<Post, Integer>{

}
