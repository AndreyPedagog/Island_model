package Island;

import Organizm.Animals.Animal;
import Organizm.Animals.HerbivoreAnimals;

import java.util.Iterator;

public class Island {
    public static void main(String[] args) {
        Location location = new Location(100, 20); // Створення локації

        for (int i = 0; i < 2; i++) {
            HerbivoreAnimals.Horse horse = new HerbivoreAnimals.Horse("Horse", 400, 20, 4, 60, 4);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            horse.setX(randomX);
            horse.setY(randomY);
            location.addAnimal(horse);

            Thread horseThread = new Thread(horse); // Створюємо новий потік для миші
            horseThread.start(); // Запускаємо потік для миші
        }

        for (int i = 0; i < 2; i++) {
            HerbivoreAnimals.Mouse mouse = new HerbivoreAnimals.Mouse("Mouse", 0.05, 500, 1, 0.01, 1);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            mouse.setX(randomX);
            mouse.setY(randomY);
            location.addAnimal(mouse);

            Thread mouseThread = new Thread(mouse); // Створюємо новий потік для миші
            mouseThread.start(); // Запускаємо потік для миші
        }

        for (int i = 0; i < 200; i++) {
            HerbivoreAnimals.Caterpillar caterpillar = new HerbivoreAnimals.Caterpillar("Caterpillar", 0.01, 1000, 0, 0, 0);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            caterpillar.setX(randomX);
            caterpillar.setY(randomY);
            location.addAnimal(caterpillar);

        }

        //HerbivoreAnimals.Deer deer = new HerbivoreAnimals.Deer("Deer", 300, 20, 4, 50, 4);
        //HerbivoreAnimals.Rabbit rabbit = new HerbivoreAnimals.Rabbit("Rabbit", 2, 150, 2, 0.45, 2);
        //HerbivoreAnimals.Sheep sheep = new HerbivoreAnimals.Sheep("Sheep", 70, 140, 3, 15, 3);
        //HerbivoreAnimals.Boar boar = new HerbivoreAnimals.Boar("Boar", 400, 50, 2, 50, 2);
        //HerbivoreAnimals.Buffalo buffalo = new HerbivoreAnimals.Buffalo("Buffalo", 700, 10, 3, 100, 3);
        //HerbivoreAnimals.Duck duck = new HerbivoreAnimals.Duck("Duck", 1, 200, 4, 0.15, 4);
        //HerbivoreAnimals.Goat goat = new HerbivoreAnimals.Goat("Goat", 60, 140, 3, 10, 3);

        //location.addAnimal(deer);
        //location.addAnimal(rabbit);
        //location.addAnimal(sheep);
        //location.addAnimal(boar);
        //location.addAnimal(buffalo);
        //location.addAnimal(duck);
        //location.addAnimal(goat);

        // Виклик інших методів, логіки програми і т. д.
        int numberOfTurns = 100; // Кількість тактів, яку ви хочете виконати

        for (int turn = 0; turn < numberOfTurns; turn++) {
            System.out.println("Такт " + turn);
            location.interact();  // Викликайте метод interact() безпосередньо на об'єкті location

            // Для переміщення мишей
            Iterator<Animal> iterator = location.animalsInLocation.iterator();
            while (iterator.hasNext()) {
                Animal animal = iterator.next();
                if (animal instanceof HerbivoreAnimals.Mouse) {
                    HerbivoreAnimals.Mouse mouse = (HerbivoreAnimals.Mouse) animal;
                    if (mouse.getWeight() > 0.0) {
                        mouse.run();
                        System.out.println("Координати миші після переміщення: X=" + mouse.getX() + ", Y=" + mouse.getY() + " Вага після руху: " + mouse.getWeight());
                    } else {
                        mouse.die();
                        iterator.remove(); // Видалення тварини за допомогою ітератора
                    }
                }
            }
            for (Animal animal : location.animalsInLocation) {
                if (animal instanceof HerbivoreAnimals.Horse) {
                    HerbivoreAnimals.Horse horse = (HerbivoreAnimals.Horse) animal;
                    horse.moveRandom();
                    System.out.println("Координати коня після переміщення: X=" + horse.getX() + ", Y=" + horse.getY());
                }
            }
            for (Animal animal : location.animalsInLocation) {
                if (animal instanceof HerbivoreAnimals.Caterpillar) {
                    HerbivoreAnimals.Caterpillar caterpillar = (HerbivoreAnimals.Caterpillar) animal;
                    caterpillar.moveRandom();
                    //System.out.println("Координати гусені після переміщення: X=" + caterpillar.getX() + ", Y=" + caterpillar.getY());
                }
            }
        }
    }
}


