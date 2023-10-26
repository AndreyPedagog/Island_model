package Island;

import Organizm.Animals.*;
import Organizm.Plants.Plant;

import java.util.*;

public class Location {
    private final Random random = new Random();
    final List<Animal> animalsInLocation = new ArrayList<>();
    private static int width;
    private static int height;
    Location location;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public int getRandomXCoordinate() {
        return random.nextInt(width);
    }

    public int getRandomYCoordinate() {
        return random.nextInt(height);
    }

    public Location(int width, int height) {
        Location.width = width;
        Location.height = height;
    }
    public void removeAnimal(Animal animal) {
        animalsInLocation.remove(animal);
    }

    public void addAnimal(Animal animal) {
        animalsInLocation.add(animal);
    }

    public void interact() {
        List<Animal> newAnimals = new ArrayList<>();
        for (Animal animal : animalsInLocation) {
            if (animal instanceof HerbivoreAnimals.Mouse) {
                HerbivoreAnimals.Mouse mouse = (HerbivoreAnimals.Mouse) animal;
                for (Animal caterpillar : animalsInLocation) {
                    if (caterpillar instanceof HerbivoreAnimals.Caterpillar) {
                        HerbivoreAnimals.Caterpillar c = (HerbivoreAnimals.Caterpillar) caterpillar;
                        if (mouse.getX() == c.getX() && mouse.getY() == c.getY()) {
                            if (random.nextDouble() <= 0.9 && mouse.canEatCaterpillar(c)) {
                                mouse.eatCaterpillar(c);
                                System.out.println(HerbivoreAnimals.Mouse.getName() + " з'їв " + HerbivoreAnimals.Caterpillar.getName());
                            }
                        }
                    }
                }
            }
        }

        // Логіка для кожної ділянки

        // Логіка розмноження для кожної ділянки

        for (Animal animal : animalsInLocation) {
            if (animal instanceof HerbivoreAnimals.Horse) {
                HerbivoreAnimals.Horse horse = (HerbivoreAnimals.Horse) animal;

                // Перевірка, чи конь може розмножитися
                if (!horse.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = horse.getX();
                    int parentY = horse.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Horse && otherAnimal != horse) {
                            HerbivoreAnimals.Horse otherHorse = (HerbivoreAnimals.Horse) otherAnimal;

                            if (!otherHorse.hasReproduce()) {
                                if (horse.getX() == otherHorse.getX() && horse.getY() == otherHorse.getY()) {
                                    HerbivoreAnimals.Horse newHorse = horse.reproduce(otherHorse);
                                    if (newHorse != null) {
                                        newHorse.setX(parentX);
                                        newHorse.setY(parentY);
                                        newAnimals.add(newHorse);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        horse.setReproduced(true);
                        System.out.println("Новий " + "кінь" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
        }
        for (Animal animal : animalsInLocation) {
            if (animal instanceof HerbivoreAnimals.Mouse) {
                HerbivoreAnimals.Mouse mouse = (HerbivoreAnimals.Mouse) animal;

                // Перевірка, чи конь може розмножитися
                if (!mouse.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = mouse.getX();
                    int parentY = mouse.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Mouse && otherAnimal != mouse) {
                            HerbivoreAnimals.Mouse otherMouse = (HerbivoreAnimals.Mouse) otherAnimal;

                            if (!otherMouse.hasReproduce()) {
                                if (mouse.getX() == otherMouse.getX() && mouse.getY() == otherMouse.getY()) {
                                    HerbivoreAnimals.Mouse newMouse = mouse.reproduce(otherMouse);
                                    if (newMouse != null) {
                                        newMouse.setX(parentX);
                                        newMouse.setY(parentY);
                                        newAnimals.add(newMouse);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        mouse.setReproduced(true);
                        System.out.println("Нова " + "миша" + " народилася на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
        }

        // Інша логіка розмноження для інших підкласів
        animalsInLocation.addAll(newAnimals);
    }


}

// Код для класу Animal та інших класів HerbivoreAnimals залишається таким же


