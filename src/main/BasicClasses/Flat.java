package main.BasicClasses;

import com.thoughtworks.xstream.mapper.Mapper;

import java.time.LocalDate;
import java.util.Objects;

public class Flat implements Comparable<Flat> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double area; //Значение поля должно быть больше 0
    private int numberOfRooms; //Значение поля должно быть больше 0
    private Boolean isNew; //Поле может быть null
    private Furnish furnish; //Поле может быть null
    private Transport transport; //Поле может быть null
    private House house; //Поле может быть null

    static Long idCount = 0L;

    static {
        idCount += 1;
    }

    public House getHouse() {
        return house;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public Flat(FlatBuilder flatBuilder) {
        if (flatBuilder == null) {
            throw new IllegalArgumentException("Не создан FlatBuilder!");
        }
        if (flatBuilder.name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым!");
        }
        if (Objects.isNull(flatBuilder.coordinates)) {
            throw new IllegalArgumentException("Нет координат!");
        }
        if (flatBuilder.area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть больше 0!");
        }
        if (flatBuilder.numberOfRooms <= 0) {
            throw new IllegalArgumentException("Количество комнат должно быть больше 0!");
        }
        id = ++idCount;
        this.name = flatBuilder.name;
        this.coordinates = flatBuilder.coordinates;
        creationDate = LocalDate.now();
        this.area = flatBuilder.area;
        this.numberOfRooms = flatBuilder.numberOfRooms;
        this.isNew = flatBuilder.isNew;
        this.furnish = flatBuilder.furnish;
        this.transport = flatBuilder.transport;
        this.house = flatBuilder.house;
    }

    public String toString() {
        String s = "";
        s += "id: " + id.toString() + "\n";
        s += "name: " + name + "\n";
        s += "coordinates: " + coordinates.toString() + "\n";
        s += "creation date: " + creationDate.toString() + "\n";
        s += "area: " + Double.toString(area) + "\n";
        s += "number of rooms: " + Integer.toString(numberOfRooms) + "\n";
        s += "is new: " + isNew.toString() + "\n";
        s += "furnish: ";
        try {
            s += furnish.toString() + "\n";
        }
        catch (NullPointerException e1) {
            s += " " + "\n";
        }
        s += "transport: ";
        try {
            s += transport.toString() + "\n";
        }
        catch (NullPointerException e2) {
            s += " " + "\n";
        }
        s += house.toString();
        return s;
    }

    public void setId(long id) {
        this.id = id;
        idCount--;
    }

    @Override
    public int compareTo(Flat o) {
        return (int) (this.getId() - o.getId());
    }
}
