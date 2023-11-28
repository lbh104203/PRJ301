/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "VerifyRegisterController", urlPatterns = "/verifyregister")
public class VerifyRegisterController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String questionId = request.getParameter("questionId");
        String cityId = request.getParameter("cityId");
        String answer = request.getParameter("answer");

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("repassword", repassword);
        request.setAttribute("fullname", fullname);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("questionId", questionId);
        request.setAttribute("cityId", cityId);
        request.setAttribute("answer", answer);

        DAO dao = new DAO();
        request.setAttribute("city", dao.getAllCity());
        request.setAttribute("question", dao.getAllQuestion());
        request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String questionId = request.getParameter("questionId");
        String cityId = request.getParameter("cityId");
        String answer = request.getParameter("answer");
        String otp = request.getParameter("otp");
        String otpInput = request.getParameter("otpInput");
        String countParam = request.getParameter("count");
        int count = 0;

        if (countParam != null && !countParam.isEmpty()) {
            try {
                count = Integer.parseInt(countParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        if (otpInput.equals(otp)) {
            DAO dao = new DAO();
            try {
                dao.insertAccount(username, getMd5(password), fullname, email, phone, questionId, cityId, answer);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(VerifyRegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("mess", "You can now login.");
            request.getRequestDispatcher("Views/login.jsp").forward(request, response);
        } else {
            count--;
            if (count == 0) {
                request.setAttribute("err", "Your OTP is not valid, email verification failed.");
                request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
            } else {
                request.setAttribute("count", count);
                request.setAttribute("mess", "Your OTP is not valid, " + count + " times remaining.");
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("repassword", repassword);
                request.setAttribute("fullname", fullname);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("questionId", questionId);
                request.setAttribute("cityId", cityId);
                request.setAttribute("answer", answer);
                request.setAttribute("otp", otp);
                request.getRequestDispatcher("Views/sign.jsp").forward(request, response);
            }
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

     public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
