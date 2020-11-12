package dev.rmuhamedgaliev.cat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat {

    private static int countOfCats;

    public boolean alive;

    private double originWeight;

    private double weight;

    private double minWeight;

    private double maxWeight;

    private double countOfEaten;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

        countOfCats++;
        alive = true;
    }

    public static int getCountOfCats() {
        return countOfCats;
    }

    public void meow() {
        if (isAlive()) {
            weight = weight - 1;
            log.info("Meow");
        }
    }

    public void pee() {
        if (isAlive()) {
            weight = weight - 1;
            log.info("Pee");
        }
    }

    public void feed(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            countOfEaten += amount;
        }
    }

    public void drink(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
        }
    }

    public double getCountOfEaten() {
        return countOfEaten;
    }

    public Double getWeight() {
        return weight;
    }

    public boolean isAlive() {
        if (weight < minWeight || weight > maxWeight & alive) {
            alive = false;
            countOfCats--;
            log.info("Cat is not alive");
        }

        return alive;
    }

    public String getStatus() {
        isAlive();
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}