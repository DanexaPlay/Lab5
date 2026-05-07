package main.Console.Commands_temp.AddElement;

import main.BasicClasses.Flat;
import main.CollectionManager;

import static main.Console.Commands_temp.AddElement.CreateFlat.createFlat;

public class Add {
    public static void add() {
        Flat f1 = createFlat();
        CollectionManager.add(f1);
        System.out.println("Объект успешно добавлен!");
    }
}
