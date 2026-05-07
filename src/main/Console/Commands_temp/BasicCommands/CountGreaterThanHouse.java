package main.Console.Commands_temp.BasicCommands;

import main.BasicClasses.House;
import main.CollectionManager;
import static main.Console.Commands_temp.AddElement.CreateHouse.createHouse;

public class CountGreaterThanHouse {
    public static void count_greater_than_house() {
        House h1 = createHouse();
        System.out.println(CollectionManager.count_greater_than_house(h1));
    }
}
