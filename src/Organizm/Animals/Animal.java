package Organizm.Animals;

import Island.Location;
import Organizm.Plants.Plant;

import java.util.List;
import java.util.Random;

public class Animal {
    private static String name;
    static double weight; // Вага тварини, кг
    private int maxPopulation; // Максимальна кількість тварин цього виду на одній клітинці
    private int maxSpeed; // Швидкість переміщення, не більше ніж клітинок за хід
    private double foodRequired; // Скільки кілограмів їжі потрібно тварині для повного насичення
    public double weightLossRate; // Поле для швидкості втрати ваги
    private int maxSteps; // Максимальна кількість кроків, яку тварина може зробити

    public Animal(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
        this.name = name;
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.foodRequired = foodRequired;
        this.maxSteps = maxSteps;
    }


    public static String getName() {
        return name;
    }


    public boolean canReproduce() {
        return false;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

}

