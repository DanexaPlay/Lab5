package main.Console;

import main.Console.Commands.AddElement.Add;
import main.Console.Commands.BasicCommands.*;
import main.Console.Commands.ChangeCollection.*;
import main.Console.Commands.ExecuteScript;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Input {
    private static Stack<Scanner> scannerStack = new Stack<>();
    private static Scanner input = new Scanner(System.in);
    private static boolean flag;
    private static String text;
    private static String[] str;

    static {
        continueReading();
    }

    public static void scan() {
        if (flag) {
            System.out.println(text);
        }
        while (true) {
            switch (text) {
                case "help":
                    Help.execute();
                    continueReading();
                    break;
                case "info":
                    Info.execute();
                    continueReading();
                    break;
                case "show":
                    Show.execute();
                    continueReading();
                    break;
                case "add":
                    Add.execute();
                    continueReading();
                    break;
                case "clear":
                    Clear.execute();
                    continueReading();
                    break;
                case "exit":
                    System.exit(0);
                case "remove_last":
                    RemoveLast.execute();
                    continueReading();
                    break;
                case "reorder":
                    Reorder.execute();
                    continueReading();
                    break;
                case "average_of_number_of_rooms":
                    AverageOfNumberOfRooms.execute();
                    continueReading();
                    break;
                case "save":
                    Save.execute();
                    continueReading();
                    break;
                case "remove_lower":
                    RemoveLower.execute();
                    continueReading();
                    break;
                case "count_greater_than_house":
                    CountGreaterThanHouse.execute();
                    continueReading();
                    break;
                default:
                    if (text.matches("^remove_by_id [-]?[0123456789]+$")) {
                        RemoveById.execute(Integer.valueOf(str[1]));
                        continueReading();
                        break;
                    } else if (text.matches("^update [-]?[0123456789]+$")) {
                        Update.execute(Integer.parseInt(str[1]));
                        continueReading();
                        break;
                    } else if (str[0].matches("filter_by_new") && str.length == 2) {
                        if ((str[1].matches("true")) || str[1].matches("false")) {
                            FilterByNew.execute(Boolean.valueOf(str[1]));
                        }
                        else {
                            System.out.println("Неверный аргумент!");
                        }
                        continueReading();
                        break;
                    } else if ((str != null) && (str.length > 0) && str[0].equals("execute_script")) {
                        try {
                            System.out.println(str[1]);
                            ExecuteScript.execute(str[1]);
                        } catch (IndexOutOfBoundsException e1) {
                            System.out.println("Не задано название файла!");
                        } catch (IOException e2) {
                            System.out.println("Файл не найден!");
                        }
                        continueReading();
                        break;
                    } else {
                        System.out.println("Команда не существует или не заданы аргументы");
                            continueReading();
                            break;
                    }
            }
        }
    }

    public static void readFromFile(String filename) throws IOException {
        input = new Scanner(new File(filename));
        System.out.println("Сканирование файла");
        flag = true;
        continueReading();
        scan();
        popScanner();
    }

    public static void readFromConsole() {
        input = new Scanner(System.in);
        flag = false;
        continueReading();
        scan();
    }

    public static void continueReading() {
        try {
            if (!flag) {
                System.out.println("Пожалуйста, введите команду ");
            }
            text = input.nextLine();
            text = text.trim();
            text = text.replaceAll("[\\s]{2,}", " ");
            if (flag) {
                System.out.println(text);
            }
            str = text.split(" ");
        } catch (NoSuchElementException e1) {
            if (!flag) {
                System.out.println("Запрещенный символ!");
                System.exit(0);
            }
            else {
                if (scannerStack.size() > 1) {
                    popScanner();
                }
                else {
                    scannerStack.clear();
                    ExecuteScript.clearFileList();
                    readFromConsole();
                }
            }
        }
    }

    public static boolean getStatus() {
        return flag;
    }

    public static String getNextLine() {
        return input.nextLine().trim().replaceAll("[\\s]{2,}", " ");
    }

    public static void pushCurrentScanner() {
        scannerStack.push(input);
    }

    public static void popScanner() {
        input = scannerStack.pop();
    }
}