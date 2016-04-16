/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Report;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ceparator
 */
@Local
public interface ReportDAOInterface {

    void addReport(int routeNumber, int tickets, Date newDate);

    void deleteReport(List<Report> selectedReportList) throws Exception;

    void editReport(int idReport, int routeNumber, int tickets, Date newDate);

    List<Report> getAllReports();
    
    int getUserRoute(String username);
    
}
