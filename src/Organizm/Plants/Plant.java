package Organizm.Plants;

import Organizm.Animals.HerbivoreAnimals;

import java.util.Random;

public class Plant {
    private String name;
    private double weight;

    public Plant(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void grow () {
        Random random = new Random();
        int growth = random.nextInt(15) + 1;

        weight += growth;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) {
        weight = newWeight;
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
}
