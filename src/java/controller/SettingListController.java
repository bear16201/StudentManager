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
import javax.servlet.http.HttpSession;
import model.Setting;
import model.Subject;
import model.SubjectSetting;

/**
 *
 * @author PC PHUC
 */
public class SettingListController extends HttpServlet {

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

            List<Setting> list = dao.getAllSetting(index);

            if (action != null) {
//                if ((action.equals("search"))) {
//                    String status, sbname, order, str;
//                    status = request.getParameter("status");
//                    sbname = request.getParameter("sbname");
//                    order = request.getParameter("order");
//                    if (status != null && !status.isEmpty()) {
//                        int num = Integer.parseInt(status);
//                        str = " and setting.status =" + num;
//                        request.setAttribute("status", "All Status");
//                        try {
//                            list = dao.getSettingbyString(str);
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }
//                    } else if (sbname != null && !sbname.isEmpty()) {
//                        str = "  and setting.setting_title = \'" + sbname + "\'";
//                        request.setAttribute("sbname", "All Subject Name");
//                        try {
//                            list = dao.getSettingbyString(str);
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }
//                    } else if (order != null && !order.isEmpty()) {
//                        str = "  and setting.display_order = \'" + order + "\'";
//                        request.setAttribute("order", "All Order");
//                        try {
//                            list = dao.getSettingbyString(str);
//                        } catch (Exception e) {
//                            System.out.println(e);
//                        }
//                    } else {
//                        list = dao.getAllSetting(index);
//                    }
//                    request.setAttribute("status", "All Status");
//                    request.setAttribute("itername", "All Iteration Name");
//                    request.setAttribute("weight", "All Weight");
                 if ((action.equals("change"))) {
                    String id = request.getParameter("id");
                    try {
                        dao.changeStatus(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllSetting(index);
                    System.out.println(list);
                }
            } else {
                list = dao.getAllSetting(index);
            }
            
//            List<Subject> listS = dao.getAllSubject();

            request.setAttribute("endP", endPage);
//            request.setAttribute("sbname", "All Subject Name");
//            request.setAttribute("listS", listS);
            request.setAttribute("list", list);
            
            request.getRequestDispatcher("SettingList.jsp").forward(request, response);
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
