package main.Console.Commands.AddElement.Flat;

import main.Console.Commands.Command;
import main.Console.Input;

public class EnterName implements Command {
    public static String execute() throws IllegalArgumentException {
        String name = "";
        System.out.println("Введите название!");
        String s1 = Input.getNextLine();
        if (!s1.isEmpty()) {
            name = s1;
            return name;
        }
        else {
            System.out.println("Строка не может быть пустой!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                return name = execute();
            }
        }
    }
}
