/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClassDao;
import dao.SubjectDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Class;
import model.Subject;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ClassSortController", urlPatterns = {"/sortClass"})
public class ClassSortController extends HttpServlet {

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
            //get and getDat
            String action = request.getParameter("action");
            ClassDao dao = new ClassDao();
            SubjectDao daoSub = new SubjectDao();
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            int count = dao.getTotalClass();
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
            List<Subject> listSub = daoSub.getAllSubject();
            List<Class> listClass = dao.getAllListClass(index);
            List<Class> listClassNEW = dao.getAllListClass(index);
            if (action != null) {
                if ((action.equals("sortbyid"))) {
                    listClass = dao.getSortClassByID(index);
                }
                if ((action.equals("sortbycode"))) {
                    listClass = dao.getSortClassByCode(index);
                }
                if ((action.equals("sortbyname"))) {
                    listClass = dao.getSortClassByName(index);
                }
                if ((action.equals("sortbySubID"))) {
                    String SubID = request.getParameter("SubID");
                    listClass = dao.getSortClassBySubID(SubID);
                }
                if ((action.equals("sortbyclassYear"))) {
                    String year = request.getParameter("year");
                    listClass = dao.getSortClassByYear(year);
                }
                if ((action.equals("sortbyBlock1"))) {
                    listClass = dao.getSortClassByBlock1(index);
                }
                if ((action.equals("sortbyBlock0"))) {
                    listClass = dao.getSortClassByBlock0(index);
                }
                if ((action.equals("sortbystatus1"))) {
                    listClass = dao.getSortClassByStatus1(index);
                }
                if ((action.equals("sortbystatus0"))) {
                    listClass = dao.getSortClassByStatus0(index);
                }

            }
            //run and post
            request.setAttribute("endP", endPage);
            request.setAttribute("listSub", listSub);
            request.setAttribute("list", listClass);
            request.getRequestDispatcher("ClassList.jsp").forward(request, response);

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
