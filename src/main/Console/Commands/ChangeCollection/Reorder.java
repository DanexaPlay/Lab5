package main.Console.Commands.ChangeCollection;

import main.CollectionManager;
import main.Console.Commands.Command;

public class Reorder implements Command {
    public static void execute() {
        CollectionManager.reorder();
        System.out.println("Коллекция успешно отсортирована!");
    }
}
