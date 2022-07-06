package Business;

import Presentation.AdministratorView;
import Presentation.ClientView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */
public interface IDeliveryServiceProcessing {

    public void importProducts() throws IOException;
    public void  modifyProduct(ArrayList<MenuItem> m, AdministratorView a, ClientView c);
    void generateBill(String bill);
    public String rap1(Date d1, Date d2);
    public String rap2( int number);
    public String rap3(ArrayList<Users>  users, LinkedHashMap<Order, ArrayList<MenuItem>> orders, int number, int amount);
    public String rap4(Date date);
    public ArrayList<MenuItem> searchItems(String selected, String condition );
    public void deleteItem(int poz);

}