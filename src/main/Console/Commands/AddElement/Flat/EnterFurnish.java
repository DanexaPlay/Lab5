package main.Console.Commands.AddElement.Flat;

import main.BasicClasses.Furnish;
import main.Console.Commands.Command;
import main.Console.Input;

public class EnterFurnish implements Command {
    public static Furnish execute() throws IllegalArgumentException {
        Furnish furnish;
        System.out.println("Введите дополнительные свойства квартиры: DESIGNER, BAD, LITTLE или пропустите строку!");
        String s = Input.getNextLine();
        if (s.isEmpty()) {
            furnish = null;
        }
        else {
            try {
                furnish = Furnish.valueOf(s.toUpperCase());
                return furnish;
            }
            catch (IllegalArgumentException e1) {
                System.out.println("Неверный ввод!");
                if (Input.getStatus()) {
                    throw new IllegalArgumentException();
                }
                else {
                    furnish = execute();
                }
            }
        }
        return furnish;
    }
}
