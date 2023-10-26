package Organizm.Animals;

import Island.Location;
import Organizm.Plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class HerbivoreAnimals extends Animal implements Herbivore {

    private int count;
    private double foodRequired;
    private int maxPopulation;
    public HerbivoreAnimals(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
        super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
        this.foodRequired = foodRequired;
        this.maxPopulation = maxPopulation;
        count = 1;

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
    public boolean canEatCaterpillar(Caterpillar caterpillar) {
        return false;
    }




    public double getFoodRequired() {
        return foodRequired;
    }



    public static class Horse extends HerbivoreAnimals implements Runnable{

        private boolean hasReproduced = false;
        private final double foodRequired;
        private final double initialWeight;
        private int maxPopulation;

        public Horse(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 5;
            this.foodRequired = foodRequired;
            initialWeight = weight;
            this.maxPopulation = maxPopulation;
        }
        @Override
        public void run() {
            while (weight > 0) { // Цикл працює, поки вага більше нуля
                moveRandom(); // Виклик методу для випадкового переміщення
                weight -= weightLossRate; // Втрата ваги на кожному такті
                // Інша логіка тварини
            }
            die(); // Якщо вага стала нульовою або від'ємною, тварина помирає
        }
        public void die() {
            System.out.println(HerbivoreAnimals.getName() + " помер.");
            // Додаткова логіка, яку ви хочете виконати при смерті тварини
        }
        public boolean hasReproduce() {
            return hasReproduced;
        }

        public void setReproduced(boolean hasReproduced) {
            this.hasReproduced = hasReproduced;
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


        public Horse reproduce(Horse partner) {
            if (partner != null && !hasReproduce()) { // Перевірте, чи конь ще не розмножувався
                Horse babyHorse = new Horse("Horse", 400, 20, 4, 60, 4);
                setReproduced(true); // Встановіть hasReproduced в true, щоб позначити розмноження
                return babyHorse;
            } else {
                return null;
            }
        }

        public double getFoodRequired() {
            return foodRequired;
        }
        private int x; // Додайте поле для координати X
        private int y; // Додайте поле для координати Y

        public void moveRandom() {
            // Додайте код для випадкового переміщення миші
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            // Перевірка, щоб не виходити за межі локації
            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public int getMaxSteps() {
            return 4; // Встановіть максимальну кількість кроків, яку миша може зробити
        }

        public int getX() {
            return x; // Повертаємо координату X
        }

        public int getY() {
            return y; // Повертаємо координату Y
        }

        public void setX(int x) {
            this.x = x; // Встановлюємо координату X
        }

        public void setY(int y) {
            this.y = y; // Встановлюємо координату Y
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

    public static class Mouse extends HerbivoreAnimals implements Runnable{
        private static String name;
        private boolean hasReproduced = false;
        private static double initialWeight;
        private double weight;
        private int x; // Додайте поле для координати X
        private int y; // Додайте поле для координати Y

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
        public Mouse reproduce(Animal partner) {
            if (partner instanceof Mouse) {
                // Отримайте характеристики нового мишенята
                String name = "Mouse"; // Назва
                double weight = 0.05; // Вага
                int maxPopulation = 500; // Максимальна кількість особин на клітинці
                int maxSpeed = 1; // Максимальна швидкість
                double foodRequired = 0.01; // Кількість їжі, необхідна для насичення
                int maxSteps = 1; // Максимальна кількість кроків

                // Створіть нове мишеня
                Mouse babyMouse = new Mouse(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
                return babyMouse;
            } else {
                return null;
            }
        }


        public void moveRandom() {


            // Додайте код для випадкового переміщення миші
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            // Перевірка, щоб не виходити за межі локації
            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }

        }

        public int getMaxSteps() {
            return 1; // Встановіть максимальну кількість кроків, яку миша може зробити
        }

        public int getX() {
            return x; // Повертаємо координату X
        }

        public int getY() {
            return y; // Повертаємо координату Y
        }

        public void setX(int x) {
            this.x = x; // Встановлюємо координату X
        }

        public void setY(int y) {
            this.y = y; // Встановлюємо координату Y
        }
        public boolean canEatCaterpillar(Caterpillar caterpillar) {
            return (getX() == caterpillar.getX() && getY() == caterpillar.getY());
        }
        @Override
        public void run() {
            if (weight > 0.0) { // Цикл працює, поки вага більше нуля
                moveRandom(); // Виклик методу для випадкового переміщення
                weight -= weightLossRate; // Втрата ваги на кожному такті
                // Інша логіка тварини
            } else {
                die(); // Якщо вага стала нульовою або від'ємною, тварина помирає
            }
        }
        public void die() {
            System.out.println(name + " помер на координатах: X= " + getX() + ", Y=" + getY());
            // Додаткова логіка, яку ви хочете виконати при смерті тварини
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

        private static String name;
        private double foodRequired;
        private double initialWeight;
        public Boar(String name, double weight, int maxPopulation, int maxSpeed, double foodRequired, int maxSteps) {
            super(name, weight, maxPopulation, maxSpeed, foodRequired, maxSteps);
            weightLossRate = 10;
            this.foodRequired = foodRequired;
            initialWeight = weight;
            this.name = name;
        }

        public static String getName() {
            return name;
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
        public boolean canEatCaterpillar(Caterpillar caterpillar) {
            // Додайте вашу логіку тут, яка визначає, чи ця тварина може їсти гусениць
            return true; // Приклад, якщо тварина завжди може їсти гусениць
        }
        private int x; // Додайте поле для координати X
        private int y; // Додайте поле для координати Y
        public void moveRandom() {
            // Додайте код для випадкового переміщення миші
            Random random = new Random();
            int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
            int newX = getX() + randomX;
            int newY = getY() + randomY;

            // Перевірка, щоб не виходити за межі локації
            if (newX >= 0 && newX < Location.getWidth()) {
                setX(newX);
            }
            if (newY >= 0 && newY < Location.getHeight()) {
                setY(newY);
            }
        }

        public int getMaxSteps() {
            return 0; // Встановіть максимальну кількість кроків, яку миша може зробити
        }

        public int getX() {
            return x; // Повертаємо координату X
        }

        public int getY() {
            return y; // Повертаємо координату Y
        }

        public void setX(int x) {
            this.x = x; // Встановлюємо координату X
        }

        public void setY(int y) {
            this.y = y; // Встановлюємо координату Y
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
        private static double initialWeight;

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

        public List<Caterpillar> findAvailableCaterpillars() {
            List<Caterpillar> availableCaterpillars = new ArrayList<>();

            // Припустимо, що у вас є список всіх гусениць в локації
            List<Caterpillar> allCaterpillars = getAllCaterpillarsInLocation();

            // Ваша логіка пошуку доступних гусениць для качки
            for (Caterpillar caterpillar : allCaterpillars) {
                if (canEatCaterpillar(caterpillar)) {
                    availableCaterpillars.add(caterpillar);
                }
            }

            return availableCaterpillars;
        }
        private List<Caterpillar> getAllCaterpillarsInLocation() {
            List<Caterpillar> allCaterpillars = new ArrayList<>();
            // Додайте логіку для отримання всіх гусениць в локації
            return allCaterpillars;
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
        public void run() {
            while (Caterpillar.weight > 0) { // Цикл працює, поки вага більше нуля
                moveRandom();
                Caterpillar.weight -= weightLossRate; // Втрата ваги на кожному такті
                // Інша логіка тварини
            }
            die(); // Якщо вага стала нульовою або від'ємною, тварина помирає
        }
        public void die() {
            System.out.println(HerbivoreAnimals.getName() + " помер.");
            // Додаткова логіка, яку ви хочете виконати при смерті тварини
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
    public void getEaten(Mouse mouse) {
        if (mouse != null) {
            // Гусінь з'їдається качкою
            mouse.weight += 0.01;
            // Тут також можна виконати іншу логіку, якщо потрібно.
        }
    }
    private int x; // Додайте поле для координати X
    private int y; // Додайте поле для координати Y
    public void moveRandom() {
        // Додайте код для випадкового переміщення миші
        Random random = new Random();
        int randomX = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
        int randomY = random.nextInt(getMaxSteps() * 2 + 1) - getMaxSteps();
        int newX = getX() + randomX;
        int newY = getY() + randomY;

        // Перевірка, щоб не виходити за межі локації
        if (newX >= 0 && newX < Location.getWidth()) {
            setX(newX);
        }
        if (newY >= 0 && newY < Location.getHeight()) {
            setY(newY);
        }
    }

    public int getMaxSteps() {
        return 0; // Встановіть максимальну кількість кроків, яку миша може зробити
    }

    public int getX() {
        return x; // Повертаємо координату X
    }

    public int getY() {
        return y; // Повертаємо координату Y
    }

    public void setX(int x) {
        this.x = x; // Встановлюємо координату X
    }

    public void setY(int y) {
        this.y = y; // Встановлюємо координату Y
        }
    }
