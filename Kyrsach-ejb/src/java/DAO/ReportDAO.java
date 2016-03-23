/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Report;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Ceparator
 */
@Stateful
public class ReportDAO {

    public void deleteReport(List<Report> selectedReportList) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Report> getAllReports() {
        ArrayList<Report> reportList = new ArrayList<>();
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Report report = new Report(10, 10, 10, sqlDate, 10);
        reportList.add(report);
        return reportList;
    }

    public void addReport(int routeNumber, int tickets, Date newDate) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void editReport(int idReport, int routeNumber, int tickets, Date newDate) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
