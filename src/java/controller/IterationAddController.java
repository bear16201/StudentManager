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
import model.Iteration;
import model.Subject;

/**
 *
 * @author PC PHUC
 */
public class IterationAddController extends HttpServlet {

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
        AdminDao dao = new AdminDao();
        List<Subject> list = dao.getAllIterSubId();
        request.setAttribute("l", list);
        request.getRequestDispatcher("IterationAdd.jsp").forward(request, response);
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
        AdminDao dao = new AdminDao();
        Iteration d = new Iteration();
        List<Subject> list = dao.getAllIterSubId();
        request.setAttribute("l", list);
        int warring = 0;
        String regex = "^[A-Za-z0-9]{5,50}+$";

        String subjectid = request.getParameter("subjectid");
        d.getSubjectid();
        String name = request.getParameter("name");
        d.getName();
        String duration = request.getParameter("duration");
        d.getDuration();
        String status = request.getParameter("status");
        d.getStatus();
        Iteration i = dao.checkIterExist(name);
        try {
            if (i == null) {
                if (subjectid == null || subjectid.equals("")) {
                    request.setAttribute("mess", "!! Subject Id not null !!");
                    warring = 1;
                } else if (name == null || name.equals("")) {
                    request.setAttribute("mess", "!! Iteration Name not null !!");
                    warring = 1;
                } else if (duration == null || duration.equals("")) {
                    request.setAttribute("mess", "!! Duration not null !!");
                    warring = 1;
                }else if (!name.matches(regex)) {
                    request.setAttribute("mess", "!! Iteration Name must 5-50 character !!");
                    warring = 1;
                }
            } else {
                request.setAttribute("mess", "!! Iteration Name did exist !!");
                warring = 1;
            }
            if (warring == 1) {       
                request.getRequestDispatcher("./IterationAdd.jsp").forward(request, response);
            } else {
                dao.addIteration(subjectid, name, duration, status);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        request.getRequestDispatcher("iterationlist").forward(request, response);
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
