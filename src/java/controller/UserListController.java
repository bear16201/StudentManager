/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author NamOK
 */
public class UserListController extends HttpServlet {

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

            //..........action
            UserDao dao = new UserDao();
            List<User> list = new ArrayList();
            String action = request.getParameter("action");
            //.....Search by role , status , name , mobile , email 
            if (action != null) {
                if ((action.equals("search"))) {
                    String status, str;
                    int role = 0;
                    //.....get status , role , string (name , mobile , email ) 
                    role = Integer.parseInt(request.getParameter("role"));
                    status = request.getParameter("status");
                    str = request.getParameter("str");
                    try {
                        list = dao.getUserbyString(role, status, str);
                    } catch (Exception e) {
                        System.out.println("e");
                    }

                }
                if ((action.equals("change"))) {
                    UserDao d = new UserDao();
                    String id = request.getParameter("id");
                    try {
                        d.changeStatus(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllUser();
                    System.out.println(list);
                }
            } else {
                list = dao.getAllUser();
            }
            //...........................
            int page = 1;
            String page_size = request.getParameter("page");
            if (page_size != null) {
                page = Integer.parseInt(page_size);
            }
            int size = list.size() / 10;
            if (list.size() > (10 * size)) {
                size += 1;
            }
            int end;
            if (page * 10 > list.size()) {
                end = list.size();
            } else {
                end = page * 10;
            }
            //.subList((page-1)*10, page*10)
            request.setAttribute("size", size);
            request.setAttribute("list", list.subList((page - 1) * 10, end));
            request.getRequestDispatcher("UserList.jsp").forward(request, response);

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
