package main.Console.Commands.ChangeCollection;

import main.CollectionManager;
import main.Console.Commands.Command;

import java.util.NoSuchElementException;

public class RemoveLast implements Command {
    public static void execute() {
        try {
            CollectionManager.remove_last();
            System.out.println("Объект успешно удален!");
        }
        catch (NoSuchElementException e1) {
            System.out.println("Коллекция пуста!");
        }
    }
}
