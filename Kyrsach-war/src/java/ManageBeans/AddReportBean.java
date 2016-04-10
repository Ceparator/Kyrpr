/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.ReportDAO;
import DAO.ReportDAOInterface;
import Model.Report;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "addReportBean")
@RequestScoped
public class AddReportBean {

    @EJB
    private ReportDAOInterface reportDAO;

    private Report report;
    private RowStateMap stateMap;
    
    @PostConstruct
    private void initializeBean() {
        report = new Report();
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public RowStateMap getStateMap() {
        return stateMap;
    }

    public void setStateMap(RowStateMap stateMap) {
        this.stateMap = stateMap;
    }

    public String addNewReport(int routeNumber) throws SQLException, Exception {
        java.sql.Date newDate = new java.sql.Date(report.getVremya().getTime());
        reportDAO.addReport(routeNumber, report.getTickets(), newDate);
        return "/allReports.xhtml";
    }

    public String editReport(int idReport) throws SQLException, Exception {
        java.sql.Date newDate = new java.sql.Date(report.getVremya().getTime());
        reportDAO.editReport(idReport, report.getRouteNumber(), report.getTickets(), newDate);
        return "/allReports.xhtml";
    }
    
}