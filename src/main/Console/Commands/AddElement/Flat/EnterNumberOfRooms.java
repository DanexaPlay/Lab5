package main.Console.Commands.AddElement.Flat;

import main.Console.Commands.Command;
import main.Console.Input;

public class EnterNumberOfRooms implements Command {
    public static int execute() throws IllegalArgumentException {
        int number_of_rooms = 0;
        try {
            System.out.println("Введите количество комнат! Только целое число");
            number_of_rooms = Integer.parseInt(Input.getNextLine());
            return number_of_rooms;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                number_of_rooms = execute();
            }
        }
        return number_of_rooms;
    }
}
