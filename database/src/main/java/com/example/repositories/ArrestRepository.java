package com.example.repositories;

import com.example.entities.Arrest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrestRepository extends JpaRepository<Arrest, Long> {
}
