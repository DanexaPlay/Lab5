package main.Console.Commands.AddElement.House;

import main.Console.Commands.Command;
import main.Console.Input;

public class EnterYear implements Command {
    public static long execute() throws IllegalArgumentException {
        long year = 0;
        System.out.println("Введите год! Только целое число");
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
                year = execute();
            }
        }
        return year;
    }
}
