package com.siva.prodapp.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.prodapp.dao.UsedCarDao;
import com.siva.prodapp.dto.Cars;

@RestController
@RequestMapping("/cars")
public class Controller {

    @Autowired
    private UsedCarDao usedCarDao;

    @GetMapping("/")
    public ResponseEntity<List<Cars>> getAllCars() {
        List<Cars> cars = usedCarDao.findAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/company/{companyName}")
    public ResponseEntity<List<Cars>> getCarsByCompany(@PathVariable String companyName) {
        List<Cars> cars = usedCarDao.findByCompanyName(companyName);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/fueltype/{fuelType}")
    public ResponseEntity<List<Cars>> getCarsByFuelType(@PathVariable String fuelType) {
        List<Cars> cars = usedCarDao.findByFuelType(fuelType);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Cars> addCar(@RequestBody Cars car) {
    Cars savedCar = usedCarDao.save(car);
    return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
}

    @PutMapping("/{id}")
    public ResponseEntity<Cars> updateCar(@PathVariable String id, @RequestBody Cars car) {
        Optional<Cars> carOptional = usedCarDao.findById(id);
        Cars carToUpdate = carOptional.orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    carToUpdate.setName(car.getName());
    carToUpdate.setCompanyName(car.getCompanyName());
    carToUpdate.setYear(car.getYear());
    carToUpdate.setPrice(car.getPrice());
    carToUpdate.setKmsDriven(car.getKmsDriven());
    carToUpdate.setFuelType(car.getFuelType());

    Cars updatedCar = usedCarDao.save(carToUpdate);
    return new ResponseEntity<>(updatedCar, HttpStatus.OK);
}
}
