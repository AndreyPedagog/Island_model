package Organizm.Animals;

import Organizm.Plants.Plant;

import java.util.List;

public interface Herbivore {
    void eatPlant(Plant plant);
    boolean canEatCaterpillar(HerbivoreAnimals.Caterpillar caterpillar);

}
