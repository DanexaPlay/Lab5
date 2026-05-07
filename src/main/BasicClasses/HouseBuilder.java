package main.BasicClasses;

public class HouseBuilder {
    protected String name; //Поле не может быть null
    protected long year; //Значение поля должно быть больше 0
    protected long numberOfFlatsOnFloor; //Значение поля должно быть больше 0
    protected Integer numberOfLifts; //Значение поля должно быть больше 0

    public HouseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HouseBuilder year(long year) {
        this.year = year;
        return this;
    }

    public HouseBuilder numberOfFlatsOnFloor(long numberOfFlatsOnFloor) {
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        return this;
    }

    public HouseBuilder numberOfLifts(int numberOfLifts) {
        this.numberOfLifts = numberOfLifts;
        return this;
    }

    public HouseBuilder() {super();};

    public House build(){
        House h1 = null;
        if (validateHouse()) {
            h1 = new House(this);
        }
        else {
            System.out.println("Недостаточно параметров для объекта House!");
        }
        return h1;
    }

    private boolean validateHouse() {
        return (!name.isEmpty() && year > 0 && numberOfFlatsOnFloor > 0 && numberOfLifts > 0);
    }
}
