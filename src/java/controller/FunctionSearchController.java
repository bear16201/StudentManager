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

/**
 *
 * @author PC PHUC
 */
public class FunctionSearchController extends HttpServlet {

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
            String txtSearch = request.getParameter("txt");
            if (txtSearch == null) {
                txtSearch = "";
            }
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);

            FunctionDao dao = new FunctionDao();
            int count = dao.getTotalSearchFunction(txtSearch);
            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            List<Function> list = dao.searchFunction(txtSearch, index);
            List<Team> listT = dao.getAllTeamName();
            List<Feature> listF = dao.getAllFeatureName();

            request.setAttribute("status", " Status");
            request.setAttribute("teamName", " Team");
            request.setAttribute("featureName", " Feature");
            request.setAttribute("role", " Role");
            request.setAttribute("complex", " Complex");

            request.setAttribute("endP", endPage);
            request.setAttribute("list", list);
            request.setAttribute("listT", listT);
            request.setAttribute("text", txtSearch);
            request.setAttribute("listF", listF);
            request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
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
