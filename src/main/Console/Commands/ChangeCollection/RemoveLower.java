package main.Console.Commands.ChangeCollection;

import main.BasicClasses.Flat;
import main.CollectionManager;
import main.Console.Commands.AddElement.Flat.CreateFlat;
import main.Console.Commands.Command;

public class RemoveLower implements Command {
    public static void execute() {
        Flat f1 = CreateFlat.execute();
        CollectionManager.remove_lower(f1);
        System.out.println("Элементы коллекции успешно удалены!");
    }
}
