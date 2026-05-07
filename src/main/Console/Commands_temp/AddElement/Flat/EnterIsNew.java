package main.Console.Commands_temp.AddElement.Flat;

import main.Console.Input;

public class EnterIsNew {
    public static boolean enterIsNew() {
        System.out.println("Введите true если квартира новая, иначе false, или пропустите строку!");
        boolean isnew;
        try {
            String s1 = Input.getNextLine();
            s1 = s1.toLowerCase();
            isnew = Boolean.parseBoolean(s1);
            System.out.println("Будет записано значение: " + isnew);
            return isnew;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                isnew = enterIsNew();
            }
        }
        return isnew;
    }
}
