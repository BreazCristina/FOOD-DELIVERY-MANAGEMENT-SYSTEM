package Business;

import java.io.Serializable;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */

public class Administrator extends Users implements Serializable {

    public Administrator(String username, String password,int nrOrd)
    {
        super(username,password, nrOrd);
        type=Type.ADMINISTRATOR;
    }



}
