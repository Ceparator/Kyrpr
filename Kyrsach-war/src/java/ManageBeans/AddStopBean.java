/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.StopDAO;
import DAO.StopDAOInterface;
import Model.Stop;
import javax.faces.event.ActionEvent;
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
    private StopDAOInterface stopDAO;

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
        stopDAO.addStop(stop);
        return "/allStops.xhtml";
    }

    public String editStop(int idStop) throws SQLException, Exception {
        Stop somestop = new Stop(idStop, stop.getName(), stop.getCoordX(), stop.getCoordY());
        stopDAO.editStop(somestop);
        return "/allStops.xhtml";
    }
}
