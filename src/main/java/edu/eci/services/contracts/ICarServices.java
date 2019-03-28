/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.services.contracts;

import edu.eci.models.Car;
import java.util.List;

/**
 *
 * @author dicom
 */
public interface ICarServices {
    
    List<Car> list();
    Car create(Car carro);
    Car create(String licencePlate, String brand);
    Car get(String licencePlate);
   
    
    Car update(Car carro);
    void eraser(String licencePlate);
    
}
