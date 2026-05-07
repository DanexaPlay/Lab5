package main.Console.Commands_temp.AddElement;

import main.BasicClasses.House;
import main.Console.Input;

public class CreateHouse {
    public static House createHouse() throws IllegalArgumentException {
        System.out.println("Введите название дома!");
        House h1 = new House(Input.getNextLine());
        System.out.println("Введите год постройки дома! Только целое число");
        h1.setYear(Long.parseLong(Input.getNextLine()));
        System.out.println("Введите количество квартир на этаж дома! Только целое число");
        h1.setNumberOfFlatsOnFloor(Long.parseLong(Input.getNextLine()));
        System.out.println("Введите количество лифтов дома! Только целое число");
        h1.setNumberOfLifts(Integer.valueOf(Input.getNextLine()));
        return h1;
    }
}
