package controller;

import DAL.DAO;
import DAL.Validate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import security.MD5Encryption;
import utils.Constants;
import utils.UserGoogle;

public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        // Tạo các cookies để lưu thông tin đăng nhập
        Cookie cuser = new Cookie("cuser", username);
        Cookie cpass = new Cookie("cpass", password);
        Cookie crem = new Cookie("crem", remember);

        if (remember != null) {
            // Nếu người dùng chọn "Remember Me," sét thời gian sống của cookies
            cuser.setMaxAge(30 * 24 * 60 * 60); // 30 ngày
            cpass.setMaxAge(30 * 24 * 60 * 60); // 30 ngày
            crem.setMaxAge(30 * 24 * 60 * 60); // 30 ngày
        } else {
            // Nếu không chọn, hủy các cookies
            cuser.setMaxAge(0);
            cpass.setMaxAge(0);
            crem.setMaxAge(0);
        }

        // Thêm các cookies vào response
        response.addCookie(cuser);
        response.addCookie(cpass);
        response.addCookie(crem);

        DAO dao = new DAO();
        Validate validate = new Validate();
        HttpSession session = request.getSession();

        Account account = dao.findAccountByUsername(username);
        if (account != null && validate.getMd5(password).equals(account.getPassword())) {
            session.setAttribute("acc", account);
            session.setAttribute("role", account.isIsAdmin());
            request.getRequestDispatcher("/home").forward(request, response);
        } else {
            request.setAttribute("error", "Username or password is wrong");
            request.getRequestDispatcher("Views/login.jsp").forward(request, response);
        }
    }
        
//        
//        UserGoogle userG = null;
//        if (username == null || username.isEmpty()) {
//            String code = request.getParameter("code");
//            String accessToken = getToken(code);
//            userG = getUserInfo(accessToken);
//        }
//        if (userG != null) {
//            System.out.println("Email Info: " + userG);
//            String email = (String) userG.getEmail();
//            String fullname = (String) userG.getName();
//            Account acc = dao.findAccountByEmail(email);
//            // email chua ton tai san trong database
//            if (acc == null) {
//                dao.addAccGoogle(fullname, email);
//                HttpSession s = request.getSession();
//                s.setAttribute("account", account);
//                s.setMaxInactiveInterval(1000);
//                response.sendRedirect("home");
//            } else {// email da duoc dung de dang ky roi
//                HttpSession s = request.getSession();
//                s.setAttribute("account", account);
//                s.setMaxInactiveInterval(1000);
//                response.sendRedirect("home");
//            }
//        } else {
//            try {
//                password = new MD5Encryption().convertPassword(password);
//            } catch (NoSuchAlgorithmException ex) {
//                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Account a = dao.login(username, password);
//            if (a == null) {
//                request.setAttribute("mess", "username or password is incorrect");
//                request.getRequestDispatcher("Login.jsp").forward(request, response);
//            } else if (a.isIsAdmin() == true) {
//                request.setAttribute("mess", "Your account has been BLOCKED");
//                request.getRequestDispatcher("Login.jsp").forward(request, response);
//            } else {
//                HttpSession s = request.getSession();
//                s.setAttribute("account", a);
//                s.setMaxInactiveInterval(1000);
//                response.sendRedirect("home");
//            }
//            
//        }
//    }
//     public static String getToken(String code) throws ClientProtocolException, IOException {
//        // call api to get token
//        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
//                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
//                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
//                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
//                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build()).execute().returnContent().asString();
//        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
//        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
//        return accessToken;
//    }
//
//    public static UserGoogle getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
//        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
//        String response = Request.Get(link).execute().returnContent().asString();
//
//        UserGoogle googlePojo = new Gson().fromJson(response, UserGoogle.class);
//
//        return googlePojo;
//
//    }    

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
