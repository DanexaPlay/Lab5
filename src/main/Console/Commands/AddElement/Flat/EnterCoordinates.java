package main.Console.Commands.AddElement.Flat;

import main.BasicClasses.Coordinates;
import main.Console.Input;

public class EnterCoordinates {
    public static Coordinates enterCoordinates() throws IllegalArgumentException {
        Coordinates c1 = null;
        System.out.println("Введите координаты X и Y через пробел!");
        System.out.println("X - дробное число, вводите не больше 8 цифр после запятой, иначе будет погрешность!");
        System.out.println("Y - целое число от -2^64 до 2^64 - 1");
        try {
            String l1 = Input.getNextLine();
            if (l1.isEmpty()) {
                if (Input.getStatus()) {
                    throw new IllegalArgumentException();
                }
                else {
                    System.out.println("Строка не может быть пустой!");
                    c1 = enterCoordinates();
                    return c1;
                }
            }
            String[] str = l1.split(" ");
            if (str.length > 2) {
                System.out.println("Слишком много аргументов!");
                if (Input.getStatus()) {
                    throw new IllegalArgumentException();
                }
                else {
                    c1 = enterCoordinates();
                }
            }
            c1 = new Coordinates(Float.parseFloat(str[0].replace(",", ".")), Long.parseLong(str[1].replace(",", ".")));
            return c1;
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
            System.out.println("Неверно введены координаты!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                c1 = enterCoordinates();
            }
        }
        return c1;
    }
}
