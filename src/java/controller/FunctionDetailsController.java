/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FunctionDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feature;
import model.Function;
import model.Team;
import model.User;

/**
 *
 * @author PC PHUC
 */
public class FunctionDetailsController extends HttpServlet {

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
            out.println("<title>Servlet FunctionDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FunctionDetailsController at " + request.getContextPath() + "</h1>");
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
        int FuncID = Integer.parseInt(request.getParameter("FuncID"));
        FunctionDao dao = new FunctionDao();
        List<Team> listT = dao.getAllTeamName();
        List<Feature> listF = dao.getAllFeatureName();
        List<Function> listR = dao.getAllRole();
        List<User> listU = dao.getAllOwner();
        try {
            if (FuncID != 0) {
                Function f = dao.getFunctionByID(FuncID);
                request.setAttribute("d", f);
                request.setAttribute("t", listT);
                request.setAttribute("f", listF);
                request.setAttribute("r", listR);
                request.setAttribute("u", listU);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("./FunctionDetails.jsp").forward(request, response);
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
        int FuncID = Integer.parseInt(request.getParameter("FuncID"));
        FunctionDao dao = new FunctionDao();
        Function f = new Function();
        List<Team> listT = dao.getAllTeamName();
        List<Feature> listF = dao.getAllFeatureName();
        List<Function> listR = dao.getAllRole();
        List<User> listU = dao.getAllOwner();
        try {
            request.setAttribute("t", listT);
            request.setAttribute("f", listF);
            request.setAttribute("r", listR);
            request.setAttribute("u", listU);
            f = dao.getFunctionByID(FuncID);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        int warring = 0;
        String regex = "^[A-Za-z0-9\\s]{5,50}+$";
        String regexInt = "^[0-9]+$";
        String function_name = request.getParameter("function_name");
        f.getFunction_name();
        String team_name = request.getParameter("team_name");
        f.getTeam_name();
        String feature_name = request.getParameter("feature_name");
        f.getFeature_name();
        String access_role = request.getParameter("access_role");
        f.getFeature_name();
        String owner_name = request.getParameter("owner_name");
        f.getOwner_name();
        String complex = request.getParameter("complex");
        f.getComplexity_id();
        String priority = request.getParameter("priority");
        f.getPriority();
        String status = request.getParameter("status");
        f.getStatus();
        String description = request.getParameter("description");
        f.getDescription();
        try {
            if (function_name == null || function_name.equals("")) {
                request.setAttribute("mess", "!! Function Name not null !!");
                warring = 1;
            } else if (priority == null || priority.equals("")) {
                request.setAttribute("mess", "!! Priority not null !!");
                warring = 1;
            } else if (!function_name.matches(regex)) {
                request.setAttribute("mess", "!! Function Name must 5-50 character and special characters !!");
                warring = 1;
            } else if (!priority.matches(regexInt)) {
                request.setAttribute("mess", "!! Priority must Integer Number !!");
                warring = 1;
            }
            if (warring == 1) {
                request.setAttribute("d", f);
                request.getRequestDispatcher("./FunctionDetails.jsp").forward(request, response);
            } else {
                dao.updatetFunction(team_name, function_name, feature_name, priority, access_role, description, complex, owner_name, status, FuncID);
                request.setAttribute("mess", "Update succesfull!!");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
//        String message = request.getParameter("message");
//        if (message == null || message.length() == 0) {
//            dao.updatetFunction(team_name, function_name, feature_name, priority, access_role, description, complex, owner_name, status, FuncID);
//            
//        }
        response.sendRedirect("functiondetails?FuncID=" + FuncID);
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
