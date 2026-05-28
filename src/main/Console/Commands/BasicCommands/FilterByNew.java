package main.Console.Commands.BasicCommands;

import main.CollectionManager;
import main.Console.Commands.Command;

public class FilterByNew implements Command {
    public static void execute(Boolean isNew) {
        CollectionManager.filter_by_new(isNew);
    }
}
