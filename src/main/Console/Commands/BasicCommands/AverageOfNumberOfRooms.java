package main.Console.Commands.BasicCommands;

import main.CollectionManager;
import main.Console.Commands.Command;

public class AverageOfNumberOfRooms implements Command {
    public static void execute() {
        System.out.println(CollectionManager.average_of_number_of_rooms());
    }
}
