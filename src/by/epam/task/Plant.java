package by.epam.task;

public abstract class Plant {

    private final String name;
    private final int height;

    public Plant(String name, int height) {
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
