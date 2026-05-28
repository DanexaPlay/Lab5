package main.Console.Commands.BasicCommands;

import main.Console.Commands.Command;

public class Help implements Command {
    public static void execute() {
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
}
