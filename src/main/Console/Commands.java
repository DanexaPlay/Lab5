package main.Console;

import main.BasicClasses.*;
import main.CollectionManager;
import java.io.IOException;
import java.util.*;

public class Commands {
    private static HashSet<String> file_list = new HashSet<>();
    private static FlatBuilder fb1 = new FlatBuilder();

    public static void help() {
        System.out.println("Список доступных команд:");
        System.out.println("help - вывод всех имеющихся команд");
        System.out.println("info - вывод информации о коллекции");
        System.out.println("show - вывод всех элементов коллекции");
        System.out.println("add {element} - добавить новый элемент в коллекцию");
        System.out.println("update id {element} - обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id - удалить элемент из коллекции по его id");
        System.out.println("clear - очистить коллекцию");
        System.out.println("save - сохранить коллекцию в файл");
        System.out.println("execute_script file_name - считать и исполнить скрипт из указанного файла");
        System.out.println("exit - завершить программу (без сохранения в файл)");
        System.out.println("remove_last - удалить последний элемент из коллекции");
        System.out.println("remove_lower {element} - удалить из коллекции все элементы, меньшие, чем заданный");
        System.out.println("reorder - отсортировать коллекцию в порядке, обратном нынешнему");
        System.out.println("average_of_number_of_rooms - вывести среднее значение поля numberOfRooms для всех элементов коллекции");
        System.out.println("count_greater_than_house house - вывести количество элементов, значение поля house которых больше заданного");
        System.out.println("filter_by_new new - вывести элементы, значение поля new которых равно заданному");
    }

    public static void info() {
        CollectionManager.info();
    }

    public static void show() {
        CollectionManager.show();
    }

    public static void add() {
        Flat f1 = createFlat();
        CollectionManager.add(f1);
        System.out.println("Объект успешно добавлен!");
    }

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

