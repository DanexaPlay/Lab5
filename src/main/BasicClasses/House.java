package main.BasicClasses;

public class House implements Comparable<House>{
    private String name; //Поле не может быть null
    private long year; //Значение поля должно быть больше 0
    private long numberOfFlatsOnFloor; //Значение поля должно быть больше 0
    private Integer numberOfLifts; //Значение поля должно быть больше 0

    public void setYear(long year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Год должен быть больше 0!");
        }
        this.year = year;
    }

    public void setNumberOfFlatsOnFloor(long numberOfFlatsOnFloor) {
        if (numberOfFlatsOnFloor < 0) {
            throw new IllegalArgumentException("Количество комнат должно быть больше 0!");
        }
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    public void setNumberOfLifts(Integer numberOfLifts) {
        if (numberOfLifts < 0) {
            throw new IllegalArgumentException("Количество лифтов должно быть больше 0!");
        }
        this.numberOfLifts = numberOfLifts;
    }

    public long getYear() {
        return year;
    }

    public House(String name) {
        this.name = name;
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Неверное имя!");
        }
    }

    public String toString() {
        return "house name: " + name + "\n" + "year: " + Long.toString(year) + "\n" + "number of flats on floor: " + Long.toString(numberOfFlatsOnFloor) + "\n" + "number of lifts: " + numberOfLifts.toString();
    }

    @Override
    public int compareTo(House o) {
        return (int) (this.getYear() - o.getYear());
    }
}