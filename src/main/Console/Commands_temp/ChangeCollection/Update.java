package main.Console.Commands_temp.ChangeCollection;

import main.BasicClasses.Flat;
import main.CollectionManager;

import static main.Console.Commands_temp.AddElement.CreateFlat.createFlat;

public class Update {
    public static void update(long id) {
        try {
            Flat obj = CollectionManager.find_by_id(id);
            Flat f1 = createFlat();
            f1.setId(id);
            CollectionManager.update(obj, f1);
            System.out.println("Объект успешно обновлен!");
        }
        catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e1) {
            System.out.println("Нет элемента с заданным id!");
        }
    }
}
