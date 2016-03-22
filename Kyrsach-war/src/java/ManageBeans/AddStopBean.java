/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.StopDAO;
import Model.Stop;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "addStopBean")
@RequestScoped
public class AddStopBean {

    @EJB
    private StopDAO stopDAO;

    private Stop stop;
    private RowStateMap stateMap;

    @PostConstruct
    private void initializeBean() {
        stop = new Stop();
    }

    public Stop getStop() {
        return stop;
    }

    public void setRoute(Stop stop) {
        this.stop = stop;
    }

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public String addNewStop() throws SQLException, Exception {
        stopDAO.addStop(stop.getName(), stop.getCoordX(), stop.getCoordY());
        return "/allStops.xhtml";
    }

    public String editStop(int idStop) throws SQLException, Exception {
        stopDAO.editStop(idStop, stop.getName(), stop.getCoordX(), stop.getCoordY());
        return "/allStops.xhtml";
    }

    public void addNewFirstStop(ActionEvent event) throws Exception {
        List<Stop> selectedStopList = (List<Stop>) stateMap.getSelected();
        Iterator<Stop> iter = selectedStopList.iterator();
        while (iter.hasNext()) {
            Stop item = iter.next();
            stopDAO.addStopForFirstCircuit(item);
        }
    }

    public void addNewSecondStop(ActionEvent event) throws Exception {
        List<Stop> selectedStopList = (List<Stop>) stateMap.getSelected();
        Iterator<Stop> iter = selectedStopList.iterator();
        while (iter.hasNext()) {
            Stop item = iter.next();
            stopDAO.addStopForSecondCircuit(item);
        }
    }

    public void mirror() throws SQLException, Exception {
        stopDAO.mirrorRoute();
    }

}
