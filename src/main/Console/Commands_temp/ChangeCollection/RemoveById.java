package main.Console.Commands_temp.ChangeCollection;

import main.BasicClasses.Flat;
import main.CollectionManager;

public class RemoveById {
    public static void remove_by_id(int id) {
        try {
            Flat obj = CollectionManager.find_by_id(id);
            CollectionManager.remove_by_id(obj);
            System.out.println("Объект успешно удален!");
        }
        catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e2) {
            System.out.println("Нет элемента с заданным id!");
        }
    }
}
