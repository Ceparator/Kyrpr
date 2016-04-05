/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.RouteDAO;
import DAO.RouteDAOInterface;
import DAO.StopDAO;
import Model.Route;
import Model.Circuit;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "routeBean")
@SessionScoped
public class RouteBean implements Serializable {

    @EJB
    private RouteDAOInterface routeDAO;

    private int numberRoute;
    
    @PostConstruct
    private void initializeBean() {
        numberRoute = 0;
    }

    public int getNumberRoute() {
        return numberRoute;
    }

    public void setNumberRoute(int numberRoute) {
        this.numberRoute = numberRoute;
    }

    private RowStateMap stateMap;

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public void actionListener(ActionEvent event) throws Exception {
        List<Route> selectedRouteList = (List<Route>) stateMap.getSelected();
        Iterator<Route> iter = selectedRouteList.iterator();
        while (iter.hasNext()) {
            Route item = iter.next();
            routeDAO.deleteRoute(item);
        }
    }

    public List<Route> getAllRoutes() throws Exception {
        return routeDAO.getAllRoutes();
    }

    public List<Circuit> getFirstCircuit(int idRoute) throws Exception {
        return routeDAO.getRouteFirstCircuit(idRoute);
    }

    public List<Circuit> getSecondCircuit(int idRoute) throws Exception {
        return routeDAO.getRouteSecondCircuit(idRoute);
    }

    public String redirectRouteInfo(int number) {
        this.numberRoute = number;
        return "/routeCircuit.xhtml";
    }

}
