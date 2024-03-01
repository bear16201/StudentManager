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
import model.Subject;

/**
 *
 * @author My PC
 */
@WebServlet(name = "SubjectAdd", urlPatterns = {"/subjectadd"})
public class SubjectAdd extends HttpServlet {

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
            String id = request.getParameter("subject_id");
            String code = request.getParameter("subject_code");
            String name = request.getParameter("subject_name");
            String author = request.getParameter("subject_author");
            String status = request.getParameter("subject_status");           
            SubjectDao dao = new SubjectDao();
            Subject p = dao.getSubjectByID(id);
            if(p != null){
                request.setAttribute("id",id);
                request.setAttribute("code",code);
                request.setAttribute("name",name);
                request.setAttribute("mess","Duplicate ID cannot add a new subject!");
                request.getRequestDispatcher("SubjectAdd.jsp").forward(request, response);
            }
            else{  
                p = new Subject(id, code, name, author, status);    
                request.setAttribute("mess","Add a new subject successfully!");
                request.getRequestDispatcher("SubjectAdd.jsp").forward(request, response);
            }           
            try {
                dao.AddSubject(p);              
            } catch (Exception ex) {               
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
