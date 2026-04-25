package main.BasicClasses;

import java.util.Objects;

public class FlatBuilder {
    protected String name; //Поле не может быть null, Строка не может быть пустой
    protected Coordinates coordinates; //Поле не может быть null
    protected double area; //Значение поля должно быть больше 0
    protected int numberOfRooms; //Значение поля должно быть больше 0
    protected Boolean isNew = null; //Поле может быть null
    protected Furnish furnish; //Поле может быть null
    protected Transport transport; //Поле может быть null
    protected House house;  //Поле может быть null


    public FlatBuilder name(String name) {
        this.name = name;
        return this;
    }

    public FlatBuilder coordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public FlatBuilder area(double area) {
        this.area = area;
        return this;
    }

    public FlatBuilder numberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        return this;
    }

    public FlatBuilder isNew(Boolean isNew) {
        this.isNew = isNew;
        return this;
    }

    public FlatBuilder furnish(Furnish furnish) {
        this.furnish = furnish;
        return this;
    }

    public FlatBuilder transport(Transport transport) {
        this.transport = transport;
        return this;
    }

    public FlatBuilder house(House house) {
        this.house = house;
        return this;
    }

    public FlatBuilder() {
        super();
    }

    public Flat build() {
        Flat f1 = null;
        if (ValidateFlat()) {
            f1 = new Flat(this);
        }
        else {
            System.out.println("Недостаточно параметров для объекта Flat!");
        }
        return f1;
    }

    private boolean ValidateFlat() {
        return (!name.isEmpty() && !Objects.isNull(coordinates) && area > 0 && numberOfRooms > 0);
    }
}
