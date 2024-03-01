/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author NamOK
 */
public class UserDetailsController extends HttpServlet {

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
        String userID = request.getParameter("userID");
        UserDao d = new UserDao();
        User user = new User();

        try {
            if (userID.length() != 0) {
                user = d.GetUserbyID(userID);
                request.setAttribute("user", user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        request.getRequestDispatcher("./UserDetails.jsp").forward(request, response);
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
        String userID = request.getParameter("userID");
        UserDao d = new UserDao();
        User user = new User();
        try {
            user = d.GetUserbyID(userID);
        } catch (Exception ex) {
            Logger.getLogger(UserDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //..........
        String fullName = request.getParameter("fullName");
        user.setFullName(fullName);
        String email = request.getParameter("email");
        user.setEmail(email);
        int mobile = Integer.parseInt(request.getParameter("mobile"));
        user.setMobile(mobile);
        int gender_num =Integer.parseInt(request.getParameter("gender"));
        boolean gender = (gender_num == 1) ; 
        user.setGender(gender);
        String date = request.getParameter("date");
        user.setDate(date);
        int roll = Integer.parseInt(request.getParameter("roll"));
        user.setRoll(roll);
        String status = request.getParameter("status");
        user.setStatus(status);
        int rolesId = Integer.parseInt(request.getParameter("roleid"));
        user.setRollId(rolesId);
        String address = request.getParameter("address");
        user.setAddress(address);
        //.......Update 

        try {
            d.update(user);
        } catch (Exception ex) {
            Logger.getLogger(UserDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //...............
        //String userID, int roll, String fullName, boolean gender, String date, String email, int mobile, String avatar, String linkFB, int rollId, String status, String password
        //............
        response.sendRedirect("userdetail?userID=" + userID);
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
