package com.mcb.creditfactory.controller;


import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.service.AssessedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AssessedValueController {

    @Autowired
    private AssessedValueService assessedValueService;

    @PostMapping("/collateral/av/save")
    public HttpEntity<AssessedValue> save(@RequestBody AssessedValue assessedValue) {
        AssessedValue newValue= assessedValueService.save(assessedValue);
        return newValue != null ? ResponseEntity.ok(newValue) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/collateral/av/all")
    public List<AssessedValue> findAll() {
       List<AssessedValue> avList=new ArrayList<>();
       avList=assessedValueService.findAll();
       return avList;
    }

    @GetMapping("/collateral/av/all/{id}")
    public List<AssessedValue> findAllById(@PathVariable("id") Long id) {
        List<AssessedValue> allList=new ArrayList<>();
        allList=assessedValueService.findByCollId(id);
        return allList;
    }

    @GetMapping("/collateral/av/{id}")
    public AssessedValue getInfo(@PathVariable("id") Long id) {
        AssessedValue assessedValue = assessedValueService.findFirst(id);
        return assessedValue;
    }

}