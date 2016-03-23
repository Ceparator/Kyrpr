/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.StopDAO;
import Model.Stop;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "stopBean")
@SessionScoped
public class StopBean implements Serializable {
    
    @EJB
    private StopDAO stopDAO;

    private int editId;

    public StopBean(int editId) {
        this.editId = editId;
    }

    public int getEditId() {
        return editId;
    }

    public void setEditId(int editId) {
        this.editId = editId;
    }

    public StopBean() {
    }

    private RowStateMap stateMap;

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public void actionListener(ActionEvent event) throws Exception {
        List<Stop> selectedStopList = (List<Stop>) stateMap.getSelected();
        stopDAO.deleteStop(selectedStopList);
    }

    public List<Stop> getAllStops() throws Exception {
        return stopDAO.getAllStops();
    }

    public List<Stop> getFirstStops() throws Exception {
        return stopDAO.getFirstStop();
    }

    public List<Stop> getSecondStops() throws Exception {
        return stopDAO.getSecondStop();
    }

    public String editStop(int idStop) {
        this.editId = idStop;
        return "/editStop.xhtml";
    }

    
}
