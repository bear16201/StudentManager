/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author ASUS
 */
public class RessPasswordController extends HttpServlet {

    public static void send(String to, String sub,
            String msg, final String user, final String pass) {
        //create an instance of Properties Class   
        Properties props = new Properties();

        /* Specifies the IP address of your default mail server
     	   for e.g if you are using gmail server as an email sever
           you will pass smtp.gmail.com as value of mail.smtp host. 
           As shown here in the code. 
           Change accordingly, if your email id is not a gmail id
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        //below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object   
           for authentication to Session instance 
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {

            /* Create an instance of MimeMessage, 
 	      it accept MIME types and headers 
             */
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");

            /* Transport class is used to deliver the message to the recipients */
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

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
            String service = request.getParameter("do");

            request.setAttribute("messEmail", "");
            RequestDispatcher dispath
                    = request.getRequestDispatcher("resPassword.jsp");
            //run 
            dispath.forward(request, response);
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
        String service = request.getParameter("do");
        //get data
        UserDao dao = new UserDao();
        String email = request.getParameter("email");

        //check mail ton tai database
        User u = dao.checkMail(email);

        int warning = 0;

        if (u == null) {
            request.setAttribute("messEmail", "Email already exists");
//            request.setAttribute("messEmail", email);
            warning = 1;
        }

        if (email.length() > 50) {
            request.setAttribute("messEmail", "Email not over 50 character");
            warning = 1;
        }
        if (warning == 1) {
            RequestDispatcher dispath
                    = request.getRequestDispatcher("resPassword.jsp");
            dispath.forward(request, response);
        } else {

            String UserID = dao.checkUserID(email);
            String passwordCheck = dao.randomString(8);

            // thêm add database
            String subject = "Student Project Management: CHECK YOUR MAIL.";
            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Verification your mail.</h3>\n"
                    + "    <div>Your New Password: " + passwordCheck + "</div>\n"
                    + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            send(email, subject, message, "dattthe151172@fpt.edu.vn", "123dat69");
            dao.UpdatePassword(passwordCheck, UserID);
//            RequestDispatcher dispath
//                    = request.getRequestDispatcher("ControllerLogin");
//            //run 
//            dispath.forward(request, response);
//            request.setAttribute("email", email);
            HttpSession sessionCheckEmail = request.getSession();
            sessionCheckEmail.setAttribute("UserID", UserID);
            response.sendRedirect("checkRess");

        }
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
