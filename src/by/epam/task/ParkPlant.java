package by.epam.task;

public abstract class ParkPlant {

    private String name;
    private int height;

    public ParkPlant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
