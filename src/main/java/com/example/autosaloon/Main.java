package com.example.autosaloon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Saloon saloon = new Saloon();

        for (int i = 0; i < 6; i++) {
            new Thread(null, saloon::sellCar, "покупатель " + i).start();
            new Thread(null, saloon::produceCar, "BMW").start();
        }

    }


}
