package main;

import main.Console.Input;
import main.FileManagment.ReadFile;

public class Main {
    public static void main(String[] args) {
        CollectionManager c1 = new CollectionManager();
        ReadFile.read_from_file();
        Input.scan();
    }
}