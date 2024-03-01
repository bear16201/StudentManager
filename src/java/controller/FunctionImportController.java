/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FunctionDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PC PHUC
 */
public class FunctionImportController extends HttpServlet {

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

            FunctionDao dao = new FunctionDao();
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
