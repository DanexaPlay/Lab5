package main.Console.Commands.AddElement.House;

import main.Console.Input;

public class EnterNumberOfLifts {
    public static int enterNumberOfLifts() throws IllegalArgumentException {
        int numberOfLifts = 0;
        System.out.println("Введите количество лифтов! Только целое число");
        try {
            numberOfLifts = Integer.parseInt(Input.getNextLine().replace(",", "."));
            return numberOfLifts;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                numberOfLifts = enterNumberOfLifts();
            }
        }
        return numberOfLifts;
    }
}

