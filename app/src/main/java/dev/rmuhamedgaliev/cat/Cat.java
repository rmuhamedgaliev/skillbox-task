package dev.rmuhamedgaliev.cat;

<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat implements Cloneable {

    private static final double DEFAULT_KITTEN_WEIGHT = 1100.0;

    private static int countOfCats;

    private final int NUMBER_OF_EYES = 2;

    private final double MIN_WEIGHT = 1000.0;

    private final double MAX_WEIGHT = 9000.0;

    public boolean alive;
=======
public class Cat {
>>>>>>> master

    private double originWeight;

    private double weight;

    private double minWeight;

    private double maxWeight;

<<<<<<< HEAD
    private Color color = Color.BLACK;

    private double countOfEaten;

    private boolean hasTail = true;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = MIN_WEIGHT;
        maxWeight = MAX_WEIGHT;

        countOfCats++;
        alive = true;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        this.originWeight = weight;
    }

    public static int getCountOfCats() {
        return countOfCats;
    }

    public static Cat getKitten() {
        return new Cat(DEFAULT_KITTEN_WEIGHT);
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
=======
    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        weight = weight + amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
>>>>>>> master
    }

    public Double getWeight() {
        return weight;
    }

<<<<<<< HEAD
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
=======
    public String getStatus() {
>>>>>>> master
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

    public int getCountOfEye() {
        return NUMBER_OF_EYES;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean hasTail() {
        return hasTail;
    }

    @Override
    public Cat clone() throws CloneNotSupportedException {
        Cat cat = (Cat) super.clone();

        cat.weight = this.weight;
        cat.color = this.color;
        cat.hasTail = this.hasTail;
        cat.originWeight = this.originWeight;
        cat.minWeight = this.minWeight;
        cat.maxWeight = this.maxWeight;

        return cat;
    }
}