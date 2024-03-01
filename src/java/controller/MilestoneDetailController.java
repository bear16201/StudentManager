/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MilestoneDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Iteration;
import model.Milestone;

/**
 *
 * @author PC PHUC
 */
@WebServlet(name = "MilestoneDetailController", urlPatterns = {"/milestonedetail"})
public class MilestoneDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            MilestoneDao dao = new MilestoneDao();
            String milestoneid = (String) request.getParameter("id");
            Milestone mi = new Milestone();
            int miid = dao.lastid() + 1;
            //................................
            List<model.Class> listC = new ArrayList();
            listC = dao.getAllClass();
            List<Iteration> listI = new ArrayList();
            listI = dao.getAllIter();
            //............................
            if (milestoneid != null) {

                int id = Integer.parseInt(milestoneid);
                try {
                    mi = dao.GetMilestonebyID(id);
                    //............................
//                    listI.add(new Iteration(mi.getIteration_id(), mi.getIteration_name()));
                    miid = mi.getId();
                    listC.add(0, new model.Class(mi.getClass_id(), mi.getClass_name()));
                    listI.add(0, new Iteration(mi.getIteration_id(), mi.getIteration_name()));

                    Date from, to;
                    from = new SimpleDateFormat("mm/dd/yyyy").parse(mi.getFrom_date());
                    to = new SimpleDateFormat("mm/dd/yyyy").parse(mi.getTo_date());
                    System.out.println(from + " from  " + mi.getFrom_date());
                    request.setAttribute("mi", mi);
                    request.setAttribute("from", from);
                    request.setAttribute("to", to);

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

            //..................................
            request.setAttribute("listC", listC);
            request.setAttribute("listI", listI);
            request.setAttribute("miid", miid);

            request.getRequestDispatcher("MilestoneDetails.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MilestoneDao dao = new MilestoneDao();
        //.....................................
        String id = request.getParameter("id");
        String message = null;
        int milesid = 0;
        if (id != null) {
            milesid = Integer.parseInt(id);
        }
        int newid = milesid;
        int iteration_id = Integer.parseInt(request.getParameter("iterid"));
        String class_id = request.getParameter("classid");
        String from_date = (String) request.getParameter("from");
        request.setAttribute("from", from_date);
        String to_date = (String) request.getParameter("to");
        request.setAttribute("to", to_date);

        //.............................
        Date from, to;
        try {

            from = new SimpleDateFormat("yyyy-mm-dd").parse(from_date);
            to = new SimpleDateFormat("yyyy-mm-dd").parse(to_date);
            if (from.after(to)) {
                message = "From after To !";
            }
            request.setAttribute("message", message);
        } catch (ParseException ex) {
            Logger.getLogger(MilestoneDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //..............................
        String statustr = request.getParameter("status");
        int status = 1;
        List<model.Class> listC = new ArrayList();
        listC = dao.getAllClass();
        List<Iteration> listI = new ArrayList();
        listI = dao.getAllIter();
        request.setAttribute("listC", listC);
        request.setAttribute("listI", listI);
        //...................................
        Milestone mi = new Milestone(milesid, iteration_id, class_id, from_date, to_date, status);
        if (message == null) {
            dao.addMilestone(mi);
            newid = dao.lastid();
            request.setAttribute("su", "Successfully !");
        }
        request.setAttribute("miid", newid);
        //...................................
        request.getRequestDispatcher("milestonedetail.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
