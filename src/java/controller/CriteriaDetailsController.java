/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Criteria;
import model.Iteration;
import model.Subject;

/**
 *
 * @author PC PHUC
 */
public class CriteriaDetailsController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CriteriaDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CriteriaDetailsController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        int critID = Integer.parseInt(request.getParameter("critID"));
        AdminDao dao = new AdminDao();
        List<Iteration> list = dao.getAllIter();
        List<Subject> listS = dao.getAllSubjectName();
        try {
            if (critID != 0) {
                Criteria c = dao.getCriteriaByID(critID);
                request.setAttribute("d", c);
                request.setAttribute("l", list);
                request.setAttribute("listS", listS);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        request.getRequestDispatcher("./CriteriaDetails.jsp").forward(request, response);
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
        int critID = Integer.parseInt(request.getParameter("critID"));
        AdminDao dao = new AdminDao();
        Criteria c = new Criteria();
        List<Iteration> list = dao.getAllIter();
        List<Subject> listS = dao.getAllSubjectName();
        try {
            request.setAttribute("l", list);
            request.setAttribute("listS", listS);
            c = dao.getCriteriaByID(critID);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        int warring = 0;
        String regexInt = "^[0-9]+$";
        String regex = "^[A-Za-z0-9]{5,50}+$";
//        String regexDouble = "^[0-9]+\\.?[0-9]*$";
        String sbname = request.getParameter("sbname");
        c.getSubject_name();
        String critname = request.getParameter("critname");
        c.getCriteria_name();
        String iteration_name = request.getParameter("iteration_name");
        c.getIteration_name();
        String evaluation_weight = request.getParameter("evaluation_weight");
        c.getEvaluation_weight();
        String team_evaluation = request.getParameter("team_evaluation");
        c.getTeam_evaluation();
        String criteria_order = request.getParameter("criteria_order");
        c.getCriteria_order();
        String max_loc = request.getParameter("max_loc");
        c.getMax_loc();
        String status = request.getParameter("status");
        c.getStatus();
        String description = request.getParameter("description");
        c.getDescription();
        try {
            if (evaluation_weight == null || evaluation_weight.equals("")) {
                request.setAttribute("messW", "!! Weight not null !!");
                warring = 1;
            } else if (criteria_order == null || criteria_order.equals("")) {
                request.setAttribute("messO", "!! Criteria Order not null !!");
                warring = 1;
            } else if (critname == null || critname.equals("")) {
                request.setAttribute("messN", "!! Criteria Name not null !!");
                warring = 1;
            } else if (max_loc == null || max_loc.equals("")) {
                request.setAttribute("messL", "!! Max Loc not null !!");
                warring = 1;
            } else if (description == null || description.equals("")) {
                request.setAttribute("messD", "!! Description not null !!");
                warring = 1;
            } else if (!evaluation_weight.matches(regexInt)) {
                request.setAttribute("messW", "!! Input Weight Integer only !!");
                warring = 1;
            } else if (!criteria_order.matches(regexInt)) {
                request.setAttribute("messO", "!! Input Criteria Order Integer only !!");
                warring = 1;
            } else if (!max_loc.matches(regexInt)) {
                request.setAttribute("messL", "!! Input Max Loc Integer only !!");
                warring = 1;
            } else if (!critname.matches(regex)) {
                request.setAttribute("messN", "!! Criteria Name must 5-50 character !!");
                warring = 1;
            }
            if (warring == 1) {
                request.setAttribute("d", c);
                request.getRequestDispatcher("./CriteriaDetails.jsp").forward(request, response);
            } else {
                dao.updatetCriteria(critname, sbname, iteration_name, evaluation_weight, team_evaluation, criteria_order, max_loc, status, description, critID);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        response.sendRedirect("criteriadetails?critID=" + critID);
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
