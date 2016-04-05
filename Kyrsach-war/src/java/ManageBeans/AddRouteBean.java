/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.CircuitDAOInterface;
import DAO.RouteDAOInterface;
import Model.Circuit;
import Model.Route;
import Model.Stop;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "addRouteBean")
@SessionScoped
public class AddRouteBean implements Serializable {

    @EJB
    private RouteDAOInterface routeDAO;
    @EJB
    private CircuitDAOInterface circuitDAO;

    private Route route;
    private List<Stop> firstStops;
    private List<Stop> secondStops;

    @PostConstruct
    private void initializeBean() {
        route = new Route();
        firstStops = new ArrayList<>();
        secondStops = new ArrayList<>();
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Stop> getFirstStops() {
        return firstStops;
    }

    public void setFirstStops(List<Stop> firstStops) {
        this.firstStops = firstStops;
    }

    public List<Stop> getSecondStops() {
        return secondStops;
    }

    public void setSecondStops(List<Stop> secondStops) {
        this.secondStops = secondStops;
    }

    private RowStateMap stateMap;

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public String addNewRoute() throws SQLException, Exception {
        route.setRating(0);
        int count = 1;
        List<Circuit> firstCircuit = new ArrayList<>();
        List<Circuit> secondCircuit = new ArrayList<>();
        int idRoute = routeDAO.addRoute(route, firstStops.get(0), secondStops.get(0));
        Iterator<Stop> iter = firstStops.iterator();
        while (iter.hasNext()) {
            Circuit circuit = new Circuit();
            circuit.setStopNumber(count);
            circuit.setTyda(true);
            circuit.setIdStop(iter.next());
            firstCircuit.add(circuit);
            count++;
        }
        count = 1;
        iter = secondStops.iterator();
        while (iter.hasNext()) {
            Circuit circuit = new Circuit();
            circuit.setStopNumber(count);
            circuit.setTyda(false);
            circuit.setIdStop(iter.next());
            secondCircuit.add(circuit);
            count++;
        }  
        circuitDAO.addCircuit(firstCircuit, idRoute);
        circuitDAO.addCircuit(secondCircuit, idRoute);
        return "/allRoutes.xhtml";
    }

    public void addFirstStops(Stop stop) throws Exception {
        if (!firstStops.contains(stop)) {
            firstStops.add(stop);
        }
    }

    public void addSecondStops(Stop stop) throws Exception {
        if (!secondStops.contains(stop)) {
            secondStops.add(stop);
        }
    }

    public void mirror() {
        secondStops = Lists.reverse(firstStops);
    }
}
