package main.Console.Commands.BasicCommands;

import main.BasicClasses.House;
import main.CollectionManager;
import main.Console.Commands.AddElement.House.CreateHouse;
import main.Console.Commands.Command;

public class CountGreaterThanHouse implements Command {
    public static void execute() {
        House h1 = CreateHouse.execute();
        System.out.println(CollectionManager.count_greater_than_house(h1));
    }
}
