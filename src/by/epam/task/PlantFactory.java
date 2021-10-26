package by.epam.task;

public class PlantFactory {

    public Plant growPlant (PlantType type, String name, int height) {
        Plant plant = null;

        switch (type) {
            case TREE:
                plant = new Tree(name, height);
                break;
            case BUSH:
                plant = new Bush(name, height);
                break;
        }

        return plant;
    }
}