    public static void remove_by_id(int id) {
        try {
            Flat obj = CollectionManager.find_by_id(id);
            CollectionManager.remove_by_id(obj);
            System.out.println("Объект успешно удален!");
        }
        catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e2) {
            System.out.println("Нет элемента с заданным id!");
        }
    }

    public static void clear() {
        CollectionManager.clear();
        System.out.println("Коллекция успешно очищена!");
    }

    public static void save() {
        CollectionManager.save();
        System.out.println("Коллекция успешно сохранена!");
    }

    public static void remove_last() {
        try {
            CollectionManager.remove_last();
            System.out.println("Объект успешно удален!");
        }
        catch (NoSuchElementException e1) {
            System.out.println("Коллекция пуста!");
        }
    }

    public static void remove_lower() {
        Flat f1 = createFlat();
        CollectionManager.remove_lower(f1);
        System.out.println("Элементы коллекции успешно удалены!");
    }

    public static void reorder() {
        CollectionManager.reorder();
        System.out.println("Коллекция успешно отсортирована!");
    }

    public static void average_of_number_of_rooms() {
        System.out.println(CollectionManager.average_of_number_of_rooms());
    }

    public static void count_greater_than_house() {
        House h1 = createHouse();
        System.out.println(CollectionManager.count_greater_than_house(h1));
    }

    public static void filter_by_new(Boolean isNew) {
        CollectionManager.filter_by_new(isNew);
    }

    public static void execute_script(String filename) throws IOException {
        Input.pushCurrentScanner();
        if (file_list.add(filename)) {
            System.out.println("Скрипты выполняются");
            Input.readFromFile(filename);
            System.out.println("Скрипт успешно выполнен!");
            file_list.remove(filename);
        } else {
            System.out.println("Рекурсивный запуск скриптов запрещен!");
            Input.popScanner();
        }
    }

    public static Coordinates enterCoordinates() throws IllegalArgumentException {
        Coordinates c1 = null;
        System.out.println("Введите координаты X и Y через пробел!");
        System.out.println("X - дробное число, вводите не больше 8 цифр после запятой, иначе будет погрешность!");
        System.out.println("Y - целое число от -2^64 до 2^64 - 1");
        try {
            String l1 = Input.getNextLine();
            if (l1.isEmpty()) {
                if (Input.getStatus()) {
                    throw new IllegalArgumentException();
                }
                else {
                    System.out.println("Строка не может быть пустой!");
                    c1 = enterCoordinates();
                    return c1;
                }
            }
            String[] str = l1.split(" ");
            if (str.length > 2) {
                System.out.println("Слишком много аргументов!");
                if (Input.getStatus()) {
                    throw new IllegalArgumentException();
                }
                else {
                    c1 = enterCoordinates();
                }
            }
            c1 = new Coordinates(Float.parseFloat(str[0].replace(",", ".")), Long.parseLong(str[1].replace(",", ".")));
            return c1;
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
            System.out.println("Неверно введены координаты!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                c1 = enterCoordinates();
            }
        }
        return c1;
    }

    public static boolean enterIsNew() {
        System.out.println("Введите true если квартира новая, иначе false, или пропустите строку!");
        boolean isnew;
        try {
            String s1 = Input.getNextLine();
            s1 = s1.toLowerCase();
            isnew = Boolean.parseBoolean(s1);
            System.out.println("Будет записано значение: " + isnew);
            return isnew;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                isnew = enterIsNew();
            }
        }
        return isnew;
    }

    public static House createHouse() throws IllegalArgumentException {
        System.out.println("Введите название дома!");
        House h1 = new House(Input.getNextLine());
        System.out.println("Введите год постройки дома! Только целое число");
        h1.setYear(Long.parseLong(Input.getNextLine()));
        System.out.println("Введите количество квартир на этаж дома! Только целое число");
        h1.setNumberOfFlatsOnFloor(Long.parseLong(Input.getNextLine()));
        System.out.println("Введите количество лифтов дома! Только целое число");
        h1.setNumberOfLifts(Integer.valueOf(Input.getNextLine()));
        return h1;
    }

    public static String enterName() throws IllegalArgumentException {
        String name = "";
        System.out.println("Введите название!");
        String s1 = Input.getNextLine();
        if (!s1.isEmpty()) {
            name = s1;
            return name;
        }
        else {
            System.out.println("Строка не может быть пустой!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                return name = enterName();
            }
        }
    }

    public static double enterArea() throws IllegalArgumentException {
        double area = 0;
        System.out.println("Введите площадь! Дробное число, не больше 16 знаков после запятой");
        try {
            area = Double.parseDouble(Input.getNextLine().replace(",", "."));
            return area;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                area = enterArea();
            }
        }
        return area;
    }

    public static int enterNumberOfRooms() throws IllegalArgumentException {
        int number_of_rooms = 0;
        try {
            System.out.println("Введите количество комнат! Только целое число");
            number_of_rooms = Integer.parseInt(Input.getNextLine());
            return number_of_rooms;
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Неправильный ввод!");
            if (Input.getStatus()) {
                throw new IllegalArgumentException();
            }
            else {
                number_of_rooms = enterNumberOfRooms();
            }
        }
        return number_of_rooms;
    }

    public static Furnish enterFurnish() throws IllegalArgumentException {
        Furnish furnish;
        System.out.println("Введите дополнительные свойства квартиры: DESIGNER, BAD, LITTLE или пропустите строку!");
        String s = Input.getNextLine();
        if (s.isEmpty()) {
            furnish = null;
        }
        else {
            try {
                furnish = Furnish.valueOf(s.toUpperCase());
                return furnish;
            }
            catch (IllegalArgumentException e1) {
                System.out.println("Неверный ввод!");
                if (Input.getStatus()) {
                    throw new IllegalArgumentException();
                }
                else {
                    furnish = enterFurnish();
                }
            }
        }
        return furnish;
    }

    public static Transport enterTransport() throws IllegalArgumentException {
        Transport transport;
        System.out.println("Введите транспорт квартиры: NONE, NORMAL, ENOUGH или пропустите строку!");
        String s = Input.getNextLine();
        if (s.isEmpty()) {
            transport = null;
        }
        else {
            try {
                transport = Transport.valueOf(s.toUpperCase());
                return transport;
            }
            catch (IllegalArgumentException e1) {
                System.out.println("Неверный ввод!");
                if (Input.getStatus()) {
                    throw new IllegalArgumentException();
                }
                else {
                    transport = enterTransport();
                }
            }
        }
        return transport;
    }

    public static Flat createFlat() {
        try {
            String n1 = enterName();
            fb1.name(n1);
            Coordinates c1 = enterCoordinates();
            fb1.coordinates(c1);
            double a1 = enterArea();
            fb1.area(a1);
            int nr1 = enterNumberOfRooms();
            fb1.numberOfRooms(nr1);
            boolean i1 = enterIsNew();
            fb1.isNew(i1);
            Furnish f1 = enterFurnish();
            fb1.furnish(f1);
            enterTransport();
            House h1 = createHouse();
            fb1.house(h1);
            return fb1.build();
        } catch (IllegalArgumentException e1) {
            if (Input.getStatus()) {
                System.out.println("Неверный аргумент! Выполнение скрипта прервано!");
                Input.readFromConsole();
            } else {
                System.out.println("Неверный аргумент! Ввод начнется заново");
                fb1 = new FlatBuilder();
                createFlat();
            }
        } catch (NoSuchElementException e2) {
            System.out.println("Запрещённый символ!");
            System.exit(0);
        }
        return fb1.build();
    }

    public static void clearFileList() {
        file_list.clear();
    }
}