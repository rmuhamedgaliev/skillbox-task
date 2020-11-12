package dev.rmuhamedgaliev.service;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import dev.rmuhamedgaliev.cat.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Slf4j
class CatServiceTest {

    private final CatService catService = new CatService();

    private final int DEFAULT_COUNT_OF_CATS = 7;

    //    Создать 5-7 кошек
    @Test
    void generateCats() {
        List<Cat> cats = this.catService.generateCats(DEFAULT_COUNT_OF_CATS);

        assertEquals(DEFAULT_COUNT_OF_CATS, cats.size());
    }

    //    напечатайте в консоль вес созданных кошек
    @Test
    void printWeightOfCats() {
        List<Cat> cats = this.catService.generateCats(DEFAULT_COUNT_OF_CATS);

        String catsWeight = this.catService.printWeightOfCats(cats);

        assertFalse(catsWeight.isBlank());
    }

    //  покормите 2 кошки и после этого распечатать их вес (убедитесь что вес изменился)
    @Test
    void feedRandomCat() {
        List<Cat> cats = this.catService.generateCats(DEFAULT_COUNT_OF_CATS);

        Random random = new Random();

        IntStream.range(0, 2)
            .forEach(i -> {

                int catNumberForFeed = random.nextInt(cats.size() - 1);

                double catOldWeight = cats.get(catNumberForFeed).getWeight();

                double amountOfFood = random.nextDouble();
                cats.get(catNumberForFeed).feed(amountOfFood);

                assertNotEquals(catOldWeight, cats.get(catNumberForFeed).getWeight());
            });
    }

    //    "замяукайте" кошку до смерти
    @Test
    void meowUnderDeath() {
        List<Cat> cats = this.catService.generateCats(DEFAULT_COUNT_OF_CATS);

        Random random = new Random();

        int catId = random.nextInt(cats.size() - 1);

        Cat cat = cats.get(catId);

        while (!cat.getStatus().equals("Dead")) {
            cat.meow();
        }

        log.debug("Cat with id: {} is ded", catId);
    }

    //    перекормите кошку
    @Test
    void fedUnderDeath() {
        List<Cat> cats = this.catService.generateCats(DEFAULT_COUNT_OF_CATS);

        Random random = new Random();

        int catId = random.nextInt(cats.size() - 1);

        Cat cat = cats.get(catId);

        while (!cat.getStatus().equals("Exploded")) {
            double amountOfFood = random.nextDouble();
            cat.feed(amountOfFood);
        }

        log.debug("Cat with id: {} is dead", catId);
    }

//    Создать в классе Cat метод, который будет возвращать сумму съеденной еды текущей кошки
//    Создать в классе Cat метод “сходить в туалет” pee(), который будет уменьшать вес кошки и что-нибудь печатать.
//    Рекомендации: протестируйте верную работу метода возврата съеденной еды:
//
//    создайте кошку
//    покормите кошку кормом весом 150.00
//    вызовите метод pee() несколько раз
//    распечатайте значение съеденного корма, в консоль должно напечататься 150.00

    @Test
    void checkPee() {
        Cat cat = new Cat();

        double feedAmount = 150;
        cat.feed(feedAmount);

        assertEquals(feedAmount, cat.getCountOfEaten());

        int countOfPee = 5;

        double oldWeight = cat.getWeight();

        IntStream.range(0, countOfPee)
            .forEach(counter -> {
                cat.pee();
            });

        assertEquals(oldWeight - countOfPee, cat.getWeight());

    }
}