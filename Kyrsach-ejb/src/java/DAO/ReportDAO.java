/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Myuser;
import Model.Report;
import Model.Route;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ceparator
 */
@Stateless
public class ReportDAO implements ReportDAOInterface {

    @PersistenceContext(unitName = "Kyrsach-ejbPU2")
    private EntityManager em2;

    @PersistenceContext(unitName = "Kyrsach-ejbPU")
    private EntityManager em;

    @Override
    public void deleteReport(List<Report> selectedReportList) throws Exception {
        Iterator<Report> iter = selectedReportList.iterator();
        try {
            while (iter.hasNext()) {
                Report item = iter.next();
                Report someReport = em2.getReference(Report.class, item.getIdReport());
                Query query = em.createQuery("SELECT r FROM Route r WHERE r.number = ?1", Report.class);
                query.setParameter(1, someReport.getRouteNumber());
                Route route = (Route) query.getSingleResult();
                route.setRating(route.getRating() - someReport.getSumma() * 0.01);
                em.merge(route);
                em2.remove(someReport);
            }
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    @Override
    public List<Report> getAllReports() {
        Query query = em2.createQuery("SELECT r FROM Report r", Report.class);
        return query.getResultList();
    }

    @Override
    public int getUserRoute(String username) {
        Myuser myuser = em2.find(Myuser.class, username);
        int routeNumber = myuser.getRouteNumber();
        Query query = em.createQuery("SELECT r FROM Route r WHERE r.number = ?1", Report.class);
        query.setParameter(1, routeNumber);
        Route route = (Route) query.getSingleResult();
        return route.getNumber();
    }

    @Override
    public void addReport(int routeNumber, int tickets, Date newDate) {
        Query query = em.createQuery("SELECT r FROM Route r WHERE r.number = ?1", Report.class);
        query.setParameter(1, routeNumber);
        Route route = (Route) query.getSingleResult();
        Report report = new Report();
        report.setRouteNumber(routeNumber);
        report.setTickets(tickets);
        report.setVremya(newDate);
        report.setSumma(route.getPrice() * tickets);
        em2.persist(report);
        route.setRating(route.getRating() + report.getSumma() * 0.01);
        em.merge(route);
    }

    @Override
    public void editReport(int idReport, int routeNumber, int tickets, Date newDate) {
        Query query = em.createQuery("SELECT r FROM Route r WHERE r.number = ?1", Report.class);
        query.setParameter(1, routeNumber);
        Report oldReport = em2.find(Report.class, idReport);
        int oldSum = oldReport.getSumma();
        Route route = (Route) query.getSingleResult();
        Report report = new Report();
        report.setRouteNumber(routeNumber);
        report.setTickets(tickets);
        report.setVremya(newDate);
        report.setSumma(route.getPrice() * tickets);
        report.setIdReport(idReport);
        em2.merge(report);
        route.setRating(route.getRating() - oldSum * 0.01 + report.getSumma() * 0.01);
        em.merge(route);
    }

}
