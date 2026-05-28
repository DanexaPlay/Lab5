package main.BasicClasses;

public class House implements Comparable<House> {
    private String name; //Поле не может быть null
    private long year; //Значение поля должно быть больше 0
    private long numberOfFlatsOnFloor; //Значение поля должно быть больше 0
    private Integer numberOfLifts; //Значение поля должно быть больше 0

    public House(HouseBuilder houseBuilder) {
        if (houseBuilder == null) {
            throw new IllegalArgumentException("Не создан HouseBuilder!");
        }
        if (houseBuilder.name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым!");
        }
        if (houseBuilder.year < 0) {
            throw new IllegalArgumentException("Год должен быть не меньше 0!");
        }
        if (houseBuilder.numberOfLifts <= 0) {
            throw new IllegalArgumentException("Количество лифтов должно быть больше 0!");
        }
        if (houseBuilder.numberOfFlatsOnFloor <= 0) {
            throw new IllegalArgumentException("Количество квартир на этаж должно быть больше 0!");
        }
        this.name = houseBuilder.name;
        this.year = houseBuilder.year;
        this.numberOfLifts = houseBuilder.numberOfLifts;
        this.numberOfFlatsOnFloor = houseBuilder.numberOfFlatsOnFloor;
    }

    public long getYear() {
        return year;
    }

    public String toString() {
        return "house name: " + name + "\n" + "year: " + Long.toString(year) + "\n" + "number of flats on floor: " + Long.toString(numberOfFlatsOnFloor) + "\n" + "number of lifts: " + numberOfLifts.toString();
    }

    @Override
    public int compareTo(House o) {
        return (int) (this.getYear() - o.getYear());
    }
}