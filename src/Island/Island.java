package Island;

import Organizm.Animals.HerbivoreAnimals;

public class Island {
    public static void main(String[] args) {
        Location location = new Location(100, 200); // Створення локації

        for (int i = 0; i < 20; i++) {
            HerbivoreAnimals.Horse horse = new HerbivoreAnimals.Horse("Horse", 400, 20, 4, 60, 4);
            int randomX = location.getRandomXCoordinate();
            int randomY = location.getRandomYCoordinate();
            horse.setX(randomX);
            horse.setY(randomY);
            location.addAnimal(horse);
        }

        HerbivoreAnimals.Deer deer = new HerbivoreAnimals.Deer("Deer", 300, 20, 4, 50, 4);
        HerbivoreAnimals.Rabbit rabbit = new HerbivoreAnimals.Rabbit("Rabbit", 2, 150, 2, 0.45, 2);
        HerbivoreAnimals.Mouse mouse = new HerbivoreAnimals.Mouse("Mouse", 0.05, 500, 1, 0.01, 1);
        HerbivoreAnimals.Sheep sheep = new HerbivoreAnimals.Sheep("Sheep", 70, 140, 3, 15, 3);
        HerbivoreAnimals.Boar boar = new HerbivoreAnimals.Boar("Boar", 400, 50, 2, 50, 2);
        HerbivoreAnimals.Buffalo buffalo = new HerbivoreAnimals.Buffalo("Buffalo", 700, 10, 3, 100, 3);
        HerbivoreAnimals.Duck duck = new HerbivoreAnimals.Duck("Duck", 1, 200, 4, 0.15, 4);
        HerbivoreAnimals.Caterpillar caterpillar = new HerbivoreAnimals.Caterpillar("Caterpillar", 0.01, 1000, 0, 0, 0);
        HerbivoreAnimals.Goat goat = new HerbivoreAnimals.Goat("Goat", 60, 140, 3, 10, 3);



        location.addAnimal(deer);
        location.addAnimal(rabbit);
        location.addAnimal(mouse);
        location.addAnimal(sheep);
        location.addAnimal(boar);
        location.addAnimal(buffalo);
        location.addAnimal(duck);
        location.addAnimal(caterpillar);
        location.addAnimal(goat);

        // Виклик інших методів, логіки програми і т. д.
        int numberOfTurns = 1000; // Кількість тактів, яку ви хочете виконати

        for (int turn = 0; turn < numberOfTurns; turn++) {
            location.interact(); // Виконайте інтеракцію для кожного такту

            //try {
               // Thread.sleep(3000); // Перерва на 3 секунди
            //} catch (InterruptedException e) {
              //  e.printStackTrace();
            //}
        }
        // Наприклад, запустіть взаємодію тварин у локації
    }
}
