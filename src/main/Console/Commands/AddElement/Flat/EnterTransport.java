package main.Console.Commands.AddElement.Flat;

import main.BasicClasses.Transport;
import main.Console.Input;

public class EnterTransport {
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
}
