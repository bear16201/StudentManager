/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubjectDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Subject;

/**
 *
 * @author My PC
 */
@WebServlet(name = "SubjectController", urlPatterns = {"/subjectlist"})
public class SubjectListController extends HttpServlet {

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
            //HttpSession session = request.getSession();
            String action = request.getParameter("action");
            SubjectDao dao = new SubjectDao();
            String indexPage = request.getParameter("index");
            List<Subject> list = new ArrayList();
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = dao.getTotalSubject();
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
            if (action != null) {
                if ((action.equals("change"))) {
                    SubjectDao d = new SubjectDao();
                    String id = request.getParameter("id");
                    try {
                        d.changeStatus(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllSubject(index);
                    System.out.println(list);
                }
            } else {
                list = dao.getAllSubject(index);
            }
            request.setAttribute("endP", endPage);
            request.setAttribute("list", list);
            request.getRequestDispatcher("SubjectList.jsp").forward(request, response);
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
