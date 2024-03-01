/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class checkResPassController extends HttpServlet {

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
            String service = request.getParameter("do");
            UserDao daoUser = new UserDao();
            int warning;
            warning = 0;
            request.setAttribute("warning", warning);
            RequestDispatcher dispath
                    = request.getRequestDispatcher("checkPassword.jsp");
            //run 
            dispath.forward(request, response);
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
        String service = request.getParameter("do");
        UserDao daoUser = new UserDao();
        int warning;
        HttpSession sessionCheckEmail = request.getSession();
        String UserID = (String) sessionCheckEmail.getAttribute("UserID");
//                Users Users = daoUser.checkMail(email);
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String RePass = request.getParameter("rePassword");
        String pass = daoUser.checkUserByID(UserID);
        warning = 0;
        if (oldPassword != pass) {
            warning = 1;
        }
        if (newPassword != RePass) {
            warning = 1;
        }
        if (warning == 1) {
            request.setAttribute("warning", warning);
            RequestDispatcher dispath
                    = request.getRequestDispatcher("checkPassword.jsp");
            //run 
            dispath.forward(request, response);
        } else {
            daoUser.UpdatePassword(newPassword, UserID);
            request.setAttribute("warning", warning);
            RequestDispatcher dispath
                    = request.getRequestDispatcher("ControllerLogin");
            //run 
            dispath.forward(request, response);
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
