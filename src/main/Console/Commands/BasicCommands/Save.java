package main.Console.Commands.BasicCommands;

import main.CollectionManager;

public class Save {
    public static void save() {
        CollectionManager.save();
        System.out.println("Коллекция успешно сохранена!");
    }
}
