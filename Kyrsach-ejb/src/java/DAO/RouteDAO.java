/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Circuit;
import Model.Route;
import Model.Stop;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Ceparator
 */
@Stateful
public class RouteDAO {

    public void deleteRoute(int idRoute, int first, int second) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Route> getAllRoutes() {
        ArrayList<Route> routeList = new ArrayList<>();
        Stop stop = new Stop(10, 10, "smth", 12.0, 12.0);
        Stop stop2 = new Stop(12, 14, "smth2", 13.0, 113.0);
        Route route = new Route(10, 10, stop, stop2, 10,10,10,10);
        routeList.add(route);
        return routeList;
    }

    public List<Circuit> getRouteSecondCircuit(int idRoute) {
        ArrayList<Circuit> circuitList = new ArrayList<>();
        return circuitList;
    }

    public List<Circuit> getRouteFirstCircuit(int idRoute) {
        ArrayList<Circuit> circuitList = new ArrayList<>();
        return circuitList;
    }

    public void cancelAddRoute() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addRoute(int number, int ticketprice) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
