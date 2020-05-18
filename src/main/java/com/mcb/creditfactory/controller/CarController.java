package com.mcb.creditfactory.controller;

import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.service.AssessedValueService;
import com.mcb.creditfactory.service.car.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars/save")
    public HttpEntity<Car> save(@RequestBody Car car) {
        Car newCar = carService.save(car);
        return newCar != null ? ResponseEntity.ok(newCar) : ResponseEntity.badRequest().build();
    }


    @PostMapping("/cars/add/{id}")
    public HttpEntity<Car> addValue(@PathVariable("id") Long id, @RequestBody AssessedValueDto value) {
        Car car = carService.addValue(id, value);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/cars/{id}")
    public Car getInfo(@PathVariable("id") Long id) {
        Car car = carService.load(id).get();
        return car;
    }

    @GetMapping("/cars/all")
    public List<Car> getCarList() {
            List<Car> carList=new ArrayList<>();
            carList=carService.carList();
            return carList;
    }
}