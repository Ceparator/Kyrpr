/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.RouteDAO;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ceparator
 */
@Named(value = "addRouteBean")
@RequestScoped
public class AddRouteBean {

    @EJB
    private RouteDAO routeDAO;

    private int number;
    private int ticketprice;

    public int getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(int ticketprice) {
        this.ticketprice = ticketprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String addNewRoute() throws SQLException {
        routeDAO.addRoute(number, ticketprice);
        return "/allRoutes.xhtml";
    }

    public String cancelAddRoute() throws SQLException {
        routeDAO.cancelAddRoute();
        return "/allRoutes.xhtml";
    }

}
