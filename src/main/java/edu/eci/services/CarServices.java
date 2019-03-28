/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.services;

import edu.eci.models.Car;
import edu.eci.services.contracts.ICarServices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author dicom
 */

@Component
public class CarServices implements ICarServices {

    //public static List<Car> ListCarContainer;
    Map<String, String> CarContainer = new HashMap<String, String>();

    @Override
    public List<Car> list() {
        List<Car> temp = new ArrayList<Car>();
        Iterator it = CarContainer.keySet().iterator();
        while (it.hasNext()) {
            String key =(String) it.next();
            Car tem=new Car(key,CarContainer.get(key));
            temp.add(tem);
        }

        return temp;
    }
    @Override
    public Car create(Car carro) {
        CarContainer.put(carro.getLicencePlate(), carro.getBrand());
        return carro;
    }
    @Override
    public Car create(String licencePlate, String brand) {
        
        Car c = new Car(licencePlate, brand);
        CarContainer.put(licencePlate, brand);
        return c;
    }

    @Override
    public Car get(String licencePlate) {
        String temp = CarContainer.get(licencePlate);
        Car p = new Car(licencePlate, temp);
        return p;
    }

    @Override
    public Car update(Car carro) {
        String temp = CarContainer.get(carro.getLicencePlate());// temp iguala bbrand(marca)
        CarContainer.remove(carro.getLicencePlate());
        CarContainer.put(carro.getLicencePlate(), temp);
        return carro;
    }

    @Override
    public void eraser(String licencePlate) {
        CarContainer.remove(licencePlate);
    }



}
