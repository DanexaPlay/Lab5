package main.Console.Commands_temp.ChangeCollection;

import main.CollectionManager;

import java.util.NoSuchElementException;

public class RemoveLast {
    public static void remove_last() {
        try {
            CollectionManager.remove_last();
            System.out.println("Объект успешно удален!");
        }
        catch (NoSuchElementException e1) {
            System.out.println("Коллекция пуста!");
        }
    }
}
