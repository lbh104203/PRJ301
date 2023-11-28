/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.DAO;
import DAL.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.EmailUtils;

/**
 *
 * @author 84877
 */
public class SignUpControl extends HttpServlet {

    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{8,20}";
    private static final String USERNAME_REGEX = "[a-z0-9]{4,20}";
    private static final String EMAIL_REGEX = "^\\s*(.+)@(.+)\\.(.+)\\s*$";
    private static final String PHONE_REGEX = "^[0-9]{10}$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        DAO dao = new DAO();
        request.setAttribute("city", dao.getAllCity());
        request.setAttribute("question", dao.getAllQuestion());
        request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("RePassword");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String questionId = request.getParameter("question");
        String cityId = request.getParameter("city");
        String answer = request.getParameter("answer");

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("fullname", fullname);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("questionId", questionId);
        request.setAttribute("cityId", cityId);
        request.setAttribute("answer", answer);

        DAO dao = new DAO();

        if (!username.matches(USERNAME_REGEX)) {
            request.setAttribute("mess", "Your username can only be consecutive lowercase letters and numbers");
            request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
        } else if (!password.matches(PASSWORD_REGEX)) {
            request.setAttribute("mess", "Your password must has at least 8 characters and contain uppercase, lowercase, number and specical syntax (!, @, #, $, %)");
            request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
        } else try {
            if (dao.checkExistedEmail(email)) {
                request.setAttribute("mess", "This email already registered of another account");
                request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
            } else if (!email.matches(EMAIL_REGEX)) {
                request.setAttribute("mess", "Invalid email format.");
                request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
            } else if (dao.checkExistedUsername(username)) {
                request.setAttribute("mess", "This username already existed");
                request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
            } else if (!phone.matches(PHONE_REGEX)) {
                request.setAttribute("mess", "Invalid phone format.");
                request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
            } else if (password.equals(repassword)) {
                //Generate OTP
                String otp = EmailUtils.generateOTP();
                //send OTP to mail
                EmailUtils.sendEmail(email, "Technology - Register", "Hello, Your OTP code is: " + otp);
                request.setAttribute("otp", otp);
                request.getRequestDispatcher("Views/VerifyRegister.jsp").forward(request, response);
            } else {
                request.setAttribute("mess", "Confirm password is incorrect");
                request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(SignUpControl.class.getName()).log(Level.SEVERE, null, ex);
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
