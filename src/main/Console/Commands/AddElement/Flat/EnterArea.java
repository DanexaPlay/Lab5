package main.Console.Commands.AddElement.Flat;

import main.Console.Commands.Command;
import main.Console.Input;

public class EnterArea implements Command {
    public static double execute() throws IllegalArgumentException {
        double area = 0;
        System.out.println("Введите площадь! Дробное число, не больше 16 знаков после запятой");
        try {
            area = Double.parseDouble(Input.getNextLine().replace(",", "."));
            return area;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                area = execute();
            }
        }
        return area;
    }
}
