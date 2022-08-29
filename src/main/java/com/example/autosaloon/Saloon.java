package com.example.autosaloon;

import java.util.ArrayList;
import java.util.List;

public class Saloon {

    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>();

    public void sellCar() {
        seller.sellCars();
    }

    public void produceCar() {
        seller.producingCar();

    }

    public List<Car> getCars() {
        return cars;
    }


}
