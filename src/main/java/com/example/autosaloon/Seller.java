package com.example.autosaloon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {

    private final Saloon saloon;
    final Lock lock = new ReentrantLock(true);
    final Condition condition = lock.newCondition();
    private final int choosingTime = 1000;
    private final int producingTime = 6500;
    final private int cars = 3;
    private int count = 0;
    private int amount = 9;


    public Seller(Saloon saloon) {
        this.saloon = saloon;
    }


    public void producingCar() {
        for (int i = 0; i < amount; i++) {
            try {

                lock.lock();
                System.out.println("новая машина в стадии производства");
                Thread.sleep(producingTime);
                saloon.getCars().add(new Car());
                System.out.println(Thread.currentThread().getName() + " выпустила новую машину и она уже доступна для покупки");
                condition.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }
        }
    }

    public void sellCars() {
        for (int i = 0; i < cars; i++) {
            try {

                lock.lock();
                System.out.println(Thread.currentThread().getName() + " пришел купить тачку");
                Thread.sleep(choosingTime);
                while (saloon.getCars().size() == 0) {
                    System.out.println("в данный момент нет машин ");
                    condition.await();
                }

                Thread.sleep(choosingTime);
                System.out.println(Thread.currentThread().getName() + " забрал свою машину");
                saloon.getCars().remove(0);


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }

        }


    }
}
