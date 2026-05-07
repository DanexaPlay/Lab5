package main.Console.Commands_temp.AddElement.House;

import main.Console.Input;

public class EnterYear {
    public static long enterYear() throws IllegalArgumentException {
        long year = 0;
        System.out.println("Введите количество лифтов! Только целое число");
        try {
            year = Long.parseLong(Input.getNextLine().replace(",", "."));
            return year;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                year = enterYear();
            }
        }
        return year;
    }
}
