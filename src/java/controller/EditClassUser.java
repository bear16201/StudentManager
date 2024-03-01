/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubjectDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 84337
 */
@WebServlet(name = "EditClassUser", urlPatterns = {"/editclassuser"})
public class EditClassUser extends HttpServlet {

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
            String classUserId = request.getParameter("cuid");
            String class_id = request.getParameter("class_id");
            String team_id = request.getParameter("team_id");
            String user_id = request.getParameter("user_id");
            String dropout_date = request.getParameter("dropout_date");
            String user_notes = request.getParameter("user_notes");
            String ongoing_eval = request.getParameter("onGoing");
            String final_pres_eval = request.getParameter("final_pres");
            String final_topic_eval = request.getParameter("final_topic");
            String status = request.getParameter("status");
            SubjectDao sd = new SubjectDao();
            try {
                sd.EditClassUser(class_id, team_id, user_id, dropout_date, user_notes, ongoing_eval, final_pres_eval, final_topic_eval, status, classUserId);

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Update Successful');");
                out.println("location='classuserlist'");
                out.println("</script>");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        request.getRequestDispatcher("classuserlist").include(request, response);
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
