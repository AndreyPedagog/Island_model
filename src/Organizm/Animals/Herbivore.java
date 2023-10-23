package Organizm.Animals;

import Organizm.Plants.Plant;

import java.util.List;

public interface Herbivore {
    void eatPlant(Plant plant);
    public abstract List<HerbivoreAnimals.Caterpillar> findAvailableCaterpillars();

}
