package com.javapointers.repositories;

import com.javapointers.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtistRepository extends JpaRepository<Artist,Integer> {
}
