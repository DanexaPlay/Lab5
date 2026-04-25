package main.FileManagment;

import com.thoughtworks.xstream.XStream;
import main.BasicClasses.Coordinates;
import main.BasicClasses.Flat;
import main.BasicClasses.House;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class WriteToFile {
    public static void write_to_file(Vector<Flat> c1) throws IOException {
        try {
            XStream XStream = new XStream();
            XStream.allowTypes(new Class[]{Flat.class, House.class, Coordinates.class});
            String x1 = XStream.toXML(c1);
            System.out.println(x1);
            FileWriter writer = new FileWriter("test.xml", true);
            writer.write(x1);
            writer.close();
        }
        catch (FileNotFoundException | NullPointerException e1) {
        System.out.println("Файл не найден!");
    }
    }
}
