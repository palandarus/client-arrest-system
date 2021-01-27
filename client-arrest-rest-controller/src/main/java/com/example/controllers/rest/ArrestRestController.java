package com.example.controllers.rest;


import com.example.controllers.rest.Model.Answer;
import com.example.controllers.rest.Model.IdentDoc;
import com.example.entities.Arrest;
import com.example.services.ArrestService;
import com.example.services.BudgetDepartmentService;
import com.example.services.PersonService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/arrests/api/v1")
public class ArrestRestController {

    private ArrestService arrestService;
    private BudgetDepartmentService budjetDepartamentService;
    private PersonService personService;


    public ArrestRestController(ArrestService arrestService, BudgetDepartmentService budjetDepartamentService, PersonService personService) {
        this.arrestService = arrestService;
        this.budjetDepartamentService = budjetDepartamentService;
        this.personService = personService;
    }


    @PostMapping(value="/arrestmanage",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public Answer arrestManage(
            @RequestBody String requestId,
            @RequestBody String lastName,
            @RequestBody String firstName,
            @RequestBody IdentDoc identDoc,
            @RequestBody Integer organCode,
            @RequestBody Arrest arrest
    ) {
        arrest.setId(0L);
        StringBuilder resultText = new StringBuilder();
        StringBuilder numberSeries = new StringBuilder(100);
        Integer resultCode = 0;
        Integer arrestId = 0;
        String docNumberSeriesFormat;

        docNumberSeriesFormat = budjetDepartamentService.findFormatByCode(organCode, identDoc.getType());

        if (!Pattern.matches(docNumberSeriesFormat, identDoc.getNumberSeries())) {
            resultCode = 3;
            resultText.append("Numberseries does not match Organ number series format\n");
            return new Answer(arrestId, resultCode, resultText.toString());
        } else {
            String incomingDocNum = identDoc.getNumberSeries();

            for (char ch : incomingDocNum.toCharArray()) {
                if (ch >= '0' && ch <= '9') {
                    numberSeries.append(ch);
                } else {
                    if (numberSeries.length() == 6) break;
                    else numberSeries.setLength(0);
                }
            }


            incomingDocNum = incomingDocNum.replaceAll("\\d{6}", "");
            incomingDocNum = incomingDocNum.replaceAll(".", "");
            incomingDocNum = incomingDocNum.replaceAll("-", "");
            incomingDocNum = incomingDocNum.trim();

            numberSeries.insert(0, " " + incomingDocNum);
        }
        if (firstName.length() > 100 || lastName.length() > 100 || arrest.getDocNum().length() > 30 || arrest.getPurpose().length() > 100) {
            resultCode = 3;
            resultText.append("FirstName or Lastname or DocNum or Purpose too long");
            return new Answer(arrestId, resultCode, resultText.toString());
        }
        String regexForName = "[а-яёА-ЯЁ]+";
        Pattern pattern = Pattern.compile(regexForName);
        Matcher m = pattern.matcher(firstName);
        if (m.find()) {
            resultCode = 3;
            resultText.append("FirstName has wrong characters\n");
            return new Answer(arrestId, resultCode, resultText.toString());
        }

        String regexForDocNum = "[а-яёa-zА-ЯЁA-Z#№-]+";
        pattern = Pattern.compile(regexForName);
        m = pattern.matcher(arrest.getDocNum());
        if (m.find()) {
            resultCode = 3;
            resultText.append("DocNum has wrong characters\n");
            return new Answer(arrestId, resultCode, resultText.toString());
        }


        return new Answer(arrestId, resultCode, resultText.toString());
    }


}
