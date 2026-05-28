package main.Console.Commands.BasicCommands;

import main.CollectionManager;
import main.Console.Commands.Command;

public class Save implements Command {
    public static void execute() {
        CollectionManager.save();
        System.out.println("Коллекция успешно сохранена!");
    }
}
