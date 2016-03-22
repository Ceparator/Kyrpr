/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Ceparator
 */
public class Report {
    int idReport;
    int routeNumber;
    int tickets;
    Date vremya;
    int sum;
    

    public Report() {
    }

    public Report(int idReport, int routeNumber, int tickets, Date vremya, int sum) { //для вывода
        this.idReport = idReport;
        this.routeNumber = routeNumber;
        this.tickets = tickets;
        this.vremya = vremya;
        this.sum = sum;
    }

    public Report(int idReport, int routeNumber, int tickets, Date vremya) { //для добавления - сумма считается сама
        this.idReport = idReport;
        this.routeNumber = routeNumber;
        this.tickets = tickets;
        this.vremya = vremya;
    }
    

    public int getIdReport() {
        return idReport;
    }

    public void setIdReport(int idReport) {
        this.idReport = idReport;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public Date getVremya() {
        return vremya;
    }

    public void setVremya(Date vremya) {
        this.vremya = vremya;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
    
    
}
