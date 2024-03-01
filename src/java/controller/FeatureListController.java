/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FeatureDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feature;


/**
 *
 * @author My PC
 */
@WebServlet(name = "FeatureListController", urlPatterns = {"/featurelist"})
public class FeatureListController extends HttpServlet {

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
            String action = request.getParameter("action");
            FeatureDao dao = new FeatureDao();
            String indexPage = request.getParameter("index");
            List<Feature> list = new ArrayList();
            List<Feature> listT = new ArrayList();
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = dao.getTotalFeature();
            int endPage = count / 7;
            if (count % 7 != 0) {
                endPage++;
            }
            if (action != null) {
                if ((action.equals("change"))) {
                    FeatureDao d = new FeatureDao();
                    String id = request.getParameter("id");
                    try {
                        d.changeStatus(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFeature(index);
                    System.out.println(list);
                }
            } else {
                list = dao.getAllFeature(index);
            }
            listT = dao.getTeam();
            request.setAttribute("endP", endPage);
            request.setAttribute("listF", list);
            request.setAttribute("listU", listT);
            request.getRequestDispatcher("FeatureList.jsp").forward(request, response);
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