/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class CheckLinkController extends HttpServlet {

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
            if (service == null) {
                service = "watting";
            }
            if (service.equals("watting")) {
                RequestDispatcher dispath
                        = request.getRequestDispatcher("page/user/watting.jsp");
                //run 
                dispath.forward(request, response);
            }
            if (service.equals("createID")) {
                String userID = request.getParameter("UserID");
                UserDao userDao = new UserDao();
                if (userID != null) {
                    String fullName = request.getParameter("fullname");
                    String gender = request.getParameter("gender");
                    String email = request.getParameter("email");
                    String mobile = request.getParameter("mobile");
                    String password = request.getParameter("password");
                    //
                    boolean valueGender = Boolean.parseBoolean(gender);
                    int mobileValue = Integer.parseInt(mobile);
                    int roll = userDao.checkRoll();
                    int rollID = 1;

                    User user = new User(userID, roll, fullName, valueGender, email, mobileValue, rollID, password);
//                    userDao.NewUserByID(userID);
                    userDao.addUsers(user);
                    response.sendRedirect("ControllerLogin");
                } else {
                    RequestDispatcher dispath
                            = request.getRequestDispatcher("page/user/watting.jsp");
                    //run 
                    dispath.forward(request, response);
                }
            }

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
        processRequest(request, response);
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
