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
import model.SubjectSetting;

/**
 *
 * @author PC PHUC
 */
public class SubjectSettingListController extends HttpServlet {

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
           String action = request.getParameter("action");
            AdminDao dao = new AdminDao();
            String indexPage = request.getParameter("index");
            String txtSearch = request.getParameter("txt");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);

            int count = dao.getTotalSetting();
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }

            List<SubjectSetting> list = dao.getAllSubjectSetting(index);

//            if (action != null) {
// 
//                if ((action.equals("change"))) {
//                    String id = request.getParameter("id");
//                    try {
//                        dao.changeStatus(id);
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    }
//                    list = dao.getAllSubjectSetting(index);
//                    System.out.println(list);
//                }
//            } else {
//                list = dao.getAllSubjectSetting(index);
//            }
            
            request.setAttribute("endP", endPage);
            request.setAttribute("list", list);
            request.getRequestDispatcher("SubjectSettingList.jsp").forward(request, response);
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
