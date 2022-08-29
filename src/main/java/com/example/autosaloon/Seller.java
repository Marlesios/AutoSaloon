package com.example.autosaloon;

public class Seller {

    private final Saloon saloon;
    int choosingTime = 1000;
    int producingTime = 6500;


    public Seller(Saloon saloon) {
        this.saloon = saloon;
    }


    public synchronized void producingCar() {

        try {

            System.out.println("новая машина в стадии производства");
            Thread.sleep(producingTime);
            saloon.getCars().add(new Car());
            System.out.println(Thread.currentThread().getName() + " выпустила новую машину и она уже доступна для покупки");
            notify();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void sellCars() {

        try {
            System.out.println(Thread.currentThread().getName() + " пришел купить тачку");
            Thread.sleep(choosingTime);
            while (saloon.getCars().isEmpty()) {
                System.out.println("в данный момент нет машин ");
                wait();
            }

            Thread.sleep(choosingTime);
            System.out.println(Thread.currentThread().getName() + " забрал свою машину");
            saloon.getCars().remove(0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
