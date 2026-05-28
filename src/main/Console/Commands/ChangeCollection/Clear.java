package main.Console.Commands.ChangeCollection;

import main.CollectionManager;
import main.Console.Commands.Command;

public class Clear implements Command {
    public static void execute() {
        CollectionManager.clear();
        System.out.println("Коллекция успешно очищена!");
    }
}
