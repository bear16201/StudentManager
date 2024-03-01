/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Setting;

/**
 *
 * @author PC PHUC
 */
@WebServlet(name = "SettingDetailsController", urlPatterns = {"/settingdetails"})
public class SettingDetailsController extends HttpServlet {

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
            out.println("<title>Servlet SettingDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingDetailsController at " + request.getContextPath() + "</h1>");
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
        String sid = request.getParameter("sid");
        AdminDao dao = new AdminDao();
        Setting d = dao.getSettingByID(sid);
        try {
            if (sid.length() != 0) {
                d = dao.getSettingByID(sid);
                request.setAttribute("d", d);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        request.getRequestDispatcher("./SettingDetails.jsp").forward(request, response);
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
        String sid = request.getParameter("sid");
        AdminDao dao = new AdminDao();
        Setting d = new Setting();
        try {
            d = dao.getSettingByID(sid);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        String type_id = request.getParameter("type_id");
        d.getType_id();
        String title = request.getParameter("title");
        d.getTitle();
        String subject_name = request.getParameter("subject_name");
        d.getSubject_name();
        String type = request.getParameter("type");
        d.getType();
        String value = request.getParameter("value");
        d.getValue();
        String order = request.getParameter("order");
        d.getOrder();
        String status = request.getParameter("status");
        d.getStatus();
        String description = request.getParameter("description");
        d.getDescription();
        try {
            dao.updatetSetting(type, subject_name, title, value, order, status, description, type_id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        response.sendRedirect("settingdetails?sid=" + sid);
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
