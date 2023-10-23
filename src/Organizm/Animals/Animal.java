package Organizm.Animals;

import Island.Location;
import Organizm.Plants.Plant;

import java.util.Random;

public abstract class Animal {
    private String name;
    double weight; // Вага тварини, кг
    private int maxPopulation; // Максимальна кількість тварин цього виду на одній клітинці
    private int maxSpeed; // Швидкість переміщення, не більше ніж клітинок за хід
    private double foodRequired; // Скільки кілограмів їжі потрібно тварині для повного насичення
    public double weightLossRate; // Поле для швидкості втрати ваги

    private int x; // Положення тварини на X-координаті
    private int y; // Положення тварини на Y-координаті
    private int maxSteps; // Максимальна кількість кроків, яку тварина може зробити

    public Animal(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
        this.name = name;
        this.weight = weight;
        this.maxPopulation = maxPopulation;
        this.maxSpeed = maxSpeed;
        this.foodRequired = foodRequired;
        this.maxSteps = maxSteps;
    }

    public void run() {
        while (true) {
            moveRandom(); // Виклик методу для випадкового переміщення
            weight -= weightLossRate; // Втрата ваги на кожному такті
            if (weight <= 0) {
                die(); // Якщо вага опускається до нуля або менше, тварина помирає
            }
            // Інша логіка тварини
        }
    }

    public String getName() {
        return name;
    }

    public void die() {
        // Логіка смерті тварини
        System.out.println(getName() + " помер.");
        // Додаткова логіка, яку ви хочете виконати при смерті тварини
    }

    public boolean canReproduce() {
        return false;
    }

    public Animal reproduce(Animal partner) {
        return partner;
    }

    public double getWeight() {
        return weight;
    }

    private void moveRandom() {
        Random random = new Random();
        int randomX = random.nextInt(maxSteps * 2 + 1) - maxSteps;
        int randomY = random.nextInt(maxSteps * 2 + 1) - maxSteps;

        // Встановлення нового положення
        int newX = x + randomX;
        int newY = y + randomY;

        // Перевірка, щоб не виходити за межі локації
        if (newX >= 0 && newX < Location.getWidth()) {
            x = newX;
        }
        if (newY >= 0 && newY < Location.getHeight()) {
            y = newY;
        }
    }
}

