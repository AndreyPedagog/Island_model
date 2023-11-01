package Organizm.Animals;

import Island.Location;

import java.util.Random;

public class CarnivoreAnimals extends Animal {
    private double foodRequired;

    public CarnivoreAnimals(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {

        super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
        this.foodRequired = foodRequired;
    }

    public double getFoodRequired() {
        return foodRequired;
    }



    public static class Wolf extends CarnivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;

        public Wolf(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 1.25;
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
        public Wolf reproduce(Wolf partner) {
            if (partner != null && !hasReproduce()) {
                Wolf babyWolf = new Wolf("Wolf", 50, 30, 3, 8, 3);
                setReproduced(true);
                return babyWolf;
            } else {
                return null;
            }
        }
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

        public boolean canEatMouse(HerbivoreAnimals.Mouse mouse) {
            return (getX() == mouse.getX() && getY() == mouse.getY());
        }
        public void eatMouse(HerbivoreAnimals.Mouse mouse) {
            if (mouse != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (mouse.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, mouse.getWeight());

                    if (foodToEat > 0) {
                        mouse.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        mouse.setWeight(mouse.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Mouse.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }

        public boolean canEatHorse(HerbivoreAnimals.Horse horse) {
            return (getX() == horse.getX() && getY() == horse.getY());
        }
        public void eatHorse(HerbivoreAnimals.Horse horse) {
            if (horse != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (horse.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, horse.getWeight());

                    if (foodToEat > 0) {
                        horse.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        horse.setWeight(horse.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Horse.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }

        public boolean canEatDeer(HerbivoreAnimals.Deer deer) {
            return (getX() == deer.getX() && getY() == deer.getY());
        }
        public void eatDeer(HerbivoreAnimals.Deer deer) {
            if (deer!= null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (deer.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, deer.getWeight());

                    if (foodToEat > 0) {
                        deer.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        deer.setWeight(deer.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Deer.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            return (getX() == rabbit.getX() && getY() == rabbit.getY());
        }
        public void eatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            if (rabbit != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (rabbit.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, rabbit.getWeight());

                    if (foodToEat > 0) {
                        rabbit.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        rabbit.setWeight(rabbit.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Rabbit.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatGoat(HerbivoreAnimals.Goat goat) {
            return (getX() == goat.getX() && getY() == goat.getY());
        }
        public void eatGoat(HerbivoreAnimals.Goat goat) {
            if (goat != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (goat.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, goat.getWeight());

                    if (foodToEat > 0) {
                        goat.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        goat.setWeight(goat.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Goat.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatSheep(HerbivoreAnimals.Sheep sheep) {
            return (getX() == sheep.getX() && getY() == sheep.getY());
        }
        public void eatSheep(HerbivoreAnimals.Sheep sheep) {
            if (sheep != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (sheep.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, sheep.getWeight());

                    if (foodToEat > 0) {
                        sheep.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        sheep.setWeight(sheep.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Sheep.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatBoar(HerbivoreAnimals.Boar boar) {
            return (getX() == boar.getX() && getY() == boar.getY());
        }
        public void eatBoar(HerbivoreAnimals.Boar boar) {
            if (boar != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (boar.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, boar.getWeight());

                    if (foodToEat > 0) {
                        boar.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        boar.setWeight(boar.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Boar.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatBuffalo(HerbivoreAnimals.Buffalo buffalo) {
            return (getX() == buffalo.getX() && getY() == buffalo.getY());
        }
        public void eatBuffalo(HerbivoreAnimals.Buffalo buffalo) {
            if (buffalo != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (buffalo.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, buffalo.getWeight());

                    if (foodToEat > 0) {
                        buffalo.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        buffalo.setWeight(buffalo.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Buffalo.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatDuck(HerbivoreAnimals.Duck duck) {
            return (getX() == duck.getX() && getY() == duck.getY());
        }
        public void eatDuck(HerbivoreAnimals.Duck duck) {
            if (duck != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (duck.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, duck.getWeight());

                    if (foodToEat > 0) {
                        duck.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        duck.setWeight(duck.getWeight() - foodToEat);
                        System.out.println(Wolf.getName() + " з'їв " + HerbivoreAnimals.Duck.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
    }

    public static class Snake extends CarnivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;

        public Snake(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 1.25;
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
        public Snake reproduce(Snake partner) {
            if (partner != null && !hasReproduce()) {
                Snake babySnake = new Snake("Snake", 15, 30, 1, 3, 1);
                setReproduced(true);
                return babySnake;
            } else {
                return null;
            }
        }
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

        public boolean canEatMouse(HerbivoreAnimals.Mouse mouse) {
            return (getX() == mouse.getX() && getY() == mouse.getY());
        }
        public void eatMouse(HerbivoreAnimals.Mouse mouse) {
            if (mouse != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (mouse.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, mouse.getWeight());

                    if (foodToEat > 0) {
                        mouse.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        mouse.setWeight(mouse.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Mouse.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            return (getX() == rabbit.getX() && getY() == rabbit.getY());
        }
        public void eatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            if (rabbit != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (rabbit.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, rabbit.getWeight());

                    if (foodToEat > 0) {
                        rabbit.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        rabbit.setWeight(rabbit.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Rabbit.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatDuck(HerbivoreAnimals.Duck duck) {
            return (getX() == duck.getX() && getY() == duck.getY());
        }
        public void eatDuck(HerbivoreAnimals.Duck duck) {
            if (duck != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (duck.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, duck.getWeight());

                    if (foodToEat > 0) {
                        duck.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        duck.setWeight(duck.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Duck.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
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

    public static class Fox extends CarnivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;
        private boolean eaten = false;

        public Fox(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 0.2;
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
        public Fox reproduce(Fox partner) {
            if (partner != null && !hasReproduce()) {
                Fox babyFox = new Fox("Fox", 8, 30, 2, 2, 2);
                setReproduced(true);
                return babyFox;
            } else {
                return null;
            }
        }
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

        public boolean canEatMouse(HerbivoreAnimals.Mouse mouse) {
            return (getX() == mouse.getX() && getY() == mouse.getY());
        }
        public void eatMouse(HerbivoreAnimals.Mouse mouse) {
            if (mouse != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (mouse.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, mouse.getWeight());

                    if (foodToEat > 0) {
                        mouse.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        mouse.setWeight(mouse.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Mouse.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            return (getX() == rabbit.getX() && getY() == rabbit.getY());
        }
        public void eatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            if (rabbit != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (rabbit.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, rabbit.getWeight());

                    if (foodToEat > 0) {
                        rabbit.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        rabbit.setWeight(rabbit.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Rabbit.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatDuck(HerbivoreAnimals.Duck duck) {
            return (getX() == duck.getX() && getY() == duck.getY());
        }
        public void eatDuck(HerbivoreAnimals.Duck duck) {
            if (duck != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (duck.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, duck.getWeight());

                    if (foodToEat > 0) {
                        duck.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        duck.setWeight(duck.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Duck.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
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
    public static class Bear extends CarnivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;

        public Bear(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 12.5;
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
        public Bear reproduce(Bear partner) {
            if (partner != null && !hasReproduce()) {
                Bear babyBear = new Bear("Bear", 500, 5, 2, 80, 2);
                setReproduced(true);
                return babyBear;
            } else {
                return null;
            }
        }
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

        public boolean canEatMouse(HerbivoreAnimals.Mouse mouse) {
            return (getX() == mouse.getX() && getY() == mouse.getY());
        }
        public void eatMouse(HerbivoreAnimals.Mouse mouse) {
            if (mouse != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (mouse.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, mouse.getWeight());

                    if (foodToEat > 0) {
                        mouse.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        mouse.setWeight(mouse.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Mouse.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }

        public boolean canEatHorse(HerbivoreAnimals.Horse horse) {
            return (getX() == horse.getX() && getY() == horse.getY());
        }
        public void eatHorse(HerbivoreAnimals.Horse horse) {
            if (horse != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (horse.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, horse.getWeight());

                    if (foodToEat > 0) {
                        horse.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        horse.setWeight(horse.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Horse.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }

        public boolean canEatDeer(HerbivoreAnimals.Deer deer) {
            return (getX() == deer.getX() && getY() == deer.getY());
        }
        public void eatDeer(HerbivoreAnimals.Deer deer) {
            if (deer!= null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (deer.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, deer.getWeight());

                    if (foodToEat > 0) {
                        deer.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        deer.setWeight(deer.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Deer.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            return (getX() == rabbit.getX() && getY() == rabbit.getY());
        }
        public void eatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            if (rabbit != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (rabbit.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, rabbit.getWeight());

                    if (foodToEat > 0) {
                        rabbit.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        rabbit.setWeight(rabbit.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Rabbit.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatGoat(HerbivoreAnimals.Goat goat) {
            return (getX() == goat.getX() && getY() == goat.getY());
        }
        public void eatGoat(HerbivoreAnimals.Goat goat) {
            if (goat != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (goat.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, goat.getWeight());

                    if (foodToEat > 0) {
                        goat.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        goat.setWeight(goat.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Goat.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatSheep(HerbivoreAnimals.Sheep sheep) {
            return (getX() == sheep.getX() && getY() == sheep.getY());
        }
        public void eatSheep(HerbivoreAnimals.Sheep sheep) {
            if (sheep != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (sheep.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, sheep.getWeight());

                    if (foodToEat > 0) {
                        sheep.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        sheep.setWeight(sheep.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Sheep.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatBoar(HerbivoreAnimals.Boar boar) {
            return (getX() == boar.getX() && getY() == boar.getY());
        }
        public void eatBoar(HerbivoreAnimals.Boar boar) {
            if (boar != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (boar.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, boar.getWeight());

                    if (foodToEat > 0) {
                        boar.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        boar.setWeight(boar.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Boar.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatBuffalo(HerbivoreAnimals.Buffalo buffalo) {
            return (getX() == buffalo.getX() && getY() == buffalo.getY());
        }
        public void eatBuffalo(HerbivoreAnimals.Buffalo buffalo) {
            if (buffalo != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (buffalo.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, buffalo.getWeight());

                    if (foodToEat > 0) {
                        buffalo.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        buffalo.setWeight(buffalo.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Buffalo.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
        public boolean canEatDuck(HerbivoreAnimals.Duck duck) {
            return (getX() == duck.getX() && getY() == duck.getY());
        }
        public void eatDuck(HerbivoreAnimals.Duck duck) {
            if (duck != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (duck.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, duck.getWeight());

                    if (foodToEat > 0) {
                        duck.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        duck.setWeight(duck.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Duck.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }

        public boolean canEatFox(Fox fox) {
            return (getX() == fox.getX() && getY() == fox.getY());
        }
        public void eatFox(Fox fox) {
            if (fox != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (fox.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, fox.getWeight());

                    if (foodToEat > 0) {
                        fox.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        fox.setWeight(fox.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + Fox.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
    }
    public static class Eagle extends CarnivoreAnimals implements Runnable {

        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x;
        private int y;

        public Eagle(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 0.375;
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
        public Eagle reproduce(Eagle partner) {
            if (partner != null && !hasReproduce()) {
                Eagle babyEagle = new Eagle("Eagle", 6, 20, 3, 1, 3);
                setReproduced(true);
                return babyEagle;
            } else {
                return null;
            }
        }
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

        public boolean canEatMouse(HerbivoreAnimals.Mouse mouse) {
            return (getX() == mouse.getX() && getY() == mouse.getY());
        }
        public void eatMouse(HerbivoreAnimals.Mouse mouse) {
            if (mouse != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (mouse.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, mouse.getWeight());

                    if (foodToEat > 0) {
                        mouse.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        mouse.setWeight(mouse.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Mouse.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }


        public boolean canEatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            return (getX() == rabbit.getX() && getY() == rabbit.getY());
        }
        public void eatRabbit(HerbivoreAnimals.Rabbit rabbit) {
            if (rabbit != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (rabbit.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, rabbit.getWeight());

                    if (foodToEat > 0) {
                        rabbit.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        rabbit.setWeight(rabbit.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Rabbit.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }

        public boolean canEatDuck(HerbivoreAnimals.Duck duck) {
            return (getX() == duck.getX() && getY() == duck.getY());
        }
        public void eatDuck(HerbivoreAnimals.Duck duck) {
            if (duck != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (duck.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, duck.getWeight());

                    if (foodToEat > 0) {
                        duck.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        duck.setWeight(duck.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + HerbivoreAnimals.Duck.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }

        public boolean canEatFox(Fox fox) {
            return (getX() == fox.getX() && getY() == fox.getY());
        }
        public void eatFox(Fox fox) {
            if (fox != null && getWeight() > 0.0) {
                double foodRequired = getFoodRequired();
                double maxFoodToEat = initialWeight - getWeight();

                if (fox.getWeight() <= foodRequired && maxFoodToEat > 0) {
                    double foodToEat = Math.min(maxFoodToEat, fox.getWeight());

                    if (foodToEat > 0) {
                        fox.getEaten(this);
                        setWeight(getWeight() + foodToEat);
                        fox.setWeight(fox.getWeight() - foodToEat);
                        System.out.println(name + " з'їв " + Fox.getName() + " на ділянці: Х = " + getX() + " Y = " + getY());
                    }
                }
            }
        }
    }
}
