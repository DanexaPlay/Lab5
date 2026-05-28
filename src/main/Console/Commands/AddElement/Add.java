package main.Console.Commands.AddElement;

import main.BasicClasses.Flat;
import main.CollectionManager;
import main.Console.Commands.AddElement.Flat.CreateFlat;
import main.Console.Commands.Command;

public class Add implements Command {
    public static void execute() {
        Flat f1 = CreateFlat.execute();
        CollectionManager.add(f1);
        System.out.println("Объект успешно добавлен!");
    }
}
