package main;

import main.BasicClasses.Flat;
import main.BasicClasses.House;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;
import static main.FileManagment.WriteToFile.write_to_file;

public class CollectionManager {
    private static java.time.LocalDate creationDate;
    private static Vector<Flat> collection = new Vector<>();

    public static void info() {
        System.out.print(collection.getClass() + " ");
        System.out.print(collection.size() + " ");
        System.out.println(creationDate);
    }

    public static void show() {
        Iterator<Flat> iter = collection.iterator();
        System.out.println();
        while (iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }

    public static void add(Flat f1) {
        collection.add(f1);
    }

    public static void update(Flat obj, Flat f1) throws ArrayIndexOutOfBoundsException {
        collection.set(collection.indexOf(obj), f1);
    }

    public static void remove_by_id(Flat obj) throws ArrayIndexOutOfBoundsException {collection.remove(obj);}

    public static void clear() {
        collection.clear();
    }

    public static void remove_last() throws NoSuchElementException {
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Коллекция пуста!");
        }
        else {
            collection.remove(collection.lastElement());
        }
    }

    public static void remove_lower(Flat f1) {
        Iterator<Flat> iter = collection.iterator();
        while (iter.hasNext()) {
            Flat i = iter.next();
            if (i.compareTo(f1) < 0) {
                collection.remove(i);

            }
        }
    }

    public static Flat find_by_id(long id) throws IllegalArgumentException {
        Iterator<Flat> iter = collection.iterator();
        Flat obj = null;
        boolean flag = false;
        while (iter.hasNext()) {
            Flat i = iter.next();
            if (i.getId() == id) {
                flag = true;
                obj = i;
                break;
            }
        }
        if (!flag) {throw new IllegalArgumentException();}
        return obj;
    }

    public static int count_greater_than_house(House h1) {
        Iterator<Flat> iter = collection.iterator();
        int count = 0;
        while (iter.hasNext()) {
            Flat i = iter.next();
            House j = i.getHouse();
            if (j.compareTo(h1) > 0) {
                count += 1;
            }
        }
        return count;
    }

    public static String average_of_number_of_rooms() {
        if (collection.isEmpty()) {
            return "Коллекция пуста!";
        }
        Iterator<Flat> iter = collection.iterator();
        int rooms_counter = 0;
        int length = 0;
        while (iter.hasNext()) {
            rooms_counter += iter.next().getNumberOfRooms();
            length += 1;
        }
        return "Среднее количество комнат:" + (float) rooms_counter / length;
    }

    public static void filter_by_new(Boolean isNew) {
        Iterator<Flat> iter = collection.iterator();
        boolean flag = false;
        while (iter.hasNext()) {
            Flat i = iter.next();
            if (i.getIsNew() == isNew) {
                flag = true;
                System.out.print(i.toString() + " ");
                System.out.println();
            }
            if (!flag) {
                System.out.println("Элементы не найдены!");
            }
        }
    }

    public static void reorder() {
        Collections.reverse(collection);
    }

    public static void save() {
        try {
            write_to_file(collection);
        } catch (IOException e) {
            System.out.println("Файл не найден!");
        }
    }

    public static void setCollection(Vector<Flat> f1) {
        collection = f1;
    }

    public CollectionManager() {
        creationDate = LocalDate.now();
    }
}
