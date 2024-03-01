/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubjectDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Subject;
import model.User;

/**
 *
 * @author My PC
 */
@WebServlet(name = "SortSubject", urlPatterns = {"/sortsubject"})
public class SortSubject extends HttpServlet {

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
            SubjectDao dao = new SubjectDao();
            String indexPage = request.getParameter("index");
            String txtSearch = request.getParameter("txt");
            HttpSession session = request.getSession();
            User u = (User) session.getAttribute("acc");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = dao.getTotalSubject();
            int endPage = count / 7;
            if (count % 7 != 0) {
                endPage++;
            }

            List<Subject> list = dao.getAllSubject(index);

            if (action != null) {           
                if ((action.equals("sortbyidasc"))) {
                    list = dao.getSortSubjectByIDASC(index);
                }
                 if ((action.equals("sortbyiddesc"))) {
                    list = dao.getSortSubjectByIDDESC(index);
                }
                if ((action.equals("sortbycode"))) {
                    list = dao.getSortSubjectByCode(index);
                }
                if ((action.equals("sortbyname"))) {
                    list = dao.getSortSubjectByName(index);
                }
                if ((action.equals("sortbystatus1"))) {
                    list = dao.getSortSubjectByStatus1(index);
                }
                if ((action.equals("sortbystatus0"))) {
                    list = dao.getSortSubjectByStatus0(index);
                }
                if ((action.equals("sortbyauthor"))) {
                    list = dao.getSortSubjectByAuthor(index, u.getUserID());
                }               
                request.setAttribute("endP", endPage);
                request.setAttribute("list", list);
                request.getRequestDispatcher("SubjectList.jsp").forward(request, response);
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
