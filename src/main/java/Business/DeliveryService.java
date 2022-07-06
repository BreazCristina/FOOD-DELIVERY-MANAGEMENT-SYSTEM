package Business;

import Presentation.AdministratorView;
import Presentation.ClientView;
import Presentation.EmployeeView;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static Business.BaseProduct.distinctByKey;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */
public class DeliveryService extends Observable implements IDeliveryServiceProcessing , Serializable {

    private ArrayList<MenuItem> listOfItems; //save the menu items;
    private ArrayList<Users> listofUsers;   //save the users;
    private LinkedHashMap<Order, ArrayList<MenuItem>> ordersList;
    private Date currentDate;
    private ArrayList<MenuItem> orderItems;
    private ArrayList<Client> listOfClients;
    public DeliveryService() {

        this.listOfItems = new ArrayList<>();
        this.listofUsers= new ArrayList<>();
        this.ordersList= new LinkedHashMap<>();
        currentDate= new Date();
        orderItems= new ArrayList<>();
        listOfClients= new ArrayList<>();
        String username="administrator";
        String password="123";
        String username1="employee1";
        String username2="employee2";
        String password1="a";
        String password2="b";

        Users admin= new Administrator(password, username,0);
        Users employee1= new Employee(password1, username1,0);
        Users employee2= new Employee(password2, username2,0);
        listofUsers.add(admin);
        listofUsers.add(employee1);
        listofUsers.add(employee2);
        assert isWellFormed();
    }

    /**
     * @return: boolean
     * @param:
     * Aceasta metoda verifica daca lista este bine formata
     */

    public boolean isWellFormed(){
        assert !listOfItems.contains(null);
        return !listOfItems.contains(null);
    }


    /**
     * @return: void
     * @param: ClientID, username, password
     * Aceasta metoda adauga un User
     */

    public void addUser(int ClientID,String username, String password)
    {
        assert  ClientID !=0;
        assert username!=null;
        assert password!=null;
        Client o1= new Client(password,username,ClientID,0);

        listofUsers.add(o1);
        listOfClients.add(o1);
    }

    /**
     * @return: int
     * @param: obj
     * Aceasta metoda verifica daca un obiect exista deja in lista
     */

    public int exist(MenuItem obj)
    {
        for(MenuItem m1: listOfItems)
        {
            if(obj.equals(m1)) return 1;
        }
        return 0;
    }

    /**
     * @return: ArrayList<Users>
     * @param:
     * Aceasta metoda returneaza lista de utilizatori
     */
    public ArrayList<Users> getListofUsers() {
        return listofUsers;
    }

