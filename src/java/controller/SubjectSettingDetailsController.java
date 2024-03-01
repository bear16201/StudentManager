/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SubjectSetting;

/**
 *
 * @author PC PHUC
 */
public class SubjectSettingDetailsController extends HttpServlet {

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
            String sid = request.getParameter("sid");
            AdminDao dao = new AdminDao();
            SubjectSetting subS = dao.getSubjectSettingByID(sid);
            request.setAttribute("subS", subS);
            request.getRequestDispatcher("./SubjectSettingDetails.jsp").forward(request, response);
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
        String subSid = request.getParameter("sid");
        System.out.println(subSid);
        AdminDao dao = new AdminDao();
        SubjectSetting subS = new SubjectSetting();
        subS = dao.getSubjectSettingByID(subSid);
        int warring = 0;
        String inte = "[0-9]+";
//        System.out.println(s.getId());
//        System.out.println("");
        String subjID = request.getParameter("sjID");
        String typeid = request.getParameter("typeid");
        String title = request.getParameter("title");
        String order = request.getParameter("order");
        String value = request.getParameter("value");
        String status = request.getParameter("status");
        if (typeid == null || typeid.equals("")) {
            request.setAttribute("messWarring", "!! Type ID not null !!");
            warring = 1;
        }
        if (!typeid.matches(inte)) {
            warring = 1;
            request.setAttribute("messWarring", "!! Type ID must be number !!");
        }
        if (title == null || title.equals("")) {
            request.setAttribute("messWarring", "!! Title not null !! ");
            warring = 1;
        }
        if (order == null || order.equals("")) {
            request.setAttribute("messWarring", "!! Type ID not null !!");
            warring = 1;
        }
        if (value == null || value.equals("")) {
            request.setAttribute("messWarring", "!! Value not null !!");
            warring = 1;
        }
        if (!value.matches(inte)) {
            warring = 1;
            request.setAttribute("messWarring", "!! Value must be number !!");
        }
        if (status == null || status.equals("")) {
            request.setAttribute("messWarring", "!! Status not null !!");
            warring = 1;
        }
        if (!status.matches(inte)) {
            warring = 1;
            request.setAttribute("messWarring", "!! Status must be number !!");
        }

        if (warring == 1) {
            request.setAttribute("subS", subS);

            RequestDispatcher dispath
                    = request.getRequestDispatcher("./SubjectSettingDetail.jsp");
            //run 
            dispath.forward(request, response);
        } else {
            dao.updatetSubjectSetting(subjID, typeid, title, value, order, status, subSid);

            response.sendRedirect("subjectsettinglist");
        }
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
