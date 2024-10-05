package com.example.repository;


import com.example.entity.Quize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizeDA extends JpaRepository<Quize,Long> {
}