/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.MyuserDAO;
import DAO.MyuserDAOInterface;
import DAO.RouteDAOInterface;
import Model.Myuser;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ceparator
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private MyuserDAOInterface userDAO;

    public List<Myuser> getAllUsers() throws Exception {
        return userDAO.getAllUsers();
    }
}
