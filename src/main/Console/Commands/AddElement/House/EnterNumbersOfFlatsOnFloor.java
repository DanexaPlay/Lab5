package main.Console.Commands.AddElement.House;

import main.Console.Commands.Command;
import main.Console.Input;

public class EnterNumbersOfFlatsOnFloor implements Command {
    public static long execute() throws IllegalArgumentException {
        long numberOfFlats = 0;
        System.out.println("Введите количество квартир на этаж! Только целое число");
        try {
            numberOfFlats = Long.parseLong(Input.getNextLine().replace(",", "."));
            return numberOfFlats;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                numberOfFlats = execute();
            }
        }
        return numberOfFlats;
    }
}

