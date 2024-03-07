package com.example.pidev.repository;

import com.example.pidev.entities.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductOwnerReppository extends JpaRepository<ProductOwner, Integer> {
}
