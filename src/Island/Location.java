package Island;

import Organizm.Animals.*;
import Organizm.Plants.Plant;

import java.util.*;

public class Location {
    private final Random random = new Random();
    public static final List<Animal> animalsInLocation = new ArrayList<>();
    private static int width;
    private static int height;
    Plant[][] plants;

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
        plants = new Plant[width][height];
    }

    public void addPlant(Plant plant, int x, int y) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            // Перевіряємо, чи координати (x, y) знаходяться в межах локації
            if (plants[x][y] == null) {
                // Якщо на цій ділянці ще немає рослини, то додаємо її
                plants[x][y] = plant;
            }
        }
    }
    public Plant getPlant(int x, int y) {
        if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
            return plants[x][y];
        }
        return null;
    }

    public void removePlant(int x, int y) {
        plants[x][y] = null;
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
                            } else {
                                System.out.println(HerbivoreAnimals.Mouse.getName() + " не зміг з'їсти " + HerbivoreAnimals.Caterpillar.getName());
                            }
                        }
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Duck) {
                HerbivoreAnimals.Duck duck = (HerbivoreAnimals.Duck) animal;
                for (Animal caterpillar : animalsInLocation) {
                    if (caterpillar instanceof HerbivoreAnimals.Caterpillar) {
                        HerbivoreAnimals.Caterpillar c = (HerbivoreAnimals.Caterpillar) caterpillar;
                        if (duck.getX() == c.getX() && duck.getY() == c.getY()) {
                            if (random.nextDouble() <= 0.9 && duck.canEatCaterpillar(c)) {
                                duck.eatCaterpillar(c);
                            } else {
                                System.out.println(HerbivoreAnimals.Duck.getName() + " не зміг з'їсти " + HerbivoreAnimals.Caterpillar.getName());
                            }
                        }
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Boar) {
                HerbivoreAnimals.Boar boar = (HerbivoreAnimals.Boar) animal;
                for (Animal caterpillar : animalsInLocation) {
                    if (caterpillar instanceof HerbivoreAnimals.Caterpillar) {
                        HerbivoreAnimals.Caterpillar c = (HerbivoreAnimals.Caterpillar) caterpillar;
                        if (boar.getX() == c.getX() && boar.getY() == c.getY()) {
                            if (random.nextDouble() <= 0.9 && boar.canEatCaterpillar(c)) {
                                boar.eatCaterpillar(c);
                            } else {
                                System.out.println(HerbivoreAnimals.Boar.getName() + " не зміг з'їсти " + HerbivoreAnimals.Caterpillar.getName());
                            }
                        }
                    }
                }
            }


            if (animal instanceof CarnivoreAnimals.Wolf) {
                CarnivoreAnimals.Wolf wolf = (CarnivoreAnimals.Wolf) animal;
                for (Animal mouse : animalsInLocation) {
                    if (mouse instanceof HerbivoreAnimals.Mouse) {
                        HerbivoreAnimals.Mouse m = (HerbivoreAnimals.Mouse) mouse;
                        if (wolf.getX() == m.getX() && wolf.getY() == m.getY()) {
                            if (random.nextDouble() <= 0.8 && wolf.canEatMouse(m)) {
                                wolf.eatMouse(m);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Mouse.getName());
                            }
                        }
                    }
                }
                for (Animal horse : animalsInLocation) {
                    if (horse instanceof HerbivoreAnimals.Horse) {
                        HerbivoreAnimals.Horse h = (HerbivoreAnimals.Horse) horse;
                        if (wolf.getX() == h.getX() && wolf.getY() == h.getY()) {
                            if (random.nextDouble() <= 0.1 && wolf.canEatHorse(h)) {
                                wolf.eatHorse(h);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Horse.getName());
                            }
                        }
                    }
                }
                for (Animal rabbit : animalsInLocation) {
                    if (rabbit instanceof HerbivoreAnimals.Rabbit) {
                        HerbivoreAnimals.Rabbit r = (HerbivoreAnimals.Rabbit) rabbit;
                        if (wolf.getX() == r.getX() && wolf.getY() == r.getY()) {
                            if (random.nextDouble() <= 0.6 && wolf.canEatRabbit(r)) {
                                wolf.eatRabbit(r);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Rabbit.getName());
                            }
                        }
                    }
                }
                for (Animal deer : animalsInLocation) {
                    if (deer instanceof HerbivoreAnimals.Deer) {
                        HerbivoreAnimals.Deer d = (HerbivoreAnimals.Deer) deer;
                        if (wolf.getX() == d.getX() && wolf.getY() == d.getY()) {
                            if (random.nextDouble() <= 0.15 && wolf.canEatDeer(d)) {
                                wolf.eatDeer(d);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Deer.getName());
                            }
                        }
                    }
                }
                for (Animal goat : animalsInLocation) {
                    if (goat instanceof HerbivoreAnimals.Goat) {
                        HerbivoreAnimals.Goat g = (HerbivoreAnimals.Goat) goat;
                        if (wolf.getX() == g.getX() && wolf.getY() == g.getY()) {
                            if (random.nextDouble() <= 0.6 && wolf.canEatGoat(g)) {
                                wolf.eatGoat(g);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Goat.getName());
                            }
                        }
                    }
                }
                for (Animal boar : animalsInLocation) {
                    if (boar instanceof HerbivoreAnimals.Boar) {
                        HerbivoreAnimals.Boar b = (HerbivoreAnimals.Boar) boar;
                        if (wolf.getX() == b.getX() && wolf.getY() == b.getY()) {
                            if (random.nextDouble() <= 0.15 && wolf.canEatBoar(b)) {
                                wolf.eatBoar(b);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Boar.getName());
                            }
                        }
                    }
                }
                for (Animal sheep : animalsInLocation) {
                    if (sheep instanceof HerbivoreAnimals.Sheep) {
                        HerbivoreAnimals.Sheep s = (HerbivoreAnimals.Sheep) sheep;
                        if (wolf.getX() == s.getX() && wolf.getY() == s.getY()) {
                            if (random.nextDouble() <= 0.7 && wolf.canEatSheep(s)) {
                                wolf.eatSheep(s);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Sheep.getName());
                            }
                        }
                    }
                }
                for (Animal buffalo : animalsInLocation) {
                    if (buffalo instanceof HerbivoreAnimals.Buffalo) {
                        HerbivoreAnimals.Buffalo b = (HerbivoreAnimals.Buffalo) buffalo;
                        if (wolf.getX() == b.getX() && wolf.getY() == b.getY()) {
                            if (random.nextDouble() <= 0.1 && wolf.canEatBuffalo(b)) {
                                wolf.eatBuffalo(b);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Buffalo.getName());
                            }
                        }
                    }
                }
                for (Animal duck : animalsInLocation) {
                    if (duck instanceof HerbivoreAnimals.Duck) {
                        HerbivoreAnimals.Duck d = (HerbivoreAnimals.Duck) duck;
                        if (wolf.getX() == d.getX() && wolf.getY() == d.getY()) {
                            if (random.nextDouble() <= 0.4 && wolf.canEatDuck(d)) {
                                wolf.eatDuck(d);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Duck.getName());
                            }
                        }
                    }
                }
            }


            if (animal instanceof CarnivoreAnimals.Fox) {
                CarnivoreAnimals.Fox fox = (CarnivoreAnimals.Fox) animal;
                for (Animal mouse : animalsInLocation) {
                    if (mouse instanceof HerbivoreAnimals.Mouse) {
                        HerbivoreAnimals.Mouse m = (HerbivoreAnimals.Mouse) mouse;
                        if (fox.getX() == m.getX() && fox.getY() == m.getY()) {
                            if (random.nextDouble() <= 0.9 && fox.canEatMouse(m)) {
                                fox.eatMouse(m);
                            } else {
                                System.out.println(CarnivoreAnimals.Fox.getName() + " не зміг з'їсти " + HerbivoreAnimals.Mouse.getName());
                            }
                        }
                    }
                }
                for (Animal rabbit : animalsInLocation) {
                    if (rabbit instanceof HerbivoreAnimals.Rabbit) {
                        HerbivoreAnimals.Rabbit r = (HerbivoreAnimals.Rabbit) rabbit;
                        if (fox.getX() == r.getX() && fox.getY() == r.getY()) {
                            if (random.nextDouble() <= 0.7 && fox.canEatRabbit(r)) {
                                fox.eatRabbit(r);
                            } else {
                                System.out.println(CarnivoreAnimals.Fox.getName() + " не зміг з'їсти " + HerbivoreAnimals.Rabbit.getName());
                            }
                        }
                    }
                }
                for (Animal duck : animalsInLocation) {
                    if (duck instanceof HerbivoreAnimals.Duck) {
                        HerbivoreAnimals.Duck d = (HerbivoreAnimals.Duck) duck;
                        if (fox.getX() == d.getX() && fox.getY() == d.getY()) {
                            if (random.nextDouble() <= 0.6 && fox.canEatDuck(d)) {
                                fox.eatDuck(d);
                            } else {
                                System.out.println(CarnivoreAnimals.Fox.getName() + " не зміг з'їсти " + HerbivoreAnimals.Duck.getName());
                            }
                        }
                    }
                }
            }

            if (animal instanceof CarnivoreAnimals.Snake) {
                CarnivoreAnimals.Snake snake = (CarnivoreAnimals.Snake) animal;
                for (Animal mouse : animalsInLocation) {
                    if (mouse instanceof HerbivoreAnimals.Mouse) {
                        HerbivoreAnimals.Mouse m = (HerbivoreAnimals.Mouse) mouse;
                        if (snake.getX() == m.getX() && snake.getY() == m.getY()) {
                            if (random.nextDouble() <= 0.4 && snake.canEatMouse(m)) {
                                snake.eatMouse(m);
                            } else {
                                System.out.println(CarnivoreAnimals.Snake.getName() + " не зміг з'їсти " + HerbivoreAnimals.Mouse.getName());
                            }
                        }
                    }
                }
                for (Animal rabbit : animalsInLocation) {
                    if (rabbit instanceof HerbivoreAnimals.Rabbit) {
                        HerbivoreAnimals.Rabbit r = (HerbivoreAnimals.Rabbit) rabbit;
                        if (snake.getX() == r.getX() && snake.getY() == r.getY()) {
                            if (random.nextDouble() <= 0.2 && snake.canEatRabbit(r)) {
                                snake.eatRabbit(r);
                            } else {
                                System.out.println(CarnivoreAnimals.Snake.getName() + " не зміг з'їсти " + HerbivoreAnimals.Rabbit.getName());
                            }
                        }
                    }
                }
                for (Animal duck : animalsInLocation) {
                    if (duck instanceof HerbivoreAnimals.Duck) {
                        HerbivoreAnimals.Duck d = (HerbivoreAnimals.Duck) duck;
                        if (snake.getX() == d.getX() && snake.getY() == d.getY()) {
                            if (random.nextDouble() <= 0.1 && snake.canEatDuck(d)) {
                                snake.eatDuck(d);
                            } else {
                                System.out.println(CarnivoreAnimals.Snake.getName() + " не зміг з'їсти " + HerbivoreAnimals.Duck.getName());
                            }
                        }
                    }
                }
            }


            if (animal instanceof CarnivoreAnimals.Bear) {
                CarnivoreAnimals.Bear bear = (CarnivoreAnimals.Bear) animal;
                for (Animal mouse : animalsInLocation) {
                    if (mouse instanceof HerbivoreAnimals.Mouse) {
                        HerbivoreAnimals.Mouse m = (HerbivoreAnimals.Mouse) mouse;
                        if (bear.getX() == m.getX() && bear.getY() == m.getY()) {
                            if (random.nextDouble() <= 0.9 && bear.canEatMouse(m)) {
                                bear.eatMouse(m);
                            } else {
                                System.out.println(CarnivoreAnimals.Bear.getName() + " не зміг з'їсти " + HerbivoreAnimals.Mouse.getName());
                            }
                        }
                    }
                }
                for (Animal horse : animalsInLocation) {
                    if (horse instanceof HerbivoreAnimals.Horse) {
                        HerbivoreAnimals.Horse h = (HerbivoreAnimals.Horse) horse;
                        if (bear.getX() == h.getX() && bear.getY() == h.getY()) {
                            if (random.nextDouble() <= 0.1 && bear.canEatHorse(h)) {
                                bear.eatHorse(h);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Horse.getName());
                            }
                        }
                    }
                }
                for (Animal rabbit : animalsInLocation) {
                    if (rabbit instanceof HerbivoreAnimals.Rabbit) {
                        HerbivoreAnimals.Rabbit r = (HerbivoreAnimals.Rabbit) rabbit;
                        if (bear.getX() == r.getX() && bear.getY() == r.getY()) {
                            if (random.nextDouble() <= 0.8 && bear.canEatRabbit(r)) {
                                bear.eatRabbit(r);
                            } else {
                                System.out.println(CarnivoreAnimals.Bear.getName() + " не зміг з'їсти " + HerbivoreAnimals.Rabbit.getName());
                            }
                        }
                    }
                }
                for (Animal deer : animalsInLocation) {
                    if (deer instanceof HerbivoreAnimals.Deer) {
                        HerbivoreAnimals.Deer d = (HerbivoreAnimals.Deer) deer;
                        if (bear.getX() == d.getX() && bear.getY() == d.getY()) {
                            if (random.nextDouble() <= 0.8 && bear.canEatDeer(d)) {
                                bear.eatDeer(d);
                            } else {
                                System.out.println(CarnivoreAnimals.Bear.getName() + " не зміг з'їсти " + HerbivoreAnimals.Deer.getName());
                            }
                        }
                    }
                }
                for (Animal goat : animalsInLocation) {
                    if (goat instanceof HerbivoreAnimals.Goat) {
                        HerbivoreAnimals.Goat g = (HerbivoreAnimals.Goat) goat;
                        if (bear.getX() == g.getX() && bear.getY() == g.getY()) {
                            if (random.nextDouble() <= 0.7 && bear.canEatGoat(g)) {
                                bear.eatGoat(g);
                            } else {
                                System.out.println(CarnivoreAnimals.Bear.getName() + " не зміг з'їсти " + HerbivoreAnimals.Goat.getName());
                            }
                        }
                    }
                }
                for (Animal boar : animalsInLocation) {
                    if (boar instanceof HerbivoreAnimals.Boar) {
                        HerbivoreAnimals.Boar b = (HerbivoreAnimals.Boar) boar;
                        if (bear.getX() == b.getX() && bear.getY() == b.getY()) {
                            if (random.nextDouble() <= 0.5 && bear.canEatBoar(b)) {
                                bear.eatBoar(b);
                            } else {
                                System.out.println(CarnivoreAnimals.Bear.getName() + " не зміг з'їсти " + HerbivoreAnimals.Boar.getName());
                            }
                        }
                    }
                }
                for (Animal sheep : animalsInLocation) {
                    if (sheep instanceof HerbivoreAnimals.Sheep) {
                        HerbivoreAnimals.Sheep s = (HerbivoreAnimals.Sheep) sheep;
                        if (bear.getX() == s.getX() && bear.getY() == s.getY()) {
                            if (random.nextDouble() <= 0.7 && bear.canEatSheep(s)) {
                                bear.eatSheep(s);
                            } else {
                                System.out.println(CarnivoreAnimals.Bear.getName() + " не зміг з'їсти " + HerbivoreAnimals.Sheep.getName());
                            }
                        }
                    }
                }
                for (Animal buffalo : animalsInLocation) {
                    if (buffalo instanceof HerbivoreAnimals.Buffalo) {
                        HerbivoreAnimals.Buffalo b = (HerbivoreAnimals.Buffalo) buffalo;
                        if (bear.getX() == b.getX() && bear.getY() == b.getY()) {
                            if (random.nextDouble() <= 0.2 && bear.canEatBuffalo(b)) {
                                bear.eatBuffalo(b);
                            } else {
                                System.out.println(CarnivoreAnimals.Bear.getName() + " не зміг з'їсти " + HerbivoreAnimals.Buffalo.getName());
                            }
                        }
                    }
                }
                for (Animal duck : animalsInLocation) {
                    if (duck instanceof HerbivoreAnimals.Duck) {
                        HerbivoreAnimals.Duck d = (HerbivoreAnimals.Duck) duck;
                        if (bear.getX() == d.getX() && bear.getY() == d.getY()) {
                            if (random.nextDouble() <= 0.1 && bear.canEatDuck(d)) {
                                bear.eatDuck(d);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + HerbivoreAnimals.Duck.getName());
                            }
                        }
                    }
                }
                for (Animal fox : animalsInLocation) {
                    if (fox instanceof CarnivoreAnimals.Fox) {
                        CarnivoreAnimals.Fox f = (CarnivoreAnimals.Fox) fox;
                        if (bear.getX() == f.getX() && bear.getY() == f.getY()) {
                            if (random.nextDouble() <= 0.1 && bear.canEatFox(f)) {
                                bear.eatFox(f);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + CarnivoreAnimals.Fox.getName());
                            }
                        }
                    }
                }
            }


            if (animal instanceof CarnivoreAnimals.Eagle) {
                CarnivoreAnimals.Eagle eagle = (CarnivoreAnimals.Eagle) animal;
                for (Animal mouse : animalsInLocation) {
                    if (mouse instanceof HerbivoreAnimals.Mouse) {
                        HerbivoreAnimals.Mouse m = (HerbivoreAnimals.Mouse) mouse;
                        if (eagle.getX() == m.getX() && eagle.getY() == m.getY()) {
                            if (random.nextDouble() <= 0.9 && eagle.canEatMouse(m)) {
                                eagle.eatMouse(m);
                            } else {
                                System.out.println(CarnivoreAnimals.Eagle.getName() + " не зміг з'їсти " + HerbivoreAnimals.Mouse.getName());
                            }
                        }
                    }
                }
                for (Animal rabbit : animalsInLocation) {
                    if (rabbit instanceof HerbivoreAnimals.Rabbit) {
                        HerbivoreAnimals.Rabbit r = (HerbivoreAnimals.Rabbit) rabbit;
                        if (eagle.getX() == r.getX() && eagle.getY() == r.getY()) {
                            if (random.nextDouble() <= 0.9 && eagle.canEatRabbit(r)) {
                                eagle.eatRabbit(r);
                            } else {
                                System.out.println(CarnivoreAnimals.Eagle.getName() + " не зміг з'їсти " + HerbivoreAnimals.Rabbit.getName());
                            }
                        }
                    }
                }
                for (Animal duck : animalsInLocation) {
                    if (duck instanceof HerbivoreAnimals.Duck) {
                        HerbivoreAnimals.Duck d = (HerbivoreAnimals.Duck) duck;
                        if (eagle.getX() == d.getX() && eagle.getY() == d.getY()) {
                            if (random.nextDouble() <= 0.8 && eagle.canEatDuck(d)) {
                                eagle.eatDuck(d);
                            } else {
                                System.out.println(CarnivoreAnimals.Eagle.getName() + " не зміг з'їсти " + HerbivoreAnimals.Duck.getName());
                            }
                        }
                    }
                }
                for (Animal fox : animalsInLocation) {
                    if (fox instanceof CarnivoreAnimals.Fox) {
                        CarnivoreAnimals.Fox f = (CarnivoreAnimals.Fox) fox;
                        if (eagle.getX() == f.getX() && eagle.getY() == f.getY()) {
                            if (random.nextDouble() <= 0.1 && eagle.canEatFox(f)) {
                                eagle.eatFox(f);
                            } else {
                                System.out.println(CarnivoreAnimals.Wolf.getName() + " не зміг з'їсти " + CarnivoreAnimals.Fox.getName());
                            }
                        }
                    }
                }
            }
        }


        for (Animal animal : animalsInLocation) {
            if (animal instanceof HerbivoreAnimals.Horse) {
                HerbivoreAnimals.Horse horse = (HerbivoreAnimals.Horse) animal;

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
            if (animal instanceof HerbivoreAnimals.Mouse) {
                HerbivoreAnimals.Mouse mouse = (HerbivoreAnimals.Mouse) animal;

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
            if (animal instanceof CarnivoreAnimals.Wolf) {
                CarnivoreAnimals.Wolf wolf = (CarnivoreAnimals.Wolf) animal;

                if (!wolf.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = wolf.getX();
                    int parentY = wolf.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof CarnivoreAnimals.Wolf && otherAnimal != wolf) {
                            CarnivoreAnimals.Wolf otherWolf = (CarnivoreAnimals.Wolf) otherAnimal;

                            if (!otherWolf.hasReproduce()) {
                                if (wolf.getX() == otherWolf.getX() && wolf.getY() == otherWolf.getY()) {
                                    CarnivoreAnimals.Wolf newWolf = wolf.reproduce(otherWolf);
                                    if (newWolf != null) {
                                        newWolf.setX(parentX);
                                        newWolf.setY(parentY);
                                        newAnimals.add(newWolf);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        wolf.setReproduced(true);
                        System.out.println("Новий " + "вовк" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Deer) {
                HerbivoreAnimals.Deer deer = (HerbivoreAnimals.Deer) animal;

                if (!deer.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = deer.getX();
                    int parentY = deer.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Deer && otherAnimal != deer) {
                            HerbivoreAnimals.Deer otherDeer = (HerbivoreAnimals.Deer) otherAnimal;

                            if (!otherDeer.hasReproduce()) {
                                if (deer.getX() == otherDeer.getX() && deer.getY() == otherDeer.getY()) {
                                    HerbivoreAnimals.Deer newDeer = deer.reproduce(otherDeer);
                                    if (newDeer != null) {
                                        newDeer.setX(parentX);
                                        newDeer.setY(parentY);
                                        newAnimals.add(newDeer);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        deer.setReproduced(true);
                        System.out.println("Новий " + "олень" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Rabbit) {
                HerbivoreAnimals.Rabbit rabbit = (HerbivoreAnimals.Rabbit) animal;

                if (!rabbit.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = rabbit.getX();
                    int parentY = rabbit.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Rabbit && otherAnimal != rabbit) {
                            HerbivoreAnimals.Rabbit otherRabbit = (HerbivoreAnimals.Rabbit) otherAnimal;

                            if (!otherRabbit.hasReproduce()) {
                                if (rabbit.getX() == otherRabbit.getX() && rabbit.getY() == otherRabbit.getY()) {
                                    HerbivoreAnimals.Rabbit newRabbit = rabbit.reproduce(otherRabbit);
                                    if (newRabbit != null) {
                                        newRabbit.setX(parentX);
                                        newRabbit.setY(parentY);
                                        newAnimals.add(newRabbit);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        rabbit.setReproduced(true);
                        System.out.println("Новий " + "кролик" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Goat) {
                HerbivoreAnimals.Goat goat = (HerbivoreAnimals.Goat) animal;

                if (!goat.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = goat.getX();
                    int parentY = goat.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Goat && otherAnimal != goat) {
                            HerbivoreAnimals.Goat otherGoat = (HerbivoreAnimals.Goat) otherAnimal;

                            if (!otherGoat.hasReproduce()) {
                                if (goat.getX() == otherGoat.getX() && goat.getY() == otherGoat.getY()) {
                                    HerbivoreAnimals.Goat newGoat = goat.reproduce(otherGoat);
                                    if (newGoat != null) {
                                        newGoat.setX(parentX);
                                        newGoat.setY(parentY);
                                        newAnimals.add(newGoat);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        goat.setReproduced(true);
                        System.out.println("Нова " + "коза" + " народилася на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Sheep) {
                HerbivoreAnimals.Sheep sheep = (HerbivoreAnimals.Sheep) animal;

                if (!sheep.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = sheep.getX();
                    int parentY = sheep.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Sheep && otherAnimal != sheep) {
                            HerbivoreAnimals.Sheep otherSheep = (HerbivoreAnimals.Sheep) otherAnimal;

                            if (!otherSheep.hasReproduce()) {
                                if (sheep.getX() == otherSheep.getX() && sheep.getY() == otherSheep.getY()) {
                                    HerbivoreAnimals.Sheep newSheep = sheep.reproduce(otherSheep);
                                    if (newSheep != null) {
                                        newSheep.setX(parentX);
                                        newSheep.setY(parentY);
                                        newAnimals.add(newSheep);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        sheep.setReproduced(true);
                        System.out.println("Нова " + "вівця" + " народилася на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Boar) {
                HerbivoreAnimals.Boar boar = (HerbivoreAnimals.Boar) animal;

                if (!boar.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = boar.getX();
                    int parentY = boar.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Boar && otherAnimal != boar) {
                            HerbivoreAnimals.Boar otherBoar = (HerbivoreAnimals.Boar) otherAnimal;

                            if (!otherBoar.hasReproduce()) {
                                if (boar.getX() == otherBoar.getX() && boar.getY() == otherBoar.getY()) {
                                    HerbivoreAnimals.Boar newBoar = boar.reproduce(otherBoar);
                                    if (newBoar != null) {
                                        newBoar.setX(parentX);
                                        newBoar.setY(parentY);
                                        newAnimals.add(newBoar);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        boar.setReproduced(true);
                        System.out.println("Новий " + "кабан" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Buffalo) {
                HerbivoreAnimals.Buffalo buffalo = (HerbivoreAnimals.Buffalo) animal;

                if (!buffalo.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = buffalo.getX();
                    int parentY = buffalo.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Buffalo && otherAnimal != buffalo) {
                            HerbivoreAnimals.Buffalo otherBuffalo = (HerbivoreAnimals.Buffalo) otherAnimal;

                            if (!otherBuffalo.hasReproduce()) {
                                if (buffalo.getX() == otherBuffalo.getX() && buffalo.getY() == otherBuffalo.getY()) {
                                    HerbivoreAnimals.Buffalo newBuffalo = buffalo.reproduce(otherBuffalo);
                                    if (newBuffalo != null) {
                                        newBuffalo.setX(parentX);
                                        newBuffalo.setY(parentY);
                                        newAnimals.add(newBuffalo);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        buffalo.setReproduced(true);
                        System.out.println("Новий " + "буйвол" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof HerbivoreAnimals.Duck) {
                HerbivoreAnimals.Duck duck = (HerbivoreAnimals.Duck) animal;

                if (!duck.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = duck.getX();
                    int parentY = duck.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof HerbivoreAnimals.Duck && otherAnimal != duck) {
                            HerbivoreAnimals.Duck otherDuck = (HerbivoreAnimals.Duck) otherAnimal;

                            if (!otherDuck.hasReproduce()) {
                                if (duck.getX() == otherDuck.getX() && duck.getY() == otherDuck.getY()) {
                                    HerbivoreAnimals.Duck newDuck = duck.reproduce(otherDuck);
                                    if (newDuck != null) {
                                        newDuck.setX(parentX);
                                        newDuck.setY(parentY);
                                        newAnimals.add(newDuck);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        duck.setReproduced(true);
                        System.out.println("Нова " + "качка" + " народилася на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof CarnivoreAnimals.Snake) {
                CarnivoreAnimals.Snake snake = (CarnivoreAnimals.Snake) animal;

                if (!snake.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = snake.getX();
                    int parentY = snake.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof CarnivoreAnimals.Snake && otherAnimal != snake) {
                            CarnivoreAnimals.Snake otherSnake = (CarnivoreAnimals.Snake) otherAnimal;

                            if (!otherSnake.hasReproduce()) {
                                if (snake.getX() == otherSnake.getX() && snake.getY() == otherSnake.getY()) {
                                    CarnivoreAnimals.Snake newSnake = snake.reproduce(otherSnake);
                                    if (newSnake != null) {
                                        newSnake.setX(parentX);
                                        newSnake.setY(parentY);
                                        newAnimals.add(newSnake);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        snake.setReproduced(true);
                        System.out.println("Новий " + "удав" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof CarnivoreAnimals.Fox) {
                CarnivoreAnimals.Fox fox = (CarnivoreAnimals.Fox) animal;

                if (!fox.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = fox.getX();
                    int parentY = fox.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof CarnivoreAnimals.Fox && otherAnimal != fox) {
                            CarnivoreAnimals.Fox otherFox = (CarnivoreAnimals.Fox) otherAnimal;

                            if (!otherFox.hasReproduce()) {
                                if (fox.getX() == otherFox.getX() && fox.getY() == otherFox.getY()) {
                                    CarnivoreAnimals.Fox newFox = fox.reproduce(otherFox);
                                    if (otherFox != null) {
                                        otherFox.setX(parentX);
                                        otherFox.setY(parentY);
                                        newAnimals.add(otherAnimal);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        fox.setReproduced(true);
                        System.out.println("Нова " + "лисиця" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }

            if (animal instanceof CarnivoreAnimals.Bear) {
                CarnivoreAnimals.Bear bear = (CarnivoreAnimals.Bear) animal;

                if (!bear.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = bear.getX();
                    int parentY = bear.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof CarnivoreAnimals.Bear && otherAnimal != bear) {
                            CarnivoreAnimals.Bear otherBear = (CarnivoreAnimals.Bear) otherAnimal;

                            if (!otherBear.hasReproduce()) {
                                if (bear.getX() == otherBear.getX() && bear.getY() == otherBear.getY()) {
                                    CarnivoreAnimals.Bear newBear = bear.reproduce(otherBear);
                                    if (newBear != null) {
                                        newBear.setX(parentX);
                                        newBear.setY(parentY);
                                        newAnimals.add(newBear);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        bear.setReproduced(true);
                        System.out.println("Новий " + "ведмідь" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
            if (animal instanceof CarnivoreAnimals.Eagle) {
                CarnivoreAnimals.Eagle eagle = (CarnivoreAnimals.Eagle) animal;

                if (!eagle.hasReproduce()) {
                    boolean hasSuccessfullyReproduced = false;
                    int parentX = eagle.getX();
                    int parentY = eagle.getY();

                    for (Animal otherAnimal : animalsInLocation) {
                        if (otherAnimal instanceof CarnivoreAnimals.Eagle && otherAnimal != eagle) {
                            CarnivoreAnimals.Eagle otherEagle = (CarnivoreAnimals.Eagle) otherAnimal;

                            if (!otherEagle.hasReproduce()) {
                                if (eagle.getX() == otherEagle.getX() && eagle.getY() == otherEagle.getY()) {
                                    CarnivoreAnimals.Eagle newEagle = eagle.reproduce(otherEagle);
                                    if (newEagle != null) {
                                        newEagle.setX(parentX);
                                        newEagle.setY(parentY);
                                        newAnimals.add(newEagle);
                                        hasSuccessfullyReproduced = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (hasSuccessfullyReproduced) {
                        eagle.setReproduced(true);
                        System.out.println("Новий " + "орел" + " народився на ділянці " +
                                " на координатах X=" + parentX + ", Y=" + parentY);
                    }
                }
            }
        }

        for (Animal animal : animalsInLocation) {
            if (animal instanceof HerbivoreAnimals.Mouse) {
                HerbivoreAnimals.Mouse mouse = (HerbivoreAnimals.Mouse) animal;
                int x = mouse.getX();
                int y = mouse.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && mouse.canEatPlant(plant)) {
                    mouse.eatPlant(plant);
                }
            }

            if (animal instanceof HerbivoreAnimals.Horse) {
                HerbivoreAnimals.Horse horse = (HerbivoreAnimals.Horse) animal;
                int x = horse.getX();
                int y = horse.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && horse.canEatPlant(plant)) {
                    horse.eatPlant(plant);
                }
            }
            if (animal instanceof HerbivoreAnimals.Deer) {
                HerbivoreAnimals.Deer deer = (HerbivoreAnimals.Deer) animal;
                int x = deer.getX();
                int y = deer.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && deer.canEatPlant(plant)) {
                    deer.eatPlant(plant);
                }
            }
            if (animal instanceof HerbivoreAnimals.Rabbit) {
                HerbivoreAnimals.Rabbit rabbit = (HerbivoreAnimals.Rabbit) animal;
                int x = rabbit.getX();
                int y = rabbit.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && rabbit.canEatPlant(plant)) {
                    rabbit.eatPlant(plant);
                }
            }
            if (animal instanceof HerbivoreAnimals.Goat) {
                HerbivoreAnimals.Goat goat = (HerbivoreAnimals.Goat) animal;
                int x = goat.getX();
                int y = goat.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && goat.canEatPlant(plant)) {
                    goat.eatPlant(plant);
                }
            }
            if (animal instanceof HerbivoreAnimals.Sheep) {
                HerbivoreAnimals.Sheep sheep = (HerbivoreAnimals.Sheep) animal;
                int x = sheep.getX();
                int y = sheep.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && sheep.canEatPlant(plant)) {
                    sheep.eatPlant(plant);
                }
            }
            if (animal instanceof HerbivoreAnimals.Boar) {
                HerbivoreAnimals.Boar boar = (HerbivoreAnimals.Boar) animal;
                int x = boar.getX();
                int y = boar.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && boar.canEatPlant(plant)) {
                    boar.eatPlant(plant);
                }
            }
            if (animal instanceof HerbivoreAnimals.Buffalo) {
                HerbivoreAnimals.Buffalo buffalo = (HerbivoreAnimals.Buffalo) animal;
                int x = buffalo.getX();
                int y = buffalo.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && buffalo.canEatPlant(plant)) {
                    buffalo.eatPlant(plant);
                }
            }
            if (animal instanceof HerbivoreAnimals.Duck) {
                HerbivoreAnimals.Duck duck = (HerbivoreAnimals.Duck) animal;
                int x = duck.getX();
                int y = duck.getY();
                Plant plant = getPlant(x, y);
                if (plant != null && duck.canEatPlant(plant)) {
                    duck.eatPlant(plant);
                }
            }
        }
        // Інша логіка розмноження для інших підкласів
        animalsInLocation.addAll(newAnimals);
    }

}

// Код для класу Animal та інших класів HerbivoreAnimals залишається таким же


