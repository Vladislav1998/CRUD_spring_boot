package com.javapointers.repositories;

import com.javapointers.model.CD;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CDRepositories extends JpaRepository<CD,Integer> {

}
