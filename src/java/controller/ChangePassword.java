/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author My PC
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/changepassword"})
public class ChangePassword extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String psw = request.getParameter("psw1");
        String psw2 = request.getParameter("psw2");

        String oldPass = request.getParameter("oldpsw");
        UserDao dao = new UserDao();
        HttpSession session = request.getSession();

        User u = (User) session.getAttribute("acc");
        if (oldPass.equalsIgnoreCase(u.getPassword())) {

            if (psw.equalsIgnoreCase(psw2)) {

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Password changed');");
                out.println("location='profile';");
                out.println("</script>");
                dao.updatePass(psw, u.getEmail(), u.getPassword());
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('New password does not match');");
                out.println("location='profile';");
                out.println("</script>");

            }
            
        }else{
            out.println("<script type=\"text/javascript\">");
                out.println("alert('Password inconrect');");
                out.println("location='profile';");
                out.println("</script>");
        }

        request.getRequestDispatcher("profile.jsp").include(request, response);

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
