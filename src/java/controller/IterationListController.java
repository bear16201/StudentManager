/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Iteration;
import model.Subject;

/**
 *
 * @author NamOK
 */
public class IterationListController extends HttpServlet {

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
            AdminDao dao = new AdminDao();
            List<Iteration> list = new ArrayList();
            List<Subject> listS = new ArrayList();

            String action = request.getParameter("action");
            //...........................Action
            if (action != null) {
                if ((action.equals("search"))) {
                    String status, str;
                    int role = 0;
                    //.....get status , role , string (name , mobile , email ) 
                    str = request.getParameter("searchby");
                    if ((str != null) && !str.isEmpty()) {
                        str = " and iteration_name = \"" + str + "\"";
                        request.setAttribute("fromsb", "All Subject");

                    } else {
                        str = request.getParameter("sbid");

                        if (str != null && !str.isEmpty()) {
                            request.setAttribute("fromsb", str);
                            str = " and  subject_id = \"" + str + "\"";

                        } else {
                            str = "";
                            request.setAttribute("fromsb", "All Subject");
                        }

                    }
                    try {
                        list = dao.getIterbyString(str);
                    } catch (Exception e) {
                        System.out.println("e");
                    }

                }
                if ((action.equals("change"))) {

                    int id = Integer.parseInt(request.getParameter("id"));
                    try {
                        dao.changeStatusIter(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllIter();
                    request.setAttribute("fromsb", "All Subject");

                }
            } else {
                list = dao.getAllIter();
                // fromsb
                request.setAttribute("fromsb", "All Subject");

            }
            //...........................
            listS = dao.getAllSubject();
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
            request.setAttribute("listS", listS);
            request.getRequestDispatcher("IterationList.jsp").forward(request, response);
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
