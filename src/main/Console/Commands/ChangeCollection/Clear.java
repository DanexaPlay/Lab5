package main.Console.Commands.ChangeCollection;

import main.CollectionManager;

public class Clear {
    public static void clear() {
        CollectionManager.clear();
        System.out.println("Коллекция успешно очищена!");
    }
}
