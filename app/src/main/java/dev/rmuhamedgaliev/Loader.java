package dev.rmuhamedgaliev;

import dev.rmuhamedgaliev.cat.Cat;

public class Loader {

    public static void main(String[] args) {
        Cat cat = new Cat();

        System.out.println(cat.getStatus());
    }
}