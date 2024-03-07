package com.example.pidev.repository;

import com.example.pidev.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository <Test,Integer> {
}
