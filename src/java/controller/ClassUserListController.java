/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AdminDao;
import dao.SubjectDao;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClassUser;
import model.SubjectSetting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author 84337
 */
@WebServlet(name = "ClassUserListController", urlPatterns = {"/classuserlist"})
public class ClassUserListController extends HttpServlet {

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
            SubjectDao sd = new SubjectDao();
            String txtSearch = request.getParameter("search");
            ClassUser cu = new ClassUser();
            String id = request.getParameter("id");
            List<ClassUser> list = new ArrayList<>();
            if (txtSearch == null || txtSearch.equals("")) {
                list = dao.getAllClassUser();
            } else {
                list = sd.searchClassUser(txtSearch);
            }

            if (action != null) {

                if ((action.equals("change"))) {

                    try {
                        sd.changeStatusClassUser(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllClassUser();
                    System.out.println(list);
                }
//                if ((action.equals("sortbyid"))) {
//                    list = sd.SortSubjectSettingByID();
//                }
//                if ((action.equals("sortbytypeid"))) {
//                    list = sd.SortSubjectSettingByTypeId();
//                }
//                if ((action.equals("sortbytitle"))) {
//                    list = sd.SortSubjectSettingByTitle();
//                }
//                if ((action.equals("sortbyorder"))) {
//                    list = sd.SortSubjectSettingByOrder();
//                }
//                if ((action.equals("sortbyvalue"))) {
//                    list = sd.SortSubjectSettingByValue();
//                }
                if ((action.equals("status1"))) {
                    list = sd.ClassUserStatus1();
                }
                if ((action.equals("status0"))) {
                    list = sd.ClassUserStatus0();

                }

//                    response.setContentType("application/vnd.ms-excel");
//                    
            }
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
            request.setAttribute("txtSearch", txtSearch);
            request.setAttribute("listT", list.subList((page - 1) * 10, end));
            request.setAttribute("listCU", cu);
            request.getRequestDispatcher("ClassUserList.jsp").forward(request, response);
        }

    }

    public static void main(String[] args) {
        AdminDao dao = new AdminDao();
        ClassUser cu = new ClassUser();
        SubjectDao sd = new SubjectDao();
        cu = sd.getClassUserByID("4");
        System.out.println(cu);
//
//        List<ClassUser> list = dao.getAllClassUser();
//        for (ClassUser o : list) {
//            System.out.println(o);
//        }
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
