package com.example.utils;

import com.example.entities.BudjetDepartament;
import com.example.entities.IdentityDocument;
import com.example.entities.Person;
import com.example.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SampleData {

    private static final Logger logger= LoggerFactory.getLogger(SampleData.class);

    private ArrestRepository arrestRepository;
    private BudjetDepartmentRepository budjetDepartmentRepository;
    private IdentityDocumentRepository identityDocumentRepository;
    private PersonRepository personRepository;


    public SampleData(ArrestRepository arrestRepository, BudjetDepartmentRepository budjetDepartmentRepository,
                      IdentityDocumentRepository identityDocumentRepository, PersonRepository personRepository) {
        this.arrestRepository = arrestRepository;
        this.budjetDepartmentRepository = budjetDepartmentRepository;
        this.identityDocumentRepository = identityDocumentRepository;
        this.personRepository = personRepository;
    }


    @PostConstruct
    public void init(){

        IdentityDocument identDocPassportForFns=new IdentityDocument();
        identDocPassportForFns.setType(21);
        identDocPassportForFns.setTitle("Паспорт РФ   ");
        identDocPassportForFns.setFormat("\\d{2} \\d{2} \\d{6}");



        IdentityDocument identDocZagranPassportForFns=new IdentityDocument();
        identDocZagranPassportForFns.setType(22);
        identDocZagranPassportForFns.setTitle("Загранпаспорт РФ  ");
        identDocZagranPassportForFns.setFormat("\\d{2} \\d{6}");



        IdentityDocument identDocPassportForFssp=new IdentityDocument();
        identDocPassportForFssp.setType(70);
        identDocPassportForFssp.setTitle("Паспорт РФ   ");
        identDocPassportForFssp.setFormat("\\d{6}-\\d{2}");



        IdentityDocument identDocZagranPassportForFssp=new IdentityDocument();
        identDocZagranPassportForFssp.setType(80);
        identDocZagranPassportForFssp.setTitle("Загранпаспорт РФ  ");
        identDocZagranPassportForFssp.setFormat("\\d{2} \\d{2} \\d{6}");



        BudjetDepartament fns=new BudjetDepartament();
        fns.setCode(39);
        fns.setTitle("ФНС");
        fns.getIdentityDocuments().add(identDocPassportForFns);
        fns.getIdentityDocuments().add(identDocZagranPassportForFns);

        BudjetDepartament fssp=new BudjetDepartament();
        fssp.setCode(17);
        fssp.setTitle("ФССП");
        fssp.getIdentityDocuments().add(identDocPassportForFssp);
        fssp.getIdentityDocuments().add(identDocZagranPassportForFns);



        identityDocumentRepository.save(identDocPassportForFns);
        logger.info("Добавляем шаблон паспорта для ФНС:\n" + identDocPassportForFns);
        identityDocumentRepository.save(identDocZagranPassportForFns);
        logger.info("Добавляем шаблон загранпаспорта для ФНС:\n" + identDocZagranPassportForFns);
        identityDocumentRepository.save(identDocPassportForFssp);
        logger.info("Добавляем шаблон паспорта для ФССП:\n" + identDocPassportForFssp);
        identityDocumentRepository.save(identDocZagranPassportForFssp);
        logger.info("Добавляем шаблон загранпаспорта для ФССП:\n" + identDocZagranPassportForFns);

        budjetDepartmentRepository.save(fns);
        logger.info("Добвляем ФНС:\n" + fns);
        budjetDepartmentRepository.save(fssp);
        logger.info("Добавляем ФССП:\n" + fssp);

        IdentityDocument p1Passport=new IdentityDocument();
        p1Passport.setTitle("Паспорт РФ   ");
        p1Passport.setNumberSeries("111111 11 11");
        p1Passport.setType(1);
        IdentityDocument p2Passport=new IdentityDocument();
        p2Passport.setTitle("Паспорт РФ   ");
        p2Passport.setType(1);
        p2Passport.setNumberSeries("222222 22 22");
        IdentityDocument p1ZagranPassport=new IdentityDocument();
        p1ZagranPassport.setTitle("Загранпаспорт РФ  ");
        p1ZagranPassport.setNumberSeries("111111 11");
        p1ZagranPassport.setType(2);
        IdentityDocument p2ZagranPassport=new IdentityDocument();
        p2ZagranPassport.setTitle("Загранпаспорт РФ  ");
        p2ZagranPassport.setNumberSeries("222222 22");
        p2ZagranPassport.setType(2);

        identityDocumentRepository.save(p1Passport);
        logger.info("Сохраняем паспорт Клиента 1:\n"+p1Passport);
        identityDocumentRepository.save(p1ZagranPassport);
        logger.info("Сохраняем загранпаспорт Клиента 1:\n"+p1ZagranPassport);
        identityDocumentRepository.save(p2Passport);
        logger.info("Сохраняем паспорт Клиента 2:\n"+p2Passport);
        identityDocumentRepository.save(p2ZagranPassport);
        logger.info("Сохраняем загранпаспорт Клиента 2:\n"+p2ZagranPassport);

        Person p1=new Person();
        p1.setFirstName("Андрей");
        p1.setLastName("Иванов");
        p1.getIdentDocList().add(p1Passport);
        p1.getIdentDocList().add(p1ZagranPassport);

        Person p2=new Person();
        p2.setFirstName("Михаил");
        p2.setLastName("Михайлович");
        p2.getIdentDocList().add(p2Passport);
        p2.getIdentDocList().add(p2ZagranPassport);

        personRepository.save(p1);
        logger.info("Добавляем Клиента 1:\n"+p1);
        personRepository.save(p2);
        logger.info("Добавляем клиента 2:\n"+p2);
    }



}
