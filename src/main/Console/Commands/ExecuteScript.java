package main.Console.Commands;

import main.Console.Input;

import java.io.IOException;
import java.util.HashSet;

public class ExecuteScript {
    private static HashSet<String> file_list = new HashSet<>();
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

    public static void clearFileList() {
        file_list.clear();
    }
}
