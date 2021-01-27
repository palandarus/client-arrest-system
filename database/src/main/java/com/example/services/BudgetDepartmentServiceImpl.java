package com.example.services;

import com.example.entities.BudjetDepartament;
import com.example.entities.IdentityDocument;
import com.example.repositories.BudjetDepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetDepartmentServiceImpl implements BudgetDepartmentService {

    private BudjetDepartmentRepository budjetDepartmentRepository;

    public BudgetDepartmentServiceImpl() {
    }

    public BudgetDepartmentServiceImpl(BudjetDepartmentRepository budjetDepartmentRepository) {
        this.budjetDepartmentRepository = budjetDepartmentRepository;
    }

    @Override
    public BudjetDepartament findByCode(Integer code) {
        return budjetDepartmentRepository.findByCode(code);
    }

    @Override
    public String findFormatByCode(Integer code, Integer type) {
        BudjetDepartament budjetDepartament = findByCode(code);
        int indexDoc = findIndexDoc(budjetDepartament, type);
        if(indexDoc==-1) throw new RuntimeException("There is no IdentDoc in organ with code= "+code+"and type = "+ type);
        return budjetDepartament.getIdentityDocuments().get(indexDoc).getFormat();
    }



    public int findIndexDoc(BudjetDepartament budjetDepartament, Integer type) {
        return budjetDepartament.getIdentityDocuments().indexOf(new IdentityDocument(type)); //вставить проверку на null
    }


}
