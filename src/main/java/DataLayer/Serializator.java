package DataLayer;

import Business.DeliveryService;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;
/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */
public class Serializator {


    public static void serialize(DeliveryService deliveryService) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("DeliveryService.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(deliveryService);
            outputStream.close();
            fileOutputStream.close();

        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error at serialize");
        }
    }

    public static DeliveryService deserialize() {
        DeliveryService deliveryService;
        try {
            FileInputStream fileInputStream = new FileInputStream("DeliveryService.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deliveryService = (DeliveryService) objectInputStream.readObject();
            //System.out.println(deliveryService.findOrderByID(1));
            objectInputStream.close();
            fileInputStream.close();
            return deliveryService;
        } catch (IOException | ClassNotFoundException e) {
            deliveryService = new DeliveryService();
            return deliveryService;

        }
    }
}