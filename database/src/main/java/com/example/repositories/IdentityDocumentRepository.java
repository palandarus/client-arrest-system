package com.example.repositories;

import com.example.entities.IdentityDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityDocumentRepository extends JpaRepository<IdentityDocument, Long> {
}
