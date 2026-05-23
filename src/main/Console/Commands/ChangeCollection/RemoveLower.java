package main.Console.Commands.ChangeCollection;

import main.BasicClasses.Flat;
import main.CollectionManager;
import static main.Console.Commands.AddElement.Flat.CreateFlat.createFlat;

public class RemoveLower {
    public static void remove_lower() {
        Flat f1 = createFlat();
        CollectionManager.remove_lower(f1);
        System.out.println("Элементы коллекции успешно удалены!");
    }
}
