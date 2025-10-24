package racingcar.model;

public class Car {

    private final int MOVABLE_THRESHOLD = 4;

    private int id;
    private String name;
    private int position;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
        this.position = 0;
    }

    public Car(int id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVABLE_THRESHOLD) {
            position++;
        }
    }
}
