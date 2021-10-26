package by.epam.task;

import java.util.ArrayList;
import java.util.List;

public class Park {

    private final PlantFactory plantFactory;
    private static final List<Plant> park = new ArrayList<>();
    private static Park instance;

    private Park(PlantFactory plantFactory) {
        this.plantFactory = plantFactory;
    }

    public static Park getInstance(PlantFactory plantFactory) {
        if (instance == null) {
            instance = new Park(plantFactory);
        }
        return instance;
    }

    public List<Plant> getListOfParkPlants() {
        return park;
    }

    public PlantFactory getPlantFactory() {
        return plantFactory;
    }
}