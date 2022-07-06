package Business;

import DataLayer.Serializator;
import Presentation.AdministratorView;
import Presentation.ClientView;
import Presentation.EmployeeView;
import Presentation.LoggingView;

import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */

public class Controller {
    private LoggingView v1;
    private DeliveryService deliveryService;
    private AdministratorView administratorView;
    private ClientView clientView;
    private ArrayList<MenuItem> menuItems;
    private ArrayList<BaseProduct> selectedItems;
    private ArrayList<MenuItem> selectedItemsforOrder;
    int clientID;
    String bill="";
    private ArrayList<EmployeeView> employees;

    public Controller() {
        selectedItems = new ArrayList<>();
        selectedItemsforOrder = new ArrayList<>();
        menuItems = new ArrayList<>();
        deliveryService = new DeliveryService();
        v1 = new LoggingView();
        administratorView = new AdministratorView();
        clientView = new ClientView();
        employees = new ArrayList<>();

        employees = deliveryService.addEmployees();


        v1.frame.setVisible(true);
        v1.regListener(new RegListener());
        v1.logListener(new LogListener());

        administratorView.importListener(new ImportMenuListener());
        administratorView.addListener(new AddItemListener());
        administratorView.deleteListener(new DeleteListener());
        administratorView.modifyListener(new ModifyListener());
        administratorView.selectListener(new SelectListener());
        administratorView.createCompositeListener(new CompositeListener());
        administratorView.backListener(new BackListener());
        administratorView.raport1Listener(new Raport1Listener());
        administratorView.raport2Listener(new Raport2Listener());
        administratorView.raport3Listener(new Raport3Listener());
        administratorView.raport4Listener(new Raport4Listener());
        clientView.searchListener(new SearchListener());
        clientView.cancelListener(new CancelListener());
        clientView.selectListener(new SelectOrderListener());
        clientView.createOrderListener(new CreateOrderListener());
        clientView.exitListener(new ExitListener());
        clientView.BillListener(new BillListener());
        for (EmployeeView employeeView : employees) {
            employeeView.backEmployeeListener(new BackEmployeeListener());
        }


    }

    class RegListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String userInput = "";
            String userInput1 = "";
            userInput = v1.getUserInput();
            userInput1 = v1.getUserInput1();
            clientID = deliveryService.getListofUsers().size();
            // deliveryService.addUser(userInput1, userInput);
            //Users c1= new Client(userInput,userInput1);
            deliveryService.addUser(clientID, userInput, userInput1);
           // System.out.println();

            v1.confirm();
        }
    }

    class LogListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String userInput = "";
            String userInput1 = "";
            userInput = v1.getUserInput();
            userInput1 = v1.getUserInput1();


            Users u1 = new Users(v1.getUserInput1(), v1.getUserInput(),0);

            for (Users user : deliveryService.getListofUsers()) {


                if ((user.getUsername().equals(userInput)) && (user.getPassword().equals(userInput1))) {

                    if (user.getType() == Type.ADMINISTRATOR) {
                        v1.frame.setVisible(false);
                        administratorView.setVisible(true);
                    } else if ((user.getType() == Type.CLIENT)) {    //System.out.println(user);
                        v1.frame.setVisible(false);
                        clientView.setVisible(true);
                        clientView.setClientID(clientID);
                    } else if ((user.getType() == Type.EMPLOYEE)) {
                        System.out.println(user);
                        //EmployeeView empl = new EmployeeView(userInput);
                        for (EmployeeView index : employees) {
                            if (userInput.equals(index.getUsername())) index.setVisible(true);

                        }
                        // v1.frame.setVisible(false);
                        //empl.setVisible(true);

                    }
                }
            }


        }
    }

    class ImportMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                deliveryService.importProducts();
                menuItems = deliveryService.getListOfItems();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            administratorView.listOfItemsModel.removeAllElements();
            for (MenuItem m : menuItems) {
                // System.out.println(m);
                administratorView.listOfItemsModel.addElement(m);
                clientView.listOfItemsModel.addElement(m);
            }
            Serializator.serialize(deliveryService);
        }
    }

    class AddItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            String userInput = "";
            // String userInput1 = "";
            String userInput2 = "";
            String userInput3 = "";
            String userInput4 = "";
            String userInput5 = "";
            String userInput6 = "";
            userInput = administratorView.getUserInput();
            //System.out.println(administratorView.getUserInput());

            // userInput1 = administratorView.getUserInput_1();
            userInput2 = administratorView.getUserInput_2();
            userInput3 = administratorView.getUserInput_3();
            userInput4 = administratorView.getUserInput_4();
            userInput5 = administratorView.getUserInput_5();
            userInput6 = administratorView.getUserInput_6();




            BaseProduct b1 = new BaseProduct(userInput, 0, Integer.parseInt(userInput2), Integer.parseInt(userInput3), Integer.parseInt(userInput4), Integer.parseInt(userInput5), Integer.parseInt(userInput6),0);
            deliveryService.addItem(b1);
            menuItems = deliveryService.getListOfItems();
            administratorView.listOfItemsModel.addElement(b1);
            clientView.listOfItemsModel.addElement(b1);
            administratorView.succes(userInput);

            Serializator.serialize(deliveryService);
        }
    }

    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int poz = administratorView.listOfItems.getSelectedIndex();

            deliveryService.deleteItem(poz);

            //deliveryService.getListOfItems().remove(poz);

            administratorView.listOfItemsModel.removeAllElements();
            for (MenuItem m : menuItems) {

                administratorView.listOfItemsModel.addElement(m);
                clientView.listOfItemsModel.addElement(m);


            }
            administratorView.delete();

            Serializator.serialize(deliveryService);
        }
    }

    class ModifyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int poz = administratorView.listOfItems.getSelectedIndex();

            String userInput1 = "";
            String userInput2 = "";
            String userInput3 = "";
            String userInput4 = "";
            String userInput5 = "";
            String userInput6 = "";


            //userInput1 = administratorView.getUserInput_1();
            userInput2 = administratorView.getUserInput_2();
            userInput3 = administratorView.getUserInput_3();
            userInput4 = administratorView.getUserInput_4();
            userInput5 = administratorView.getUserInput_5();
            userInput6 = administratorView.getUserInput_6();
            ((BaseProduct) deliveryService.getListOfItems().get(poz)).setCalories(Integer.parseInt(userInput2));
            ((BaseProduct) deliveryService.getListOfItems().get(poz)).setProtein(Integer.parseInt(userInput3));
            ((BaseProduct) deliveryService.getListOfItems().get(poz)).setFat(Integer.parseInt(userInput4));
            ((BaseProduct) deliveryService.getListOfItems().get(poz)).setSodium(Integer.parseInt(userInput5));
            ((BaseProduct) deliveryService.getListOfItems().get(poz)).setPrice(Integer.parseInt(userInput6));
            deliveryService.modifyProduct(menuItems,administratorView,clientView);
            administratorView.update();
            Serializator.serialize(deliveryService);
        }
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BaseProduct item = (BaseProduct) deliveryService.getListOfItems().get(administratorView.listOfItems.getSelectedIndex());
            selectedItems.add(item);

        }
    }

    class CompositeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String userInput1 = "";
            userInput1 = administratorView.getUserInput_7();
            if (!selectedItems.isEmpty()) {
                CompositeProduct c1 = new CompositeProduct(userInput1, selectedItems,0);
                deliveryService.addItem(c1);
                selectedItems = new ArrayList<BaseProduct>();
                for (MenuItem m : menuItems) {

                    administratorView.listOfItemsModel.addElement(m);
                    clientView.listOfItemsModel.addElement(m);

                }
                administratorView.composite(userInput1);
            }

        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            v1.frame.setVisible(true);
            administratorView.setVisible(false);

        }
    }

    class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<MenuItem> searchResult = new ArrayList<>();
            String userInput1 = "";
            userInput1 = clientView.getUserInput();
            searchResult = deliveryService.searchItems((String) clientView.comboBox.getSelectedItem(), userInput1);
            clientView.listOfItemsModel.removeAllElements();
            for (MenuItem m : searchResult) {

                clientView.listOfItemsModel.addElement(m);

            }
        }
    }

    class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            try {
                deliveryService.importProducts();
            } catch (IOException exc) {
                exc.printStackTrace();
            }

            clientView.listOfItemsModel.removeAllElements();
            for (MenuItem m : menuItems) {

                clientView.listOfItemsModel.addElement(m);
            }
        }
    }

    class SelectOrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            MenuItem item = deliveryService.getListOfItems().get(clientView.listOfItems.getSelectedIndex());
            int currentNr= deliveryService.getListOfItems().get(clientView.listOfItems.getSelectedIndex()).getNumber();
            deliveryService.getListOfItems().get(clientView.listOfItems.getSelectedIndex()).setNumber(currentNr+1);
            selectedItemsforOrder.add(item);
            deliveryService.getOrderItems().add(item);
        }
    }


    class CreateOrderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String order = deliveryService.createOrder(clientID, selectedItemsforOrder);



           // for(Client c :deliveryService.getListofUsers())
            {
              //  System.out.println(c.getID());
            }//


            int size= deliveryService.getListofUsers().size();
            bill=order;


            // for (EmployeeView employeeV : employees) {
            //System.out.println(employeeV.getUsername());
            //  employeeV.textArea.setVisible(true);
            //  employeeV.notify(order);
            // }
            for(EmployeeView employeeView: employees) employeeView.update(deliveryService,order);
            order = "";

            selectedItemsforOrder = new ArrayList<>();

        }
    }

    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            v1.frame.setVisible(true);
            clientView.setVisible(false);
        }
    }

    class BackEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (EmployeeView employeeView : employees) {
                v1.frame.setVisible(true);
                employeeView.setVisible(false);
            }
        }
    }

    class Raport1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String data = "";

            int startHour = Integer.parseInt(administratorView.getUserInput_startHour());
            int endHour = Integer.parseInt(administratorView.getUserInput_endHour());


            Date start;
            start = new Date();

            Date end;
            end = new Date();

            start.setHours(startHour);
            System.out.println(start.getHours());
            start.setMinutes(0);
            start.setSeconds(0);

            end.setHours(endHour);
            System.out.println(end.getHours());
            end.setMinutes(0);
            end.setSeconds(0);

            data = deliveryService.rap1(start, end);
            //System.out.println(data);


            FileWriter output = null;
            try {
                output = new FileWriter("Raport1.txt", true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                output.write(data);
                output.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    class Raport2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String data = "";

            int number = Integer.parseInt(administratorView.getUserInput_number());


            ArrayList<MenuItem> rezultat= deliveryService.getOrderItems();

            data = deliveryService.rap2( number);
            System.out.println(data);

            FileWriter output = null;
            try {
                output = new FileWriter("Raport2.txt", true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                output.write(data);
                output.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    class Raport3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String data="";
            String userInput="";
            String userInput1="";
            userInput=administratorView.getUserInput_numberrap3();
            userInput1=administratorView.getUserInput_amount();



            for(Client c1: deliveryService.getListOfClients())
            {
                System.out.println(c1.getNrOrd());

            }

            data= deliveryService.rap3(deliveryService.getListofUsers(), deliveryService.getOrdersList(),Integer.parseInt(administratorView.getUserInput_numberrap3()) , Integer.parseInt(administratorView.getUserInput_amount()) );
            // System.out.println(data);



            FileWriter output = null;
            try {
                output = new FileWriter("Raport3.txt", true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                output.write("Clientii care au comandat de mai mult de " + Integer.parseInt(administratorView.getUserInput_numberrap3()) +" ori, de suma cel putin" +Integer.parseInt(administratorView.getUserInput_amount()) + " sunt \n"  );
                output.write(data);
                output.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    class Raport4Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput="";
            userInput=administratorView.getUserInput_rap4();

            String data="";
            String date = administratorView.getUserInput_rap4();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date start = new Date();
            start.setDate(Integer.parseInt(date));

            // System.out.println(start);

            data= deliveryService.rap4(start);

            System.out.println(data);


            //System.out.println(dateTime);
            FileWriter output = null;
            try {
                output = new FileWriter("Raport4.txt", true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {

                output.write(data);
                output.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }


    class BillListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            deliveryService.generateBill(bill);
        }
    }
}