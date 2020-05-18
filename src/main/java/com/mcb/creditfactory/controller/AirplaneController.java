package com.mcb.creditfactory.controller;


import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AirplaneController {

    private AirplaneService airplaneService;

    @Autowired
    public void setAirplaneService(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

        @PostMapping("/planes/save")
        public HttpEntity<Airplane> save(@RequestBody Airplane airplane) {
            Airplane newAirplane = airplaneService.save(airplane);
            return newAirplane != null ? ResponseEntity.ok(newAirplane) : ResponseEntity.badRequest().build();
        }


        @PostMapping("/planes/add/{id}")
        public HttpEntity<Airplane> addValue(@PathVariable("id") Long id, @RequestBody AssessedValueDto value) {
            Airplane airplane = airplaneService.addValue(id, value);
            return airplane!= null ? ResponseEntity.ok(airplane) : ResponseEntity.badRequest().build();
        }

        @GetMapping("/planes/{id}")
        public Airplane getInfo(@PathVariable("id") Long id) {
            Airplane airplane = airplaneService.load(id).get();
            return airplane;
        }

        @GetMapping("/planes/all")
        public List<Airplane> getAirplaneList() {
            List<Airplane> planeList=new ArrayList<>();
            planeList=airplaneService.airplaneList();
            return planeList;
        }
    }
