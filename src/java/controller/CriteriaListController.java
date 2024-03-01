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
import model.Criteria;
import model.Iteration;
import model.Subject;

/**
 *
 * @author PC PHUC
 */
public class CriteriaListController extends HttpServlet {

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
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);

            int count = dao.getTotalCriteria();
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }

            List<Criteria> list = dao.getAllCriteria(index);

            if (action != null) {
                if ((action.equals("search"))) {
                    String status, itername, sbname, str;
                    status = request.getParameter("status");
                    itername = request.getParameter("itername");
                    sbname = request.getParameter("sbname");
                    if (status != null && !status.isEmpty()) {
                        int num = Integer.parseInt(status);
                        str = " and evaluation_criteria.status =" + num;
                        request.setAttribute("status", "All Status");
                        try {
                            list = dao.getCritbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (itername != null && !itername.isEmpty()) {
                        str = "  and evaluation_criteria.iteration_name = \'" + itername + "\'";
                        request.setAttribute("itername", "All Iteration Name");
                        try {
                            list = dao.getCritbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (sbname != null && !sbname.isEmpty()) {
                        str = "  and evaluation_criteria.subject_name = \'" + sbname + "\'";
                        request.setAttribute("sbname", "All Subject Name");
                        try {
                            list = dao.getCritbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        list = dao.getAllCriteria(index);
                    }
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("change"))) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    try {
                        dao.changeStatusCriteria(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortIDasc"))) {

                    try {
                        List<Criteria> s = dao.sortCriteriaIDasc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortIDdesc"))) {

                    try {
                        List<Criteria> s = dao.sortCriteriaIDdesc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortIterNameasc"))) {

                    try {
                        List<Criteria> s = dao.sortIterNameasc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortIterNamedesc"))) {

                    try {
                        List<Criteria> s = dao.sortIterNamedesc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortWeightasc"))) {

                    try {
                        List<Criteria> s = dao.sortWeightasc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortWeightdesc"))) {

                    try {
                        List<Criteria> s = dao.sortWeightdesc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortTeamasc"))) {

                    try {
                        List<Criteria> s = dao.sortTeamasc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortTeamdesc"))) {

                    try {
                        List<Criteria> s = dao.sortTeamdesc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortLocasc"))) {

                    try {
                        List<Criteria> s = dao.sortLocasc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortLocdesc"))) {

                    try {
                        List<Criteria> s = dao.sortLocdesc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortStatusasc"))) {

                    try {
                        List<Criteria> s = dao.sortStatusasc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                } else if ((action.equals("sortStatusdesc"))) {

                    try {
                        List<Criteria> s = dao.sortStatusdesc(index);
                        List<Iteration> listI = dao.getAllIter();
                        List<Subject> listS = dao.getAllSubjectName();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("itername", "All Iteration Name");
                        request.setAttribute("sbname", "All Subject Name");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listI", listI);
                        request.setAttribute("listS", listS);
                        request.setAttribute("list", s);
                        request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllCriteria(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("itername", "All Iteration Name");
                    request.setAttribute("sbname", "All Subject Name");
                }
            } else {
                list = dao.getAllCriteria(index);
            }

            List<Iteration> listI = dao.getAllIter();
            List<Subject> listS = dao.getAllSubjectName();

            request.setAttribute("status", "All Status");
            request.setAttribute("itername", "All Iteration Name");
            request.setAttribute("sbname", "All Subject Name");

            request.setAttribute("endP", endPage);
            request.setAttribute("list", list);
            request.setAttribute("listI", listI);
            request.setAttribute("listS", listS);
            request.getRequestDispatcher("CriteriaList.jsp").forward(request, response);
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
