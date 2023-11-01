package Organizm.Plants;

import Organizm.Animals.HerbivoreAnimals;

import java.util.Random;

public class Plant implements Runnable {
    private String name;
    private double weight;
    private double maxWeight;
    private int x; // Додайте поле для координати X
    private int y; // Додайте поле для координати Y

    public Plant(String name, double weight) {
        this.name = "Grass";
        this.weight = weight;
        this.maxWeight = 200;

    }

    public String getName() {
        return name;
    }
    @Override
    public void run() {
        while (weight < maxWeight) {
            grow();
            if (weight > maxWeight) {
                weight = maxWeight; // Обмежуємо вагу максимальним значенням
                System.out.println(name + " виросла до максимальної ваги на координатах X=" + x + ", Y=" + y);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void grow () {
        Random random = new Random();
        int growth = random.nextInt(15) + 1;

        weight += growth;
        System.out.println("Рослина виросла на: " + growth + " (Загальна вага: " + weight + " кг)");
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) {
        weight = newWeight;
    }
    public void subtractWeight(double amount) {
        if (amount > 0) {
            weight -= amount;
            if (weight < 0) {
                weight = 0; // Вага не може бути від'ємною
            }
        }
    }


    public void getEaten(HerbivoreAnimals eater, Plant plant) {
        double foodRequired = eater.getFoodRequired(); // Отримайте кількість їжі, яку потрібно тварині для насичення

        if (plant.getWeight() >= foodRequired) {
            // Якщо рослина має достатньо їжі для насичення тварини, тварина з'їдає всю рослину
            plant.setWeight(plant.getWeight() - foodRequired);
        } else {
            // Якщо рослини не вистачає для насичення, тварина з'їдає доступну кількість рослини
            eater.eatPlant(plant);
            plant.setWeight(0); // Вся рослина була з'їдена
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
