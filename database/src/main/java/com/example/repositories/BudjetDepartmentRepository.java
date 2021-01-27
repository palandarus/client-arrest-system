package com.example.repositories;

import com.example.entities.BudjetDepartament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudjetDepartmentRepository extends JpaRepository<BudjetDepartament, Long> {
    BudjetDepartament findByCode(Integer code);
}
