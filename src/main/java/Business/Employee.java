package Business;

/**
 * @Author: Breaz Cristina-Elena
 * @Since: May 18, 2022
 */
public class Employee extends Users{
    public Employee(String username, String password,int nrOrd)
    {
        super(username,password,nrOrd);
        type=Type.EMPLOYEE;
    }
}
