/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.ReportDAO;
import DAO.ReportDAOInterface;
import Model.Report;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "reportBean")
@SessionScoped
public class ReportBean implements Serializable {

    @EJB
    private ReportDAOInterface reportDAO;

    private int editId;
    private int routeNumber;
    private int oldRouteNumber;
    private int oldTickets;
    private Date oldVremya;

    @PostConstruct
    private void initializeBean() {
        editId = 0;
    }

    public int getEditId() {
        return editId;
    }

    public void setEditId(int editId) {
        this.editId = editId;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getOldRouteNumber() {
        return oldRouteNumber;
    }

    public void setOldRouteNumber(int oldRouteNumber) {
        this.oldRouteNumber = oldRouteNumber;
    }

    public int getOldTickets() {
        return oldTickets;
    }

    public void setOldTickets(int oldTickets) {
        this.oldTickets = oldTickets;
    }

    public Date getOldVremya() {
        return oldVremya;
    }

    public void setOldVremya(Date oldVremya) {
        this.oldVremya = oldVremya;
    }

    private RowStateMap stateMap;

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public void actionListener(ActionEvent event) throws Exception {
        List<Report> selectedReportList = (List<Report>) stateMap.getSelected();
        reportDAO.deleteReport(selectedReportList);
    }

    public List<Report> getAllReports() throws Exception {
        return reportDAO.getAllReports();
    }

    public String toEditReport(int idReport, int oldRouteNumber, int oldTickets, Date oldVremya) {
        this.editId = idReport;
        this.oldRouteNumber = oldRouteNumber;
        this.oldTickets = oldTickets;
        this.oldVremya = oldVremya;
        return "/editReport.xhtml";
    }
    
    public String toAddReport() throws SQLException, Exception {
        String somename = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        routeNumber = reportDAO.getUserRoute(somename);
        return "/addReport.xhtml";
    }  
}
