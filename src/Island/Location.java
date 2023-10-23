package Island;

import Organizm.Animals.Animal;
import Organizm.Animals.Herbivore;
import Organizm.Animals.HerbivoreAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Location {
    private Random random = new Random();

    // ...
    public int getRandomXCoordinate() {
        return random.nextInt(width); // Генерувати випадкову координату X в межах ширини локації
    }

    public int getRandomYCoordinate() {
        return random.nextInt(height); // Генерувати випадкову координату Y в межах висоти локації
    }
    private List<Animal> animalsInLocation;
    private static int width;
    private static int height;

    public Location(int width, int height) {
        this.width = width;
        this.height = height;
        animalsInLocation = new ArrayList<>();
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public void addAnimal(Animal animal) {
        animalsInLocation.add(animal);
    }


    public void interact() {
        HerbivoreAnimals.Duck duck = null;

        for (Animal animal : animalsInLocation) {
            if (animal instanceof HerbivoreAnimals.Duck) {
                duck = (HerbivoreAnimals.Duck) animal;
                List<HerbivoreAnimals.Caterpillar> availableCaterpillars = findAvailableCaterpillars();
                for (HerbivoreAnimals.Caterpillar c : availableCaterpillars) {
                    if (duck.canEatCaterpillar(c)) {
                        duck.eatCaterpillar(c);
                        System.out.println(duck.getName() + " з'їв " + c.getName());
                    }
                }
            }
        }

        // Інша логіка і репродукція

        for (int i = 0; i < animalsInLocation.size(); i++) {
            Animal animal = animalsInLocation.get(i);
            if (animal.canReproduce()) {
                int animalsOfType = 0;
                Animal partner = null;
                for (int j = 0; j < animalsInLocation.size(); j++) {
                    if (j != i) {
                        partner = animalsInLocation.get(j);
                        if (partner.getClass() == animal.getClass()) {
                            animalsOfType++;
                        }
                    }
                }
                if (animalsOfType < ((HerbivoreAnimals) animal).getMaxPopulation()) {
                    Animal newAnimal = animal.reproduce(partner);
                    if (newAnimal != null) {
                        animalsInLocation.add(newAnimal);
                        System.out.println("Новий " + newAnimal.getName() + " народився.");
                    }
                }
            }
        }
    }


    public List<HerbivoreAnimals.Caterpillar> findAvailableCaterpillars() {
            // Логіка знаходження доступних гусенят для качки
            List<HerbivoreAnimals.Caterpillar> availableCaterpillars = new ArrayList<>();
            // Додайте свою логіку тут
            return availableCaterpillars;
        }


    private boolean canEatCaterpillar(HerbivoreAnimals.Caterpillar caterpillar) {
        // Додайте вашу логіку перевірки тут
        return true; // Приклад, якщо тварина завжди може їсти гусінь
    }

}

