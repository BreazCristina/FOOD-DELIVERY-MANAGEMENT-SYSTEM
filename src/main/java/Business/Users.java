package Business;

import java.io.Serializable;



/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */
enum Type
{
    ADMINISTRATOR, CLIENT, EMPLOYEE;
}


public class Users  implements Serializable {

    private String password;
    private String username;
    Type type;
    private int nrOrd;
    private int ID;
    public Users(String password, String username, int nrOrd)
    {
        this.username=username;
        this.password=password;
        this.nrOrd=0;
        //this.type=type;

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Users{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", type=" + type +
                '}';
    }

    public int getNrOrd() {
        return nrOrd;
    }

    public void setNrOrd(int nrOrd) {
        this.nrOrd = nrOrd;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
