/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import DAO.ReportDAO;
import Model.Report;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import org.icefaces.ace.model.table.RowStateMap;

/**
 *
 * @author Ceparator
 */
@Named(value = "reportBean")
@SessionScoped
public class ReportBean implements Serializable {

    @EJB
    private ReportDAO reportDAO;

    private int editId;

    public ReportBean(int editId) {
        this.editId = editId;
    }

    public int getEditId() {
        return editId;
    }

    public void setEditId(int editId) {
        this.editId = editId;
    }

    public ReportBean() {
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

    public String editReport(int idReport) {
        this.editId = idReport;
        return "/editReport.xhtml";
    }
    
}
