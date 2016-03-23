/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.UserDAO;
import Model.User;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ceparator
 */
@Named
@RequestScoped
public class AddUserBean {

    @EJB
    private UserDAO userDAO = new UserDAO();

    private User user;

    @PostConstruct
    private void initializeBean() {
        user = new User();
        user.setRole("user");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String logout() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public String addNewUser() throws SQLException, Exception {
        userDAO.addUser(user.getUsername(), user.getPassword(), user.getRole(), user.getRouteNumber());
        return "/index.xhtml";
    }
}
