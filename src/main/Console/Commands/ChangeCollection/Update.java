package main.Console.Commands.ChangeCollection;

import main.BasicClasses.Flat;
import main.CollectionManager;
import main.Console.Commands.AddElement.Flat.CreateFlat;
import main.Console.Commands.Command;


public class Update implements Command {
    public static void execute(long id) {
        try {
            Flat obj = CollectionManager.find_by_id(id);
            Flat f1 = CreateFlat.execute();
            f1.setId(id);
            CollectionManager.update(obj, f1);
            System.out.println("Объект успешно обновлен!");
        }
        catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e1) {
            System.out.println("Нет элемента с заданным id!");
        }
    }
}
