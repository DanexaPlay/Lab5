package main.Console.Commands.ChangeCollection;

import main.CollectionManager;

public class Reorder {
    public static void reorder() {
        CollectionManager.reorder();
        System.out.println("Коллекция успешно отсортирована!");
    }
}
