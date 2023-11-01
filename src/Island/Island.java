package Island;

import Organizm.Animals.Animal;
import Organizm.Animals.CarnivoreAnimals;
import Organizm.Animals.HerbivoreAnimals;
import Organizm.Plants.Plant;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Island {
    public static void main(String[] args) {
        Location location = new Location(100, 20);

        ExecutorService plantGrowthThreadPool = Executors.newFixedThreadPool(Location.getWidth() * Location.getHeight());

        ExecutorService animalLifeCycleThreadPool = Executors.newFixedThreadPool(15);

        for (int x = 0; x < Location.getWidth(); x++) {
            for (int y = 0; y < Location.getHeight(); y++) {
                Plant plant = new Plant("Grass", 200);
                location.addPlant(plant, x, y);
                plant.run();

                plantGrowthThreadPool.execute(plant::run);
            }
        }

        for (int i = 0; i < 20; i++) {
            HerbivoreAnimals.Horse horse = new HerbivoreAnimals.Horse("Horse", 400, 20, 4, 60, 4);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            horse.setX(randomX);
            horse.setY(randomY);
            location.addAnimal(horse);

            animalLifeCycleThreadPool.execute(horse::run);
        }

        for (int i = 0; i < 500; i++) {
            HerbivoreAnimals.Mouse mouse = new HerbivoreAnimals.Mouse("Mouse", 0.05, 500, 1, 0.01, 1);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            mouse.setX(randomX);
            mouse.setY(randomY);
            location.addAnimal(mouse);

            animalLifeCycleThreadPool.execute(mouse::run);
        }

        for (int i = 0; i < 1000; i++) {
            HerbivoreAnimals.Caterpillar caterpillar = new HerbivoreAnimals.Caterpillar("Caterpillar", 0.01, 1000, 0, 0, 0);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            caterpillar.setX(randomX);
            caterpillar.setY(randomY);
            location.addAnimal(caterpillar);

            animalLifeCycleThreadPool.execute(caterpillar::run);
        }

        for (int i = 0; i < 20; i++) {
            HerbivoreAnimals.Deer deer = new HerbivoreAnimals.Deer("Deer", 300, 20, 4, 50, 4);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            deer.setX(randomX);
            deer.setY(randomY);
            location.addAnimal(deer);

            animalLifeCycleThreadPool.execute(deer::run);
        }
        for (int i = 0; i < 150; i++) {
            HerbivoreAnimals.Rabbit rabbit = new HerbivoreAnimals.Rabbit("Rabbit", 2, 150, 2, 0.45, 2);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            rabbit.setX(randomX);
            rabbit.setY(randomY);
            location.addAnimal(rabbit);

            animalLifeCycleThreadPool.execute(rabbit::run);
        }
        for (int i = 0; i < 140; i++) {
            HerbivoreAnimals.Goat goat = new HerbivoreAnimals.Goat("Goat", 60, 140, 3, 10, 3);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            goat.setX(randomX);
            goat.setY(randomY);
            location.addAnimal(goat);

            animalLifeCycleThreadPool.execute(goat::run);
        }
        for (int i = 0; i < 140; i++) {
            HerbivoreAnimals.Sheep sheep = new HerbivoreAnimals.Sheep("Sheep", 70, 140, 3, 15, 3);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            sheep.setX(randomX);
            sheep.setY(randomY);
            location.addAnimal(sheep);

            animalLifeCycleThreadPool.execute(sheep::run);
        }
        for (int i = 0; i < 50; i++) {
            HerbivoreAnimals.Boar boar = new HerbivoreAnimals.Boar("Boar", 400, 50, 2, 50, 2);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            boar.setX(randomX);
            boar.setY(randomY);
            location.addAnimal(boar);

            animalLifeCycleThreadPool.execute(boar::run);
        }
        for (int i = 0; i < 10; i++) {
            HerbivoreAnimals.Buffalo buffalo = new HerbivoreAnimals.Buffalo("Buffalo", 700, 10, 3, 100, 3);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            buffalo.setX(randomX);
            buffalo.setY(randomY);
            location.addAnimal(buffalo);

            animalLifeCycleThreadPool.execute(buffalo::run);
        }
        for (int i = 0; i < 200; i++) {
            HerbivoreAnimals.Duck duck = new HerbivoreAnimals.Duck("Duck", 1, 200, 4, 0.15, 4);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            duck.setX(randomX);
            duck.setY(randomY);
            location.addAnimal(duck);

            animalLifeCycleThreadPool.execute(duck::run);
        }

        for (int i = 0; i < 30; i++) {
            CarnivoreAnimals.Wolf wolf = new CarnivoreAnimals.Wolf("Wolf", 50, 30, 3, 8, 3);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            wolf.setX(randomX);
            wolf.setY(randomY);
            location.addAnimal(wolf);

            animalLifeCycleThreadPool.execute(wolf::run);
        }
        for (int i = 0; i < 30; i++) {
            CarnivoreAnimals.Fox fox = new CarnivoreAnimals.Fox("Fox", 8, 30, 2, 2, 2);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            fox.setX(randomX);
            fox.setY(randomY);
            location.addAnimal(fox);

            animalLifeCycleThreadPool.execute(fox::run);
        }
        for (int i = 0; i < 30; i++) {
            CarnivoreAnimals.Snake snake = new CarnivoreAnimals.Snake("Snake", 15, 30, 1, 3, 1);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            snake.setX(randomX);
            snake.setY(randomY);
            location.addAnimal(snake);

            animalLifeCycleThreadPool.execute(snake::run);
        }
        for (int i = 0; i < 5; i++) {
            CarnivoreAnimals.Bear bear = new CarnivoreAnimals.Bear("Bear", 500, 5, 2, 80, 2);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            bear.setX(randomX);
            bear.setY(randomY);
            location.addAnimal(bear);

            animalLifeCycleThreadPool.execute(bear::run);
        }
        for (int i = 0; i < 20; i++) {
            CarnivoreAnimals.Eagle eagle = new CarnivoreAnimals.Eagle("Eagle", 6, 20, 3, 1, 3);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            eagle.setX(randomX);
            eagle.setY(randomY);
            location.addAnimal(eagle);

            animalLifeCycleThreadPool.execute(eagle::run);
        }


        int numberOfTurns = 10;

        for (int turn = 1; turn < numberOfTurns; turn++) {
            System.out.println("Такт " + turn);

            location.interact();

                // Для переміщення мишей
                Iterator<Animal> iterator = location.animalsInLocation.iterator();
                while (iterator.hasNext()) {
                    Animal animal = iterator.next();
                    DecimalFormat df = new DecimalFormat("#.###");
                    if (animal instanceof HerbivoreAnimals.Mouse) {
                        HerbivoreAnimals.Mouse mouse = (HerbivoreAnimals.Mouse) animal;
                        if (mouse.getWeight() > 0.0) {
                            mouse.run();
                            //System.out.println("Координати миші після переміщення: X=" + mouse.getX() + ", Y=" + mouse.getY() + " Вага після руху: " + df.format(mouse.getWeight()));
                        } else {
                            mouse.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Horse) {
                        HerbivoreAnimals.Horse horse = (HerbivoreAnimals.Horse) animal;
                        if (horse.getWeight() > 0.0) {
                            horse.run();
                            //System.out.println("Координати коня після переміщення: X=" + horse.getX() + ", Y=" + horse.getY() + " Вага після руху: " + df.format(horse.getWeight()));
                        } else {
                            horse.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Deer) {
                        HerbivoreAnimals.Deer deer = (HerbivoreAnimals.Deer) animal;
                        if (deer.getWeight() > 0.0) {
                            deer.run();
                            //System.out.println("Координати оленя після переміщення: X=" + deer.getX() + ", Y=" + deer.getY() + " Вага після руху: " + df.format(deer.getWeight()));
                        } else {
                            deer.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Rabbit) {
                        HerbivoreAnimals.Rabbit rabbit = (HerbivoreAnimals.Rabbit) animal;
                        if (rabbit.getWeight() > 0.0) {
                            rabbit.run();
                            //System.out.println("Координати кролика після переміщення: X=" + rabbit.getX() + ", Y=" + rabbit.getY() + " Вага після руху: " + df.format(rabbit.getWeight()));
                        } else {
                            rabbit.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Goat) {
                        HerbivoreAnimals.Goat goat = (HerbivoreAnimals.Goat) animal;
                        if (goat.getWeight() > 0.0) {
                            goat.run();
                            //System.out.println("Координати кози після переміщення: X=" + goat.getX() + ", Y=" + goat.getY() + " Вага після руху: " + df.format(goat.getWeight()));
                        } else {
                            goat.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Sheep) {
                        HerbivoreAnimals.Sheep sheep = (HerbivoreAnimals.Sheep) animal;
                        if (sheep.getWeight() > 0.0) {
                            sheep.run();
                            //System.out.println("Координати вівці після переміщення: X=" + sheep.getX() + ", Y=" + sheep.getY() + " Вага після руху: " + df.format(sheep.getWeight()));
                        } else {
                            sheep.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Boar) {
                        HerbivoreAnimals.Boar boar = (HerbivoreAnimals.Boar) animal;
                        if (boar.getWeight() > 0.0) {
                            boar.run();
                            //System.out.println("Координати кабана після переміщення: X=" + boar.getX() + ", Y=" + boar.getY() + " Вага після руху: " + df.format(boar.getWeight()));
                        } else {
                            boar.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Buffalo) {
                        HerbivoreAnimals.Buffalo buffalo = (HerbivoreAnimals.Buffalo) animal;
                        if (buffalo.getWeight() > 0.0) {
                            buffalo.run();
                            //System.out.println("Координати буйвола після переміщення: X=" + buffalo.getX() + ", Y=" + buffalo.getY() + " Вага після руху: " + df.format(buffalo.getWeight()));
                        } else {
                            buffalo.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Duck) {
                        HerbivoreAnimals.Duck duck = (HerbivoreAnimals.Duck) animal;
                        if (duck.getWeight() > 0.0) {
                            duck.run();
                            //System.out.println("Координати качки після переміщення: X=" + duck.getX() + ", Y=" + duck.getY() + " Вага після руху: " + df.format(duck.getWeight()));
                        } else {
                            duck.die();
                            iterator.remove();
                        }
                    }
                    if (animal instanceof CarnivoreAnimals.Wolf) {
                        CarnivoreAnimals.Wolf wolf = (CarnivoreAnimals.Wolf) animal;
                        if (wolf.getWeight() > 0.0) {
                            wolf.run();
                            //System.out.println("Координати вовка після переміщення: X=" + wolf.getX() + ", Y=" + wolf.getY() + " Вага після руху: " + df.format(wolf.getWeight()));
                        } else {
                            wolf.die();
                            iterator.remove();
                        }
                    }

                }

                List<HerbivoreAnimals> eatenAnimals = new ArrayList<>();
                List<CarnivoreAnimals> eatenAnimals1 = new ArrayList<>();
                for (Animal animal : location.animalsInLocation) {

                    if (animal instanceof HerbivoreAnimals.Caterpillar) {
                        HerbivoreAnimals.Caterpillar caterpillar = (HerbivoreAnimals.Caterpillar) animal;
                        //System.out.println("Координати гусені: X=" + caterpillar.getX() + ", Y=" + caterpillar.getY());

                        if (caterpillar.isEaten()) {
                            eatenAnimals.add(caterpillar);
                            //System.out.println("Гусінь була з'їдена на координатах X=" + caterpillar.getX() + ", Y=" + caterpillar.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Mouse) {
                        HerbivoreAnimals.Mouse mouse = (HerbivoreAnimals.Mouse) animal;
                        if (mouse.isEaten()) {
                            eatenAnimals.add(mouse);
                            //System.out.println("Миша була з'їдена на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Horse) {
                        HerbivoreAnimals.Horse horse = (HerbivoreAnimals.Horse) animal;
                        if (horse.isEaten()) {
                            eatenAnimals.add(horse);
                            //System.out.println("Кінь був з'їдений на координатах X=" + horse.getX() + ", Y=" + horse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Deer) {
                        HerbivoreAnimals.Deer deer = (HerbivoreAnimals.Deer) animal;
                        if (deer.isEaten()) {
                            eatenAnimals.add(deer);
                            //System.out.println("Олень був з'їдений на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Rabbit) {
                        HerbivoreAnimals.Rabbit rabbit = (HerbivoreAnimals.Rabbit) animal;
                        if (rabbit.isEaten()) {
                            eatenAnimals.add(rabbit);
                            //System.out.println("Кролик був з'їдений на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Goat) {
                        HerbivoreAnimals.Goat goat = (HerbivoreAnimals.Goat) animal;
                        if (goat.isEaten()) {
                            eatenAnimals.add(goat);
                            //System.out.println("Коза була з'їдена на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Sheep) {
                        HerbivoreAnimals.Sheep sheep = (HerbivoreAnimals.Sheep) animal;
                        if (sheep.isEaten()) {
                            eatenAnimals.add(sheep);
                            //System.out.println("Вівця була з'їдена на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Boar) {
                        HerbivoreAnimals.Boar boar = (HerbivoreAnimals.Boar) animal;
                        if (boar.isEaten()) {
                            eatenAnimals.add(boar);
                            //System.out.println("Кабана було з'їдено на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Buffalo) {
                        HerbivoreAnimals.Buffalo buffalo = (HerbivoreAnimals.Buffalo) animal;
                        if (buffalo.isEaten()) {
                            eatenAnimals.add(buffalo);
                            //System.out.println("Буйвол був з'їдений на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof HerbivoreAnimals.Duck) {
                        HerbivoreAnimals.Duck duck = (HerbivoreAnimals.Duck) animal;
                        if (duck.isEaten()) {
                            eatenAnimals.add(duck);
                            //System.out.println("Миша була з'їдена на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                    if (animal instanceof CarnivoreAnimals.Fox) {
                        CarnivoreAnimals.Fox fox = (CarnivoreAnimals.Fox) animal;
                        if (fox.isEaten()) {
                            eatenAnimals1.add(fox);
                            //System.out.println("Лисиця була з'їдена на координатах X=" + mouse.getX() + ", Y=" + mouse.getY());
                        }
                    }
                }
                location.animalsInLocation.removeAll(eatenAnimals);
                location.animalsInLocation.removeAll(eatenAnimals1);
            }
            plantGrowthThreadPool.shutdown();
            animalLifeCycleThreadPool.shutdown();
        }
    }


