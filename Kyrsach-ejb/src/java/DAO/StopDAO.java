/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Stop;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Ceparator
 */
@Stateful
public class StopDAO {

    public void deleteStop(List<Stop> selectedStopList) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Stop> getAllStops() {
        ArrayList<Stop> stopList = new ArrayList<>();
        Stop stop = new Stop(10, 10, "smth", 12.0, 12.0);
        stopList.add(stop);
        return stopList;
    }

    public List<Stop> getFirstStop() {
        ArrayList<Stop> stopList = new ArrayList<>();
        return stopList;
    }

    public List<Stop> getSecondStop() {
        ArrayList<Stop> stopList = new ArrayList<>();
        return stopList;
    }

    public void addStop(String name, Double coordX, Double coordY) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editStop(int idStop, String name, Double coordX, Double coordY) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addStopForFirstCircuit(Stop item) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addStopForSecondCircuit(Stop item) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mirrorRoute() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
