package main.Console.Commands.BasicCommands;

import main.CollectionManager;
import main.Console.Commands.Command;

public class Info implements Command {
    public static void execute() {
        CollectionManager.info();
    }
}
