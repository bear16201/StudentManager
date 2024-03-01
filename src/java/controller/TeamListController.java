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
import model.Team;
import model.Class;

/**
 *
 * @author PC PHUC
 */
public class TeamListController extends HttpServlet {

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

            int count = dao.getTotalTeam();
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }

            List<Team> list = dao.getAllTeam(index);

            if (action != null) {
                if ((action.equals("search"))) {
                    String status, topic, classCode, str;
                    status = request.getParameter("status");
                    topic = request.getParameter("topic");
                    classCode = request.getParameter("classCode");
                    if (status != null && !status.isEmpty()) {
                        int num = Integer.parseInt(status);
                        str = " and team.status =" + num;
                        request.setAttribute("status", "All Status");
                        try {
                            list = dao.getTeambyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (topic != null && !topic.isEmpty()) {
                        str = "  and team.topic_name = \'" + topic + "\'";
                        request.setAttribute("topic", "All Topic Name");
                        try {
                            list = dao.getTeambyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (classCode != null && !classCode.isEmpty()) {
                        str = "  and team.class_code = \'" + classCode + "\'";
                        request.setAttribute("classCode", "All Class Code");
                        try {
                            list = dao.getTeambyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        list = dao.getAllTeam(index);
                    }
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                }
                if ((action.equals("change"))) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    try {
                        dao.changeStatusTeam(id);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortIDasc"))) {

                    try {
                        List<Team> s = dao.sortTeamIDasc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortIDdesc"))) {

                    try {
                        List<Team> s = dao.sortTeamIDdesc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortClassasc"))) {

                    try {
                        List<Team> s = dao.sortClassasc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortClassdesc"))) {

                    try {
                        List<Team> s = dao.sortClassdesc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortTopicCodeasc"))) {

                    try {
                        List<Team> s = dao.sortTopicCodeasc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortTopicCodedesc"))) {

                    try {
                        List<Team> s = dao.sortTopicCodedesc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortTopicNameasc"))) {

                    try {
                        List<Team> s = dao.sortTopicNameasc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortTopicNamedesc"))) {

                    try {
                        List<Team> s = dao.sortTopicNamedesc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortStatusdesc"))) {

                    try {
                        List<Team> s = dao.sortStatusTeamdesc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                } else if ((action.equals("sortStatusasc"))) {

                    try {
                        List<Team> s = dao.sortStatusTeamasc(index);
                        List<Team> listT = dao.getAllTopic();
                        List<Class> listC = dao.getAllClassCode();

                        request.setAttribute("status", "All Status");
                        request.setAttribute("topic", "All Topic Name");
                        request.setAttribute("classCode", "All Class Code");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", list);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listC", listC);
                        request.setAttribute("list", s);

                        request.getRequestDispatcher("TeamList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllTeam(index);
                    System.out.println(list);
                    request.setAttribute("status", "All Status");
                    request.setAttribute("topic", "All Topic Name");
                    request.setAttribute("classCode", "All Class Code");
                }
            } else {
                list = dao.getAllTeam(index);
            }

            List<Team> listT = dao.getAllTopic();
            List<Class> listC = dao.getAllClassCode();

            request.setAttribute("status", "All Status");
            request.setAttribute("topic", "All Topic Name");
            request.setAttribute("classCode", "All Class Code");

            request.setAttribute("endP", endPage);
            request.setAttribute("list", list);
            request.setAttribute("listT", listT);
            request.setAttribute("listC", listC);
            request.getRequestDispatcher("TeamList.jsp").forward(request, response);
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
