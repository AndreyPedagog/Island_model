package Organizm.Animals;

import Island.Location;
import Organizm.Plants.Plant;

import java.text.DecimalFormat;
import java.util.Random;

public abstract class HerbivoreAnimals extends Animal implements Herbivore {
    private double foodRequired;

    public HerbivoreAnimals(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
        super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
        this.foodRequired = foodRequired;
    }
    @Override
    public void eatPlant(Plant plant) {

    }
    @Override
    public boolean canEatCaterpillar(Caterpillar caterpillar) {
        return false;
    }
    public double getFoodRequired() {
        return foodRequired;
    }



    public static class Horse extends HerbivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;

        public Horse(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 10;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }

        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 4;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Horse reproduce(Horse partner) {
            if (partner != null && !hasReproduce()) {
                Horse babyHorse = new Horse("Horse", 400, 20, 4, 60, 4);
                setReproduced(true);
                return babyHorse;
            } else {
                return null;
            }
        }

        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }
        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 60) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 60 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 60 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + foodToEat + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }
    }

    public static class Deer extends HerbivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;
        public Deer(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 7;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }
        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 4;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Deer reproduce(Animal partner) {
            if (partner instanceof Deer) {
                Deer babyDeer = new Deer("Deer", 300, 20, 4, 50, 4);
                return babyDeer;
            } else {
                return null;
            }
        }

        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 50) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 50 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 50 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + foodToEat + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }

        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }
        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }
    }

    public static class Rabbit extends HerbivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;

        public Rabbit(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 0.05;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }

        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 2;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Rabbit reproduce(Animal partner) {
            if (partner instanceof Rabbit) {
                Rabbit babyRabbit = new Rabbit("Rabbit", 2, 150, 2, 0.45, 2);
                return babyRabbit;
            } else {
                return null;
            }
        }

        public boolean canEatPlant(Plant plant) {

            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);
                DecimalFormat df = new DecimalFormat("#.###");

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 0.45) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 0.45 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 0.45 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + df.format(foodToEat) + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }



        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }

        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }
    }

    public static class Mouse extends HerbivoreAnimals implements Runnable {
        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;

        public Mouse(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 0.001;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }

        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Mouse reproduce(Mouse partner) {
            if (partner != null && !hasReproduce()) {
                Mouse babyMouse = new Mouse("Mouse", 0.05, 500, 1, 0.01, 1);
                setReproduced(true);
                return babyMouse;
            } else {
                return null;
            }
        }

        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }

        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean canEatCaterpillar(Caterpillar caterpillar) {
            return (getX() == caterpillar.getX() && getY() == caterpillar.getY());
        }

        public void eatCaterpillar(Caterpillar caterpillar) {
            if (caterpillar != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (caterpillar.getWeight() >= foodRequired) {
                    double foodToEat = maxFoodToEat;

                    if (foodToEat <= foodRequired) {
                        caterpillar.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        System.out.println(HerbivoreAnimals.Mouse.getName() + " з'їв " + HerbivoreAnimals.Caterpillar.getName() + " на координатах X= " + getX() + " Y= " + getY());
                    }
                }
            }
        }

        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }

        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();
                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                DecimalFormat df = new DecimalFormat("#.###");

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 0.01) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв " + df.format(foodToEat) + " кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 0.01 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + df.format(foodToEat) + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }
    }


    public static class Goat extends HerbivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;
        public Goat(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 1.5;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }
        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 3;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }

        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 10) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 10 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 10 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + foodToEat + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }


        public Goat reproduce(Animal partner) {
            if (partner instanceof Goat) {
                Goat babyGoat = new Goat("Goat", 60, 140, 3, 10, 3);
                return babyGoat;
            } else {
                return null;
            }
        }
    }


    public static class Sheep extends HerbivoreAnimals implements  Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;
        public Sheep(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 1.75;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }
        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 3;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }

        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 15) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 15 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 15 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + foodToEat + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }


        public Sheep reproduce(Animal partner) {
            if (partner instanceof Sheep) {
                Sheep babySheep = new Sheep("Sheep", 70, 140, 3, 15, 3);
                return babySheep;
            } else {
                return null;
            }
        }
    }

    public static class Boar extends HerbivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;
        public Boar(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 10;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }

        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 2;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }

        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 50) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 50 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 50 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + foodToEat + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        public Boar reproduce(Animal partner) {
            if (partner instanceof Boar) {
                Boar babyBoar = new Boar("Boar", 400, 50, 2, 50, 2);
                return babyBoar;
            } else {
                return null;
            }
        }
        public boolean canEatCaterpillar(Caterpillar caterpillar) {
            return (getX() == caterpillar.getX() && getY() == caterpillar.getY());
        }

        public void eatCaterpillar(Caterpillar caterpillar) {
            if (caterpillar != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (caterpillar.getWeight() >= foodRequired) {
                    double foodToEat = maxFoodToEat;

                    if (foodToEat <= foodRequired) {
                        caterpillar.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        System.out.println(HerbivoreAnimals.Boar.getName() + " з'їв " + HerbivoreAnimals.Caterpillar.getName() + " на координатах X= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }
    }

    public static class Buffalo extends HerbivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;
        public Buffalo(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 17.5;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }
        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 3;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }

        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 100) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 100 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 100 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + foodToEat + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }


        public Buffalo reproduce(Animal partner) {
            if (partner instanceof Buffalo) {
                Buffalo babyBuffalo = new Buffalo("Buffalo", 700, 10, 3, 100, 3);
                return babyBuffalo;
            } else {
                return null;
            }
        }
    }

    public static class Duck extends HerbivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;

        public Duck(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 0.025;
            initialWeight = weight;
            this.weight = weight;
            this.name = name;
        }
        public static String getName() {
            return name;
        }
        public double getWeight() {
            return weight;
        }

        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
        }

        public int getMaxSteps() {
            return 4;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
        public boolean canEatPlant(Plant plant) {
            if (plant != null) {
                return true;
            } else {
                return false;
            }
        }
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                double maxFoodToEat = initialWeight - weight;
                double foodToEat = Math.min(currentPlantWeight, maxFoodToEat);

                if (foodToEat <= foodRequired) {
                    if (foodToEat == 0.15) {
                        weight = initialWeight;
                        System.out.println(getName() + " з'їв 0.15 кг " + plant.getName() + " і повернув свою початкову вагу");
                    } else if (foodToEat < 0.15 && foodToEat > 0) {
                        plant.subtractWeight(foodToEat);
                        weight += foodToEat;
                        //System.out.println(getName() + " з'їв " + foodToEat + " кг " + plant.getName() + " на ділянці Х= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
        @Override
        public void run() {
            if (weight > 0.0) {
                moveRandom();
                weight -= weightLossRate;
            } else {
                die();
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
        }

        public void moveRandom() {
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }
        public boolean isEaten() {
            return eaten;
        }

        public void getEaten(CarnivoreAnimals animals) {
            if (animals != null) {
                eaten = true;
            }
        }


        public Duck reproduce(Animal partner) {
            if (partner instanceof Duck) {
                Duck babyDuck = new Duck("Duck", 1, 200, 4, 0.15, 4);
                return babyDuck;
            } else {
                return null;
            }
        }


        public boolean canEatCaterpillar(Caterpillar caterpillar) {
            return (getX() == caterpillar.getX() && getY() == caterpillar.getY());
        }

        public void eatCaterpillar(Caterpillar caterpillar) {
            if (caterpillar != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (caterpillar.getWeight() >= foodRequired) {
                    double foodToEat = maxFoodToEat;

                    if (foodToEat <= foodRequired) {
                        caterpillar.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        System.out.println(HerbivoreAnimals.Duck.getName() + " з'їв " + HerbivoreAnimals.Caterpillar.getName() + " на координатах X= " + getX() + " Y= " + getY());
                    }
                }
            }
        }
    }

    public static class Caterpillar extends HerbivoreAnimals implements Runnable {

        private static String name;
        private static double weight;
        public Caterpillar(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            this.weight = weight;
            this.name = name;
        }

        public static String getName() {
            return name;
        }

        public Caterpillar reproduce(Animal partner) {
            if (partner instanceof Caterpillar) {
                Caterpillar babyCaterpillar = new Caterpillar("Caterpillar", 0.01, 1000, 0, 0, 0);
                return babyCaterpillar;
            } else {
                return null;
            }
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public void run() {
        }
    }
    private boolean eaten = false;

    public boolean isEaten() {
        return eaten;
    }

    public void getEaten(Duck duck) {
        if (duck != null) {
            eaten = true;
        }
    }
    public void getEaten(Mouse mouse) {
        if (mouse != null) {
            eaten = true;
        }
    }
    public void getEaten(Boar boar) {
        if (boar != null) {
            eaten = true;
        }
    }

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
        }
    }
