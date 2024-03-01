/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "ControllerSignUp", urlPatterns = {"/SignUp"})
public class SignUpController extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            RequestDispatcher dispath
                    = request.getRequestDispatcher("./page/user/register.jsp");
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
        int warning;
        UserDao dao = new UserDao();

        String fullName = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        //check mail ton tai database
        User u = dao.checkMail(email);
        int fail = 0;

        if (u != null) {
            request.setAttribute("messEmail", "Email already exists");
            fail = 1;
        }

        if (email.length() > 50) {
            request.setAttribute("messEmail", "Email not over 50 character");
            fail = 1;
        }
        if (fail == 1) {
            RequestDispatcher dispath
                    = request.getRequestDispatcher("register.jsp");
            dispath.forward(request, response);
        } else {

            boolean valueGender = Boolean.parseBoolean(gender);
            String UserID = dao.checkUserID();
//            String password = userDao.randomString(8);

            // thêm add database
            String subject = "Student Project Management: Verify your mail.";
            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Verify your mail.</h3>\n"
                    + "    <div>Your Password: " + password + "</div>\n"
                    + "    <div>Click Link to verify: "
                    + "http://localhost:8080/g4/check?do=createID&UserID=" + UserID +"&gender="+gender+"&email="+email+"&mobile="+mobile+"&password="+password+ 
                    "</div>\n"
                    + "    <h3 style=\"color: blue;\">Thank you very much!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            send(email, subject, message, "dattthe151172@fpt.edu.vn", "123dat69");
//            RequestDispatcher dispath
//                    = request.getRequestDispatcher("ControllerLogin");
//            //run 
//            dispath.forward(request, response);
            response.sendRedirect("check");
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
