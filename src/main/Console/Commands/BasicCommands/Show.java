package main.Console.Commands.BasicCommands;

import main.CollectionManager;
import main.Console.Commands.Command;

public class Show implements Command {
    public static void execute() {
        CollectionManager.show();
    }
}
