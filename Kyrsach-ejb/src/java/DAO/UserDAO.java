/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Ceparator
 */
@Stateful
public class UserDAO {

    public void addUser(String username, String password, String role, int routeNumber) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        User user = new User("smth", "smth", 12, "smth");
        userList.add(user);
        return userList;
       
    }
    
}
