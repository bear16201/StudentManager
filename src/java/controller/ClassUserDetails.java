/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import dao.SubjectDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClassUser;
import model.Team;
import model.User;

/**
 *
 * @author 84337
 */
@WebServlet(name = "ClassUserDetails", urlPatterns = {"/classuserdetails"})
public class ClassUserDetails extends HttpServlet {

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

            UserDao udao = new UserDao();
            SubjectDao sd = new SubjectDao();
            AdminDao dao = new AdminDao();
            ClassUser cu = new ClassUser();

            cu = sd.getClassUserByID(classUserId);
            List<ClassUser> listClassId = dao.getAllClassUser();
            List<User> listUserId = udao.UserList();
            List<Team> listTeamId = dao.getAllTeam();

            request.setAttribute("cu", cu);
            request.setAttribute("listC", listClassId);
            request.setAttribute("listUserId", listUserId);
            request.setAttribute("listT", listTeamId);

            request.getRequestDispatcher("ClassUserDetails.jsp").forward(request, response);

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
