package main.Console.Commands.AddElement.Flat;

import main.BasicClasses.*;
import main.Console.Commands.AddElement.House.CreateHouse;
import main.Console.Commands.Command;
import main.Console.Input;
import java.util.NoSuchElementException;

public class CreateFlat implements Command {
    private static FlatBuilder fb1 = new FlatBuilder();
    public static Flat execute() {
        try {
            String n1 = EnterName.execute();
            fb1.name(n1);
            Coordinates c1 = EnterCoordinates.execute();
            fb1.coordinates(c1);
            double a1 = EnterArea.execute();
            fb1.area(a1);
            int nr1 = EnterNumberOfRooms.execute();
            fb1.numberOfRooms(nr1);
            boolean i1 = EnterIsNew.execute();
            fb1.isNew(i1);
            Furnish f1 = EnterFurnish.execute();
            fb1.furnish(f1);
            Transport t1 = EnterTransport.execute();
            fb1.transport(t1);
            House h1 = CreateHouse.execute();
            fb1.house(h1);
            return fb1.build();
        } catch (IllegalArgumentException e1) {
            if (Input.getStatus()) {
                System.out.println("Неверный аргумент! Выполнение скрипта прервано!");
                Input.readFromConsole();
            } else {
                System.out.println("Неверный аргумент! Ввод начнется заново");
                fb1 = new FlatBuilder();
                execute();
            }
        } catch (NoSuchElementException e2) {
            System.out.println("Запрещённый символ!");
            System.exit(0);
        }
        return fb1.build();
    }
}
