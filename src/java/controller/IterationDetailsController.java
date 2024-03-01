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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Iteration;
import model.Setting;
import model.Subject;

/**
 *
 * @author PC PHUC
 */
@WebServlet(name = "IterationDetailsController", urlPatterns = {"/iterationdetails"})
public class IterationDetailsController extends HttpServlet {

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
            out.println("<title>Servlet IterationDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IterationDetailsController at " + request.getContextPath() + "</h1>");
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
        int iterID = Integer.parseInt(request.getParameter("iterID"));
        AdminDao dao = new AdminDao();
        Iteration d = new Iteration();
        List<Subject> list = new ArrayList();
        list = dao.getAllIterSubId();
        try {
            if (iterID != 0) {
                d = dao.getIterationByID(iterID);
                request.setAttribute("d", d);
                request.setAttribute("l", list);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        request.getRequestDispatcher("./IterationDetails.jsp").forward(request, response);
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
        int iterID = Integer.parseInt(request.getParameter("iterID"));
        AdminDao dao = new AdminDao();
        Iteration d = new Iteration();
        List<Subject> list = dao.getAllIterSubId();
        try {
            request.setAttribute("l", list);
            d = dao.getIterationByID(iterID);
        } catch (Exception ex) {
            System.out.println(ex);
        }
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
        try {
            if (subjectid == null || subjectid.equals("")) {
                request.setAttribute("mess", "!! Subject Id not null !!");
                warring = 1;
            } else if (name == null || name.equals("")) {
                request.setAttribute("mess", "!! Iteration Name not null !!");
                warring = 1;
            } else if (duration == null || duration.equals("")) {
                request.setAttribute("mess", "!! Duration not null !!");
                warring = 1;
            }
            else if (!name.matches(regex)) {
                request.setAttribute("mess", "!! Iteration Name must 5-50 character !!");
                warring = 1;
            }
            if (warring == 1) {
                request.setAttribute("d", d);
                request.getRequestDispatcher("./IterationDetails.jsp").forward(request, response);
            } else {
                dao.updatetIteration(subjectid, name, duration, status, iterID);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        response.sendRedirect("iterationdetails?iterID=" + iterID);
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
