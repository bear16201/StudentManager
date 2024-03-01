/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Criteria;
import model.Class;
import model.Iteration;
import model.Team;

/**
 *
 * @author PC PHUC
 */
public class TeamDetailsController extends HttpServlet {

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
            out.println("<title>Servlet TeamDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeamDetailsController at " + request.getContextPath() + "</h1>");
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
        int teamID = Integer.parseInt(request.getParameter("team_id"));
        AdminDao dao = new AdminDao();
        List<Class> list = dao.getAllClassCode();
        try {
            if (teamID != 0) {
                Team t = dao.getTeamByID(teamID);
                request.setAttribute("d", t);
                request.setAttribute("l", list);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("./TeamDetails.jsp").forward(request, response);
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
        int teamID = Integer.parseInt(request.getParameter("team_id"));
        AdminDao dao = new AdminDao();
        Team t = new Team();
        List<Class> list = dao.getAllClassCode();
        try {
            request.setAttribute("l", list);
            t = dao.getTeamByID(teamID);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        int warring = 0;
        String regex = "^[A-Za-z0-9\\s]{5,50}+$";
        String regex1 = "^[A-Za-z0-9]{4,10}+$";
        String name = request.getParameter("name");
        t.getName();
        String class_code = request.getParameter("class_code");
        t.getClass_code();
        String topic_code = request.getParameter("topic_code");
        t.getTopic_code();
        String topic_name = request.getParameter("topic_name");
        t.getTopic_name();
        String gitlab_url = request.getParameter("gitlab_url");
        t.getGitlab_url();
        String status = request.getParameter("status");
        t.getStatus();
        try {
            if (topic_code == null || topic_code.equals("")) {
                request.setAttribute("mess", "!! Topic Code not null !!");
                warring = 1;
            } else if (topic_name == null || topic_name.equals("")) {
                request.setAttribute("mess", "!! Topic Name not null !!");
                warring = 1;
            } else if (gitlab_url == null || gitlab_url.equals("")) {
                request.setAttribute("mess", "!! Url not null !!");
                warring = 1;
            } else if (name == null || name.equals("")) {
                request.setAttribute("mess", "!! Name not null !!");
                warring = 1;
            } else if (!topic_name.matches(regex)) {
                request.setAttribute("mess", "!! Topic Name must 5-50 character and special characters !!");
                warring = 1;
            } else if (!topic_code.matches(regex1)) {
                request.setAttribute("mess", "!! Topic Code must 4-10 character !!");
                warring = 1;
            }else if (!name.matches(regex)) {
                request.setAttribute("mess", "!! Name must 5-50 character and special characters !!");
                warring = 1;
            }
            if (warring == 1) {
                request.setAttribute("d", t);
                request.getRequestDispatcher("./TeamDetails.jsp").forward(request, response);
            } else {
                dao.updatetTeam(class_code, topic_code, name, topic_name, gitlab_url, status, teamID);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        response.sendRedirect("teamdetails?team_id=" + teamID);
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
