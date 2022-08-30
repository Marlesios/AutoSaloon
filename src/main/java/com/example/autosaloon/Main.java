package com.example.autosaloon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Saloon saloon = new Saloon();


        new Thread(null, saloon::sellCar, "покупатель 1" ).start();
        new Thread(null, saloon::sellCar, "покупатель 2" ).start();
        new Thread(null, saloon::sellCar, "покупатель 3" ).start();
        new Thread(null, saloon::produceCar, "BMW").start();


    }


}
