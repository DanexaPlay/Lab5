package main.Console.Commands.AddElement.House;

import main.BasicClasses.House;
import main.BasicClasses.HouseBuilder;
import main.Console.Input;

import java.util.NoSuchElementException;

import static main.Console.Commands.AddElement.House.EnterName.enterName;
import static main.Console.Commands.AddElement.House.EnterNumberOfLifts.enterNumberOfLifts;
import static main.Console.Commands.AddElement.House.EnterNumbersOfFlatsOnFloor.enterNumberOfFlatsOnFloor;
import static main.Console.Commands.AddElement.House.EnterYear.enterYear;

public class CreateHouse {
    public static HouseBuilder hb1 = new HouseBuilder();

    public static House createHouse() throws IllegalArgumentException {
        try {
            String n1 = enterName();
            hb1.name(n1);
            long y1 = enterYear();
            hb1.year(y1);
            int nl1 = enterNumberOfLifts();
            hb1.numberOfLifts(nl1);
            long nf1 = enterNumberOfFlatsOnFloor();
            hb1.numberOfFlatsOnFloor(nf1);
        } catch (IllegalArgumentException e1) {
            if (Input.getStatus()) {
                System.out.println("Неверный аргумент! Выполнение скрипта прервано!");
                Input.readFromConsole();
            } else {
                System.out.println("Неверный аргумент! Ввод начнется заново");
                hb1 = new HouseBuilder();
                createHouse();
            }
        } catch (
                NoSuchElementException e2) {
            System.out.println("Запрещённый символ!");
            System.exit(0);
        }
        return hb1.build();
    }
}
