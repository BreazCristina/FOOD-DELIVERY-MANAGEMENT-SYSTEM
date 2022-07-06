package DataLayer;
import Business.Controller;
import Business.DeliveryService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        DeliveryService o1= new DeliveryService();
        o1=Serializator.deserialize();
        Controller c1= new Controller();
        // ArrayList<MenuItem> lista= o1.getListOfItems();

    }
}