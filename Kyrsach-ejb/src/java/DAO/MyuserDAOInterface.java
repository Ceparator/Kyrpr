/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Myuser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ceparator
 */
@Local
public interface MyuserDAOInterface {

    void addUser(String username, String password, String role, int routeNumber) throws Exception;

    List<Myuser> getAllUsers();
    
}
