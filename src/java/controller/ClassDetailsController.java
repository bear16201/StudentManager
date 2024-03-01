/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClassDao;
import dao.SubjectDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Subject;
import model.User;
import model.Class;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ClassDetailsController", urlPatterns = {"/classDetails"})
public class ClassDetailsController extends HttpServlet {

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
            String classId = request.getParameter("class_id");
            ClassDao dao = new ClassDao();
            UserDao daoUser = new UserDao();
            SubjectDao daoSub = new SubjectDao();

            model.Class listClass = dao.getClassByID(classId);
            List<User> listUser = daoUser.getAllUser();
            List<Subject> listSub = daoSub.getAllSubject();

            request.setAttribute("listUser", listUser);
            request.setAttribute("listSub", listSub);
            request.setAttribute("listClass", listClass);
            request.getRequestDispatcher("./ClassDetail.jsp").forward(request, response);
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
        String classId = request.getParameter("class_id");
        String class_code = request.getParameter("class_code");
        String trainer_id = request.getParameter("trainer_id");
        String subject_id = request.getParameter("subject_id");
        String class_year = request.getParameter("class_year");
        String class_term = request.getParameter("class_term");
        String block5_class = request.getParameter("block5_class");
        String status = request.getParameter("status");
        int warring = 0;
        ClassDao dao = new ClassDao();
        UserDao daoUser = new UserDao();
        SubjectDao daoSub = new SubjectDao();
        String regex = "^[A-Za-z0-9]{1,9}+$";

        if (class_code == null || class_code.equals("")) {
            request.setAttribute("messWarring", "!! Class Code not null !!");
            warring = 1;
        }
        if (!class_code.matches(regex)) {
            request.setAttribute("messWarring", "!! Class Code not have special characters [@,!,#,$,..] !!");
            warring = 1;
        }
        if (class_code.length() > 6) {
            request.setAttribute("messWarring", "!! Class Code not more than 6 !!");
            warring = 1;
        }
        
        if (trainer_id == null || trainer_id.equals("")) {
            request.setAttribute("messWarring", "!! Trainer ID not null !!");
            warring = 1;
        }
        if (trainer_id.length() > 8) {
            request.setAttribute("messWarring", "!! Trainer ID not more than 8 !!");
            warring = 1;
        }

        if (subject_id == null || subject_id.equals("")) {
            request.setAttribute("messWarring", "!! Subject ID not null !!");
            warring = 1;
        }
        if (subject_id.length() > 6) {
            request.setAttribute("messWarring", "!! Subject ID not more than 6 !!");
            warring = 1;
        }

        if (class_year == null || class_year.equals("")) {
            request.setAttribute("messWarring", "!! Year not null !!");
            warring = 1;
        }
        if (!class_year.matches(regex)) {
            request.setAttribute("messWarring", "!! Year not have special characters [@,!,#,$,..] !!");
            warring = 1;
        }
        if (class_year.length() > 7) {
            request.setAttribute("messWarring", "!! Year not more than 7 !!");
            warring = 1;
        }

        if (class_term == null || class_term.equals("")) {
            request.setAttribute("messWarring", "!! Class Term not null !!");
            warring = 1;
        }
        if (!class_year.matches(regex)) {
            request.setAttribute("messWarring", "!! Class Term not have special characters [@,!,#,$,..] !!");
            warring = 1;
        }
        if (class_term.length() > 9) {
            request.setAttribute("messWarring", "!! Class Term not more than 9 !!");
            warring = 1;
        }

        if (warring == 1) {
            Class listClass = dao.getClassByID(classId);
            List<User> listUser = daoUser.getAllUser();
            List<Subject> listSub = daoSub.getAllSubject();

            request.setAttribute("listUser", listUser);
            request.setAttribute("listSub", listSub);
            request.setAttribute("listClass", listClass);
            //run 
            RequestDispatcher dispath
                    = request.getRequestDispatcher("./ClassDetail.jsp");
            dispath.forward(request, response);

        } else {
            dao.updatetClass(classId, class_code, trainer_id, subject_id, class_year, class_term, block5_class, status);
            response.sendRedirect("classList");
        }

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
