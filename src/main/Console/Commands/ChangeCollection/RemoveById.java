package main.Console.Commands.ChangeCollection;

import main.BasicClasses.Flat;
import main.CollectionManager;
import main.Console.Commands.Command;

public class RemoveById implements Command {
    public static void execute(int id) {
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
