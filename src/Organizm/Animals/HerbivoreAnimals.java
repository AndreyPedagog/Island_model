package Organizm.Animals;

import Organizm.Plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class HerbivoreAnimals extends Animal implements Herbivore {

    private double foodRequired;
    private int maxPopulation;
    public HerbivoreAnimals(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
        super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
        this.foodRequired = foodRequired;
        this.maxPopulation = maxPopulation;

    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public void eatPlant(Plant plant) {

    }

    @Override
    public List<Caterpillar> findAvailableCaterpillars() {
        // Логіка знаходження доступних гусенят для качки
        List<Caterpillar> availableCaterpillars = new ArrayList<>();
        // Додайте свою логіку тут
        return availableCaterpillars;

    }


    public double getFoodRequired() {
        return foodRequired;
    }



    public static class Horse extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        private int maxPopulation;
        public Horse(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 5;
            this.foodRequired = foodRequired;
            initialWeight = weight;
            this.maxPopulation = maxPopulation;
        }


        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 60)) {
                    weight = initialWeight;
                }
            }
        }

        public HerbivoreAnimals.Horse reproduce(HerbivoreAnimals.Horse partner) {
            if (partner != null) {
                Horse babyHorse = new Horse("Horse", 400, 20, 4, 60, 4);
                return babyHorse;
            } else {
                return null;
            }
        }

        public double getFoodRequired() {
            return foodRequired;
        }

        public void setX(int randomX) {
        }

        public void setY(int randomY) {
        }
    }

    public static class Deer extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        private int maxPopulation;
        public Deer(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 4;
            this.foodRequired = foodRequired;
            initialWeight = weight;
            this.maxPopulation = maxPopulation;
        }

        public double getFoodRequired() {
            return foodRequired;
        }


        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 50)) {
                    weight = initialWeight;
                }
            }
        }

        public Deer reproduce(Animal partner) {
            if (partner instanceof Deer) {
                Deer babyDeer = new Deer("Deer", 300, 20, 4, 50, 4);
                return babyDeer;
            } else {
                return null;
            }
        }
    }

    public static class Rabbit extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        public Rabbit(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 0.05;
            this.foodRequired = foodRequired;
            initialWeight = weight;
        }

        public double getFoodRequired() {
            return foodRequired;
        }


        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 0.45)) {
                    weight = initialWeight;
                }
            }
        }
        public Rabbit reproduce(Animal partner) {
            if (partner instanceof Rabbit) {
                Rabbit babyRabbit = new Rabbit("Rabbit", 2, 150, 2, 0.45, 2);
                return babyRabbit;
            } else {
                return null;
            }
        }
    }

    public static class Mouse extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        public Mouse(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 0.00125;
            this.foodRequired = foodRequired;
            initialWeight = weight;

        }
        public double getFoodRequired() {
            return foodRequired;
        }

        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 0.01)) {
                    weight = initialWeight;
                }
            }
        }

        public Mouse reproduce(Animal partner) {
            if (partner instanceof Mouse) {
                Mouse babyMouse = new Mouse("Mouse", 0.05, 500, 1, 0.01, 1);
                return babyMouse;
            } else {
                return null;
            }
        }
    }

    public static class Goat extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        public Goat(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 1.5;
            this.foodRequired = foodRequired;
            initialWeight = weight;
        }
        public double getFoodRequired() {
            return foodRequired;
        }

        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 10)) {
                    weight = initialWeight;
                }
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


    public static class Sheep extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        public Sheep(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 1.75;
            this.foodRequired = foodRequired;
            initialWeight = weight;
        }
        public double getFoodRequired() {
            return foodRequired;
        }

        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 15)) {
                    weight = initialWeight;
                }
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

    public static class Boar extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        public Boar(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 10;
            this.foodRequired = foodRequired;
            initialWeight = weight;
        }
        public double getFoodRequired() {
            return foodRequired;
        }

        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 50)) {
                    weight = initialWeight;
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
    }

    public static class Buffalo extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;
        public Buffalo(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 17.5;
            this.foodRequired = foodRequired;
            initialWeight = weight;
        }
        public double getFoodRequired() {
            return foodRequired;
        }
        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 100)) {
                    weight = initialWeight;
                }
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

    public static class Duck extends HerbivoreAnimals {

        private double foodRequired;
        private double initialWeight;

        public Duck(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            this.foodRequired = foodRequired;
            weightLossRate = 0.025;
            initialWeight = weight;
        }

        @Override
        public void eatPlant(Plant plant) {
            if (plant != null) {
                double foodRequired = getFoodRequired();
                double currentPlantWeight = plant.getWeight();

                // Перевірка, чи тварина може з'їсти доступну кількість трави без перевищення своєї ваги
                double maxFoodToEat = initialWeight - weight;
                if (maxFoodToEat >= foodRequired) {
                    if (currentPlantWeight >= foodRequired) {
                        plant.getEaten(this, plant);
                        weight += foodRequired; // Збільшення ваги відповідно до кількості з'їденої трави
                    } else {
                        plant.setWeight(currentPlantWeight - foodRequired);
                        weight += currentPlantWeight; // Збільшення ваги на всю доступну траву
                    }
                } else {
                    // Обмеження кількості трави, яку тварина може з'їсти
                    if (currentPlantWeight >= maxFoodToEat) {
                        plant.getEaten(this, plant);
                        weight += maxFoodToEat;
                    } else {
                        plant.setWeight(currentPlantWeight - maxFoodToEat);
                        weight += currentPlantWeight;
                    }
                }

                // Відновлення ваги, якщо з'їла 60 кг трави
                if (weight >= (initialWeight + 0.15)) {
                    weight = initialWeight;
                }
            }
        }

        public Duck reproduce(Animal partner) {
            if (partner instanceof Duck) {
                Duck babyDuck = new Duck("Duck", 1, 200, 4, 0.15, 0);
                return babyDuck;
            } else {
                return null;
            }
        }


        public boolean canEatCaterpillar(Caterpillar caterpillar) {
            // Перевірка, чи качка має меншу вагу, ніж початкова
            if (weight < initialWeight) {
                return true;
            }
            return false;
        }



        public void eatCaterpillar(Caterpillar caterpillar) {
            if (caterpillar != null) {
                // Перевірка, чи гусінь є доступною для споживання
                double foodRequired = getFoodRequired(); // Отримайте кількість їжі, яку потрібно качці для насичення

                if (weight < initialWeight) { // Перевірка, чи вага качки не перевищує її початкову вагу
                    double maxFoodToEat = initialWeight - weight;
                    if (caterpillar.getWeight() >= foodRequired && caterpillar.getWeight() <= maxFoodToEat) {
                        // Гусінь має достатньо їжі для качки та не перевищує максимальну кількість
                        caterpillar.getEaten(this); // Гусінь з'їдається качкою
                        if (weight > initialWeight) {
                            weight = initialWeight; // Перевірка і обмеження ваги качки
                        }
                        // Тут ви також можете збільшити питність або здоров'я качки, в залежності від вашої логіки.
                    }
                }
            }
        }

        public double getFoodRequired() {
            return foodRequired;
        }
    }

    public static class Caterpillar extends HerbivoreAnimals {

        private double weight;
        public Caterpillar(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            this.weight = weight;
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
    }

    public void getEaten(Duck duck) {
        if (duck != null) {
            // Гусінь з'їдається качкою
            duck.weight += 0.1;
            // Тут також можна виконати іншу логіку, якщо потрібно.
        }
    }
}
