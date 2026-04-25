package main.FileManagment;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.Mapper;
import main.BasicClasses.Coordinates;
import main.BasicClasses.Flat;
import main.BasicClasses.House;
import main.CollectionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ReadFile {
    public static void read_from_file() {

        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Flat.class, House.class, Coordinates.class});

        try {
            Scanner scanner = new Scanner(new File(System.getenv("FILE_PATH")));
            StringBuilder xml = new StringBuilder();

            while (scanner.hasNextLine()) {
                xml.append(scanner.nextLine());
            }

            scanner.close();
            CollectionManager.setCollection((Vector<Flat>) xStream.fromXML(xml.toString()));

        } catch (FileNotFoundException | NullPointerException e1) {
            System.out.println("Файл не найден!");
        }
    }
}
