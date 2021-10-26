package by.epam.task;

import java.util.ArrayList;
import java.util.List;

public class Park {

    private static final List<Plant> PLANT_LIST = new ArrayList<>();
    private final PlantFactory plantFactory;
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
        return PLANT_LIST;
    }

    public PlantFactory getPlantFactory() {
        return plantFactory;
    }
}
