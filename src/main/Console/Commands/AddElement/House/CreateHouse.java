package main.Console.Commands.AddElement.House;

import main.BasicClasses.House;
import main.BasicClasses.HouseBuilder;
import main.Console.Commands.Command;
import main.Console.Input;

import java.util.NoSuchElementException;

public class CreateHouse implements Command {
    public static HouseBuilder hb1 = new HouseBuilder();

    public static House execute() throws IllegalArgumentException {
        try {
            String n1 = EnterName.execute();
            hb1.name(n1);
            long y1 = EnterYear.execute();
            hb1.year(y1);
            int nl1 = EnterNumberOfLifts.execute();
            hb1.numberOfLifts(nl1);
            long nf1 = EnterNumbersOfFlatsOnFloor.execute();
            hb1.numberOfFlatsOnFloor(nf1);
        } catch (IllegalArgumentException e1) {
            if (Input.getStatus()) {
                System.out.println("Неверный аргумент! Выполнение скрипта прервано!");
                Input.readFromConsole();
            } else {
                System.out.println("Неверный аргумент! Ввод начнется заново");
                hb1 = new HouseBuilder();
                execute();
            }
        } catch (
                NoSuchElementException e2) {
            System.out.println("Запрещённый символ!");
            System.exit(0);
        }
        return hb1.build();
    }
}
