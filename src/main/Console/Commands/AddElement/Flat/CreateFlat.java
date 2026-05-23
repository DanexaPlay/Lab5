package main.Console.Commands.AddElement.Flat;

import main.BasicClasses.*;
import main.Console.Input;
import java.util.NoSuchElementException;

import static main.Console.Commands.AddElement.House.CreateHouse.createHouse;
import static main.Console.Commands.AddElement.Flat.EnterArea.enterArea;
import static main.Console.Commands.AddElement.Flat.EnterCoordinates.enterCoordinates;
import static main.Console.Commands.AddElement.Flat.EnterFurnish.enterFurnish;
import static main.Console.Commands.AddElement.Flat.EnterIsNew.enterIsNew;
import static main.Console.Commands.AddElement.Flat.EnterName.enterName;
import static main.Console.Commands.AddElement.Flat.EnterNumberOfRooms.enterNumberOfRooms;
import static main.Console.Commands.AddElement.Flat.EnterTransport.enterTransport;

public class CreateFlat {
    private static FlatBuilder fb1 = new FlatBuilder();
    public static Flat createFlat() {
        try {
            String n1 = enterName();
            fb1.name(n1);
            Coordinates c1 = enterCoordinates();
            fb1.coordinates(c1);
            double a1 = enterArea();
            fb1.area(a1);
            int nr1 = enterNumberOfRooms();
            fb1.numberOfRooms(nr1);
            boolean i1 = enterIsNew();
            fb1.isNew(i1);
            Furnish f1 = enterFurnish();
            fb1.furnish(f1);
            enterTransport();
            House h1 = createHouse();
            fb1.house(h1);
            return fb1.build();
        } catch (IllegalArgumentException e1) {
            if (Input.getStatus()) {
                System.out.println("Неверный аргумент! Выполнение скрипта прервано!");
                Input.readFromConsole();
            } else {
                System.out.println("Неверный аргумент! Ввод начнется заново");
                fb1 = new FlatBuilder();
                createFlat();
            }
        } catch (NoSuchElementException e2) {
            System.out.println("Запрещённый символ!");
            System.exit(0);
        }
        return fb1.build();
    }
}