    /**
     * @return: void
     * @param:
     * Aceasta metoda importa produsele din csv
     */
    @Override
    public void importProducts() throws IOException {

        String file = "C:\\CTI\\PT2022_302210_Breaz_Cristina_Assignment_4\\src\\main\\resources\\products.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                float rating= Float.parseFloat(row[1]);
                // System.out.println(Integer.parseInt(row[6]));
                MenuItem obj1 = new BaseProduct(row[0], Float.parseFloat(row[1]), Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]),0);
                if(exist(obj1)==0) listOfItems.add(obj1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

    }

    /**
     * @return: void
     * @param: menuItems ,a,c
     * Aceasta metoda modifica un produs
     */

    public void modifyProduct(ArrayList<MenuItem> menuItems, AdministratorView a, ClientView c)
    {
        a.listOfItemsModel.removeAllElements();
        c.listOfItemsModel.removeAllElements();

        for (MenuItem m : menuItems) {
            a.listOfItemsModel.addElement(m);
            c.listOfItemsModel.addElement(m);
        }
    }

    /**
     * @return: ArrayList<MenuItem>
     * @param:
     * Aceasta metoda returneaza lista de produse
     */

    public ArrayList<MenuItem> getListOfItems()
    {
        return listOfItems;
    }

    /**
     * @return: void
     * @param: poz
     * Aceasta metoda sterge un produs de pe o anumita pozitie
     */

    public void deleteItem(int poz)
    {
        listOfItems.remove(poz);
    }


    /**
     * @return: void
     * @param: m
     * Aceasta metoda adauga un produs in lista
     */

    public void addItem(MenuItem m)
    {
        assert m != null;
        assert m.getCalories() >0: "Valoarea pentru calorii trebuie sa fie pozitiva ";
        assert  m.getProtein() <0: "Valoarea pentru proteine trebuie sa fie pozitiva ";
        assert m.getFat() >0 : "Valoarea pentru grasimi trebuie sa fie pozitiva ";
        assert m.getSodium() >0 : "Valoarea pentru sodium trebuie sa fie pozitiva";
        assert m.getPrice() >0 : "Valoarea pentru pret trebuie sa fie pozitiva";
        listOfItems.add(m);
    }

    /**
     * @return: void
     * @param: listOfItems
     * Aceasta metoda seteaza o lista de produse
     */

    public void setListOfItems(ArrayList<MenuItem> listOfItems) {

        this.listOfItems = listOfItems;
    }
    /**
     * @return: ArrayList<MenuItem>
     * @param: selected ,condition
     * Aceasta metoda cauta dupa un anumit criteriu
     */
    public ArrayList<MenuItem> searchItems(String selected, String condition )
    {   assert selected != null;
        assert condition !=null;
        ArrayList<MenuItem> result= new ArrayList<MenuItem>();

        if(selected.equals("Name"))
        {
            result= (ArrayList<MenuItem>) listOfItems.stream().filter(m -> m.getTitle().toLowerCase(Locale.ROOT).contains(condition.toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());
        }
        else
        {
            String[] splited= condition.split(" ");
            char semn= splited[0].charAt(0);
            int value = Integer.parseInt(splited[1]);

            if(selected.equals("Rating"))
            {
                if(semn=='<')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getRating() < value).collect(Collectors.toList());

                }
                else if( semn=='>')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getRating() > value).collect(Collectors.toList());
                }
                else if(semn=='=')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getRating() == value).collect(Collectors.toList());
                }

            }

            else if( selected.equals("Calories"))
            {
                if(semn=='<')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getCalories() < value).collect(Collectors.toList());

                }
                else if( semn=='>')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getCalories() > value).collect(Collectors.toList());
                }
                else if(semn=='=')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getCalories() == value).collect(Collectors.toList());
                }

            }

            else if( selected.equals("Proteins"))
            {
                if(semn=='<')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getProtein() < value).collect(Collectors.toList());

                }
                else if( semn=='>')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getProtein() > value).collect(Collectors.toList());
                }
                else if(semn=='=')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getProtein() == value).collect(Collectors.toList());
                }

            }

            else if(selected.equals("Fats"))
            {
                if(semn=='<')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getFat() < value).collect(Collectors.toList());

                }
                else if( semn=='>')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getFat() > value).collect(Collectors.toList());
                }
                else if(semn=='=')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getFat() == value).collect(Collectors.toList());
                }
            }

            else if( selected.equals("Sodium"))
            {
                if(semn=='<')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getSodium() < value).collect(Collectors.toList());

                }
                else if( semn=='>')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getSodium() > value).collect(Collectors.toList());
                }
                else if(semn=='=')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getSodium() == value).collect(Collectors.toList());
                }
            }

            else if(selected.equals("Price"))
            {
                if(semn=='<')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getPrice() < value).collect(Collectors.toList());

                }
                else if( semn=='>')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getPrice() > value).collect(Collectors.toList());
                }
                else if(semn=='=')
                {
                    result = (ArrayList<MenuItem>)listOfItems.stream().filter(m -> m.getPrice() == value).collect(Collectors.toList());
                }
            }

        }


        return result;
    }

    /**
     * @return: void
     * @param: a
     * Aceasta metoda adauga un produs care este comandat
     */

    public void adaugaItemComanda(MenuItem a)
    {
        assert a!=null;
        orderItems.add(a);
    }

    /**
     * @return: ArrayList<MenuItem>
     * @param:
     * Aceasta metoda returneaza o lista de iteme comandate
     */

    public ArrayList<MenuItem> getOrderItems() {

        return orderItems;
    }

    /**
     * @return: void
     * @param: orderItems
     * Aceasta metoda seteaza o lista de iteme comandate
     */

    public void setOrderItems(ArrayList<MenuItem> orderItems) {

        this.orderItems = orderItems;
    }


    /**
     * @return: String
     * @param: clientID, clientOrder
     * Aceasta metoda creeaza un string cu comanda
     */

    public String createOrder(int clientID, ArrayList<MenuItem> clientOrder)
    {

        int orderID= ordersList.size()+1;
        Order or= new Order(orderID,clientID);
        int price=0;
        for(MenuItem m: clientOrder)
        {
            price=price+m.getPrice();
        }

        or.setPriceOrder(price);
        for(Users c1: listofUsers)
        {
              if(c1.getID()== clientID)c1.setNrOrd(c1.getNrOrd() +1);
        }

        ordersList.put(or,clientOrder);

        int totalPrice=0;

        String s="";
        s="Comanda cu numarul : " + orderID + " a fost primita" + "\n";
        s= s+ " Id-ul clientului care a plasat comanda este: " + clientID + "\n";
        s= s+ "Pentru comanda trebuie preparate urmatoarele: " + "\n";
        for( MenuItem index: clientOrder)
        {
            s=s + index.getTitle() + "--" + index.computePrice() + " RON " + "\n";
            totalPrice= totalPrice + index.computePrice();

        }
        s=s+"TOTALUL COMENZII ESTE: " + totalPrice + "\n" + "\n";
        return s;

    }


    public ArrayList<EmployeeView> addEmployees()
    {
        ArrayList<EmployeeView> array = new ArrayList<>();
        for( Users u1: listofUsers)
        {
            if(u1.getType()== Type.EMPLOYEE)
            {
                EmployeeView ew= new EmployeeView(u1.getUsername());
                array.add(ew);
            }
        }
        return array;
    }
    /**
     * @return: void
     * @param: bill
     * Aceasta metoda genereaza un string cu factura
     */
    public void generateBill(String bill)
    {
        FileWriter output = null;
        try {
            output = new FileWriter("BILL.txt", true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {

            output.write(bill);
            output.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return: String
     * @param: startHour , endHour
     * Aceasta metoda genereaza un String cu obiectele pentru raportul 1
     */

    public String rap1(Date startHour, Date endHour)
    {
        assert( (0<startHour.getHours())&&(startHour.getMonth() <=23)) : "Ora trebuie sa fie intre 1 si 23";
        assert ((0< endHour.getHours()) && (endHour.getHours() <=23)) : "Ora trebuie sa fie intre 1 si 23";

        String s="";

        ArrayList<Order> res = new ArrayList<Order>();

        res = (ArrayList<Order>) ordersList.keySet().stream()
                .filter(o -> o.getOrderDate().after(startHour) && o.getOrderDate().before(endHour))
                .collect(Collectors.toList());

        s=s+ "Comenzile dintre orele " + startHour.getHours()+ " si orele " + endHour.getHours() +" sunt: " + "\n";
        for(Order o:res)
        {
            s=  s + "( Comanda cu numarul: " + o.getOrderID() + " facuta de cilentul : " + o.getClientID() + " )" + "\n";

        }
        return s;
    }

    /**
     * @return: String
     * @param: number
     * Aceasta metoda genereaza un String cu obiectele pentru raportul 2
     */


    public  String rap2( int number ) {
        assert number >0 : "Number trebuie sa fie mai mare decat 0";
        String s = "";
        ArrayList<MenuItem> aux= new ArrayList<>();

        aux=(ArrayList<MenuItem>)orderItems.stream().filter(m-> m.getNumber() ==number).collect(Collectors.toList());

        for(MenuItem m1: aux)
        {
            s=s+ "Produsul " + m1.getTitle() + "a fost comandat de " + m1.getNumber() +" de ori" +"\n";
        }
        return s;
    }



    /**
     * @return: String
     * @param: number , amount
     * Aceasta metoda genereaza un String cu obiectele pentru raportul 3
     */
    public  String rap3(ArrayList<Users> clienti, LinkedHashMap<Order , ArrayList<MenuItem>> orders,  int number, int amount ) {


        assert number>= 0 : "Numarul de ori de cate ori clientul a plasat comanda trebuie sa fie mai mare decat 0 !";
        String s="";
        ArrayList<Users> myUsers = new ArrayList<>();
        ArrayList<Users> result = new ArrayList<>();
        ArrayList<Order> myOrders = new ArrayList<>();

        myUsers = (ArrayList<Users>)clienti.stream().filter(e -> e.getNrOrd() > number).collect(Collectors.toList());
        myOrders = (ArrayList<Order>)orders.keySet().stream().filter(e -> e.getPriceOrder() > amount).collect(Collectors.toList());

        myOrders =(ArrayList<Order>) myOrders.stream().filter(distinctByKey(n -> n.clientID)).collect(Collectors.toList());
        for(Users user1: myUsers){
            for(Order order1: myOrders){
                if(user1.getID() == order1.getClientID()){
                    if(!result.contains(user1)){
                        s=s+ user1.getID();
                    }
                }
            }
        }

       return s;
    }


    /**
     * @return: String
     * @param: date
     * Aceasta metoda genereaza un String cu obiectele pentru raportul 4
     */

    public  String rap4( Date date)
    {
        assert( (0<date.getMonth())&&(date.getMonth() <=12)) : "Luna trebuie sa fie intre 1 si 12";
        assert ((0< date.getDay()) && (date.getDay() <=32)) : "Ziua trebuie sa fie intre 1 si 31";

        String s = "";

        List<Order> ord = new ArrayList<>();

        for (Map.Entry<Order, ArrayList<MenuItem>> i : ordersList.entrySet()) {
            ord.add(i.getKey());
        }
        ord = ord.stream().filter(o -> o.getOrderDate().getDay()== date.getDay()).collect(Collectors.toList());

        List<MenuItem> prod = new ArrayList<>();

        for (Order i : ord) {
            for (Map.Entry<Order, ArrayList<MenuItem>> j : ordersList.entrySet()) {
                if (j.getKey().equals(i)) {
                    for (MenuItem m : j.getValue()) {
                        prod.add(m);
                    }
                }
            }
        }

        prod = prod.stream().filter(distinctByKey(p -> p.getTitle())).collect(Collectors.toList());
        for (MenuItem item : prod) {
            s=s+item.getTitle() + " " +  "Nr. de ori de cate a fost comandat:  " + item.getNumber() + "  ";
            s=s+"\n";
        }
        return s;
    }


    /**
     * @return: LinkedHashMap<Order>
     * @param:
     * Aceasta metoda returneaza hashmap-ul cu comenzile
     */

    public LinkedHashMap<Order, ArrayList<MenuItem>> getOrdersList() {
        return ordersList;
    }

    /**
     * @return: Date
     * @param:
     * Aceasta metoda returneaza Data curenta;
     */

    public Date getCurrentDate() {
        return currentDate;
    }
    
    /**
     * @return: void
     * @param: currentDate
     * Aceasta metoda seteaza data curenta
     */

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }


    public ArrayList<Client> getListOfClients() {
        return listOfClients;
    }

    public void setListOfClients(ArrayList<Client> listOfClients) {
        this.listOfClients = listOfClients;
    }
}


