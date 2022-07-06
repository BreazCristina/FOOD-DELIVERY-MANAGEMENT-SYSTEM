package Business;
import java.io.Serializable;
/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */

public class Client extends  Users  implements Serializable {

    private int ID;

    public Client(String username, String password,int ID, int nrOrd )
    {

        super(username,password,nrOrd);
        this.ID=ID;
        type=Type.CLIENT;

    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }
}
