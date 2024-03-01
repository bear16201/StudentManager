/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDao;
import dao.FunctionDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Criteria;
import model.Feature;
import model.Function;
import model.Iteration;
import model.Subject;
import model.Team;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author PC PHUC
 */
public class FunctionListController extends HttpServlet {

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
            FunctionDao dao = new FunctionDao();
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);

            int count = dao.getTotalFunction();
            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }

            List<Function> list = dao.getAllFunction(index);
            List<Function> list1 = dao.getAllFunction1();

            if (action != null) {
                if ((action.equals("search"))) {
                    String status, teamName, featureName, role, complex, str;
                    status = request.getParameter("status");
                    featureName = request.getParameter("featureName");
                    teamName = request.getParameter("teamName");
                    role = request.getParameter("role");
                    complex = request.getParameter("complex");
                    if (status != null && !status.isEmpty()) {
                        int num = Integer.parseInt(status);
                        str = " and function_tb.status =" + num;
                        request.setAttribute("status", " Status");
                        try {
                            list = dao.getFuctbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (teamName != null && !teamName.isEmpty()) {
                        str = "  and function_tb.team_name = \'" + teamName + "\'";
                        request.setAttribute("teamName", " Team");
                        try {
                            list = dao.getFuctbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (featureName != null && !featureName.isEmpty()) {
                        str = "  and function_tb.feature_name = \'" + featureName + "\'";
                        request.setAttribute("featureName", " Feature");
                        try {
                            list = dao.getFuctbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (role != null && !role.isEmpty()) {
                        int num = Integer.parseInt(role);
                        str = " and function_tb.access_role =" + num;
                        request.setAttribute("role", " Role");
                        try {
                            list = dao.getFuctbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else if (complex != null && !complex.isEmpty()) {
                        int num = Integer.parseInt(complex);
                        str = " and function_tb.complexity_id =" + num;
                        request.setAttribute("complex", " Complex");
                        try {
                            list = dao.getFuctbyString(str);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    } else {
                        list = dao.getAllFunction(index);
                    }
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                } else if ((action.equals("import"))) {
                    ServletContext servletContext = this.getServletConfig().getServletContext();
                    File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//        ServletConfig sc = getServletConfig();
                    String path = servletContext.getRealPath("/Excel");

                    Part filePart = request.getPart("file");

                    String fileName = filePart.getSubmittedFileName();
//                    String a = fileName.substring(fileName.length() - 4, fileName.length());

//                        String haha = "đỉk cuj maky";
//                        list = dao.getAllIssue();
//
//                        request.setAttribute("j", haha);
//                        request.getRequestDispatcher("IssueList.jsp").forward(request, response);
                    InputStream is = filePart.getInputStream();

                    Files.copy(is, Paths.get(path + "/" + fileName),
                            StandardCopyOption.REPLACE_EXISTING);
                    File file = new File(path + "/" + fileName);
                    try {
                        FileInputStream inp = new FileInputStream(file);
                        XSSFWorkbook wb = new XSSFWorkbook(inp);
//                        request.setAttribute("a", path);
                        Sheet sheet = wb.getSheetAt(0);
//                         FormulaEvaluator formula =wb.getCreationHelper().createFormulaEvaluator();
                        for (int j = 1; j <= sheet.getLastRowNum(); j++) {

                            Row row = sheet.getRow(j);

                            int function_id = (int) row.getCell(0).getNumericCellValue();
                            String function_name = row.getCell(1).getStringCellValue();
                            String team_name = row.getCell(3).getStringCellValue();
                            String feature_name = row.getCell(5).getStringCellValue();
                            int access_role = (int) row.getCell(6).getNumericCellValue();
                            String description = row.getCell(11).getStringCellValue();
                            int complexity_id = (int) row.getCell(7).getNumericCellValue();
                            String owner_name = row.getCell(8).getStringCellValue();
                            int priority = (int) row.getCell(9).getNumericCellValue();
                            int status = (int) row.getCell(10).getNumericCellValue();

//                            System.out.println(assignee_id);
                            dao.addFunction1(function_id, team_name, function_name, feature_name, priority, access_role, description, complexity_id, owner_name, status);

                        }
//                            int rowIndex = 0;
//                        writeHeader(sheet, rowIndex);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    response.sendRedirect("functionlist");
                } else if ((action.equals("sortIDasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortFunctIDasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                } else if ((action.equals("sortIDdesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortFunctIDdesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortNameasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortNameasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortNamedesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortNamedesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortTeamasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortTeamasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortTeamdesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortTeamdesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortFeaasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortFeaNameasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortFeadesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortFeaNamedesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }
                else if ((action.equals("sortRoleasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortRoleasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortRoledesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortRoledesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortComplexasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortComplexasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortComplexdesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortComplexdesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortOwnerasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortOwnerNameasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortOwnerdesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortOwnerNamedesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortPriorityasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortPriorityasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortPrioritydesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortPrioritydesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortStatusasc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortStatusasc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }else if ((action.equals("sortStatusdesc"))) {

                    try {
                        List<Team> listT = dao.getAllTeamName();
                        List<Feature> listF = dao.getAllFeatureName();
                        List<Function> s = dao.sortStatusdesc(index);

                        request.setAttribute("status", " Status");
                        request.setAttribute("teamName", " Team");
                        request.setAttribute("featureName", " Feature");
                        request.setAttribute("role", " Role");
                        request.setAttribute("complex", " Complex");

                        request.setAttribute("endP", endPage);
                        request.setAttribute("list", s);
                        request.setAttribute("listT", listT);
                        request.setAttribute("listF", listF);

                        request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    list = dao.getAllFunction(index);
                    System.out.println(list);
                    request.setAttribute("status", " Status");
                    request.setAttribute("teamName", " Team");
                    request.setAttribute("featureName", " Feature");
                    request.setAttribute("role", " Role");
                    request.setAttribute("complex", " Complex");
                }

            } else {
                list = dao.getAllFunction(index);
            }

            List<Team> listT = dao.getAllTeamName();
            List<Feature> listF = dao.getAllFeatureName();

            request.setAttribute("status", " Status");
            request.setAttribute("teamName", " Team");
            request.setAttribute("featureName", " Feature");
            request.setAttribute("role", " Role");
            request.setAttribute("complex", " Complex");

            request.setAttribute("endP", endPage);
            request.setAttribute("list", list);
            request.setAttribute("listT", listT);
            request.setAttribute("listF", listF);
            request.getRequestDispatcher("FunctionList.jsp").forward(request, response);
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
