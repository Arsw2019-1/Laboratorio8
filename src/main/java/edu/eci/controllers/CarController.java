package edu.eci.controllers;

import edu.eci.models.Car;
import edu.eci.services.contracts.ICarServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private ICarServices cars;
    
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getCar(){
        
        throw new NotImplementedException();
        
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createCar(@RequestBody Car car){
        try{
            return new ResponseEntity<>(cars.create(car), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateCar(@RequestBody Car car){
        try{
            return new ResponseEntity<>(cars.update(car), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteCar(@RequestBody String licencePlate){
        try{
            cars.eraser(licencePlate);
            return new ResponseEntity<>("SE PUDO ELIMINAR, 201", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
