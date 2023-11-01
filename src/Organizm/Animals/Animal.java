package Organizm.Animals;

public class Animal {
    private static String name;
    static double weight;
    private int maxPopulation;
    private int maxSpeed;
    private double foodRequired;
    public double weightLossRate;
    private int maxSteps;

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

