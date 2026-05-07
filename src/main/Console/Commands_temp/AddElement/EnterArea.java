package main.Console.Commands_temp.AddElement;

import main.Console.Input;

public class EnterArea {
    public static double enterArea() throws IllegalArgumentException {
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
                area = enterArea();
            }
        }
        return area;
    }
}
