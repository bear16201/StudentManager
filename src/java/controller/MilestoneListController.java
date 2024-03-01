/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MilestoneDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Iteration;
import model.Milestone;

/**
 *
 * @author PC PHUC
 */
@WebServlet(name = "MilestoneListController", urlPatterns = {"/milestone"})
public class MilestoneListController extends HttpServlet {

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
            MilestoneDao dao = new MilestoneDao();
            List<Milestone> list = new ArrayList();

            String action = request.getParameter("action");
            //..........action          
            if (action != null) {
                if ((action.equals("search"))) {
                    String status, from, to, classid ,  iterid;
                    String str ="" ; 
                    int role = 0;
                    from = request.getParameter("from");
                    to = request.getParameter("to");
                    classid = request.getParameter("classid");
                    iterid = request.getParameter("iterid");
                    status = request.getParameter("status");
                    if (from != null && !from.isEmpty() && to != null && !to.isEmpty()) {
                        try {
                            list = dao.SearchbyDate(from, to);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (classid != null && !classid.isEmpty()) {
                        str = "  and milestone.class_id = \'" + classid +"\'";
                        try {
                            list = dao.getMilestonebyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (iterid != null && !iterid.isEmpty() ) {
                        int num =  Integer.parseInt(iterid)  ;
                         str = " and milestone.iteration_id =" + num;
                        try {
                              list = dao.getMilestonebyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else  if (status != null && !status.isEmpty() ) {
                        int num =  Integer.parseInt(status)  ;
                         str = " and milestone.status =" + num;
                        try {
                              list = dao.getMilestonebyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        list = dao.getAllMilestone();
                    }
                    request.setAttribute("byClass", "All Class");
                    request.setAttribute("byIter", "All Iteration");
                    try {
                    } catch (Exception e) {
                        System.out.println("e");
                    }

                }
                if ((action.equals("change"))) {
                    String id = request.getParameter("id");
                    try {
                        dao.changeStatus(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllMilestone();
                    request.setAttribute("byClass", "All Class");
                    request.setAttribute("byIter", "All Iteration");
                }
                if ((action.equals("sort"))) {
                    String table = request.getParameter("table");
                    int  inco = Integer.parseInt((String ) request.getParameter("inco"));
                    String by ="" ;
                    if (inco == 1 ) by = " asc " ; else by =" desc " ;
                    String str = table + by ;
                    list = dao.getAllMilestoneSort(str);
                }
            } else {
                list = dao.getAllMilestone();
//                for (Milestone i : list) {
//                    System.out.println(i.getClass_id());
//                }

            }
//...............................
//            list = dao.getAllMilestone();
//            for(Milestone i : list)
//                    System.out.println(i.getClass_id());
            //..................................
            request.setAttribute("byClass", "All Class");
            List<model.Class> listC = new ArrayList();
            listC = dao.getAllClass();
            request.setAttribute("listC", listC);
            //..................................
            List<Iteration> listI = new ArrayList();
            request.setAttribute("byIter", "All Iteration");
            listI = dao.getAllIter();
            request.setAttribute("listI", listI);
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
            request.getRequestDispatcher("MilestoneList.jsp").forward(request, response);
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
