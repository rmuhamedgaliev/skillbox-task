package dev.rmuhamedgaliev.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import dev.rmuhamedgaliev.cat.Cat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CatService {

    private final int SCALE_UP_TO_NUMBERS = 2;

    public List<Cat> generateCats(int countOfCats) {
        return IntStream.range(0, countOfCats)
            .mapToObj(range ->
                new Cat()
            )
            .collect(Collectors.toList());
    }

    public String printWeightOfCats(List<Cat> cats) {
        return IntStream.range(0, cats.size())
            .mapToObj(catNumber -> {
                Cat cat = cats.get(catNumber);

                return "Cat with id: " + catNumber + "weight: " + cat.getWeight() + "\n";
            })
            .collect(Collectors.joining()).strip();
    }
}
