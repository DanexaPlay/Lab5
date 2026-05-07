package main.Console.Commands_temp.ChangeCollection;

import main.CollectionManager;

public class Clear {
    public static void clear() {
        CollectionManager.clear();
        System.out.println("Коллекция успешно очищена!");
    }
}
