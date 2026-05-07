package main.Console.Commands_temp.AddElement;

import main.Console.Input;

public class EnterName {
    public static String enterName() throws IllegalArgumentException {
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
                return name = enterName();
            }
        }
    }
}
