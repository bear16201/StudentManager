/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author 84337
 */
@MultipartConfig
@WebServlet(name = "EditAvatar", urlPatterns = {"/editavatar"})
public class EditAvatar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String filename=null;
        if (ServletFileUpload.isMultipartContent(request)) {

            try {
                ServletContext servletContext = this.getServletConfig().getServletContext();
                File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setRepository(repository);
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                         filename = item.getName();
                        String storePath = servletContext.getRealPath("/avatar");
                        Path path = Paths.get(filename);
                        File uploadFile = new File(storePath + "/" + path.getFileName());
                        item.write(uploadFile);
                        String name = new File(item.getName()).getName();
                        item.write(new File(storePath + File.separator + name));
                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
//                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }
                Part part = request.getPart("file");

        UserDao dao = new UserDao();
        HttpSession session = request.getSession();
        String avatar = part.getSubmittedFileName();
        User u = (User) session.getAttribute("acc");
        dao.EditAvater(avatar, u.getEmail());
//        response.sendRedirect("profile");
        request.getRequestDispatcher("loadprofileedit").forward(request, response);
    }
}