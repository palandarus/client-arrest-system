package com.example.services;

import com.example.entities.BudjetDepartament;

public interface BudgetDepartmentService {
    public BudjetDepartament findByCode(Integer code);
    public String findFormatByCode(Integer code, Integer type);
}
