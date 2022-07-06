package Business;

import java.util.Date;
import java.util.Objects;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */
public class Order {
    int orderID;
    int clientID;
    Date orderDate;
    int priceOrder;


    public Order(int orderID, int clientID)
    {
        this.orderID=orderID;
        this.clientID= clientID;
        orderDate=new Date();
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clientID, orderDate);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(int priceOrder) {
        this.priceOrder = priceOrder;
    }
}