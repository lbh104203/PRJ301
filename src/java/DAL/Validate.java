package DAL;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import model.Account;

public class Validate {

    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{8,20}";
    private static final String USERNAME_REGEX = "[a-z0-9]{4,20}";
    private static final String EMAIL_REGEX = "^\\s*(.+)@(.+)\\.(.+)\\s*$";
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

    public String checkAccountSetting(Account account, String username, String password, String newpassword, String renewpassword, String questionId, String answer) {
        String mess = "";
        DAO dao = new DAO();
        if (!getMd5(password).equals(account.getPassword())) {
            mess = "Password is incorrect";
        } else if (!newpassword.equals(renewpassword)) {
            mess = "New password must be equal re-newpassword";
        } else if (!questionId.equals(account.getQuestionId())) {
            mess = "QuestionId is incorrect";
        } else if (!answer.equals(account.getAnswer())) {
            mess = "Answer is incorrect";
        } else {
            mess = "Change successfully";
            dao.updatePassword(getMd5(newpassword), username);
        }
        return mess;
    }

//    public String checkSignUp(String username, String password, String repassword, String fullname, boolean isAdmin, String email, String phone, String questionId, String cityId, String answer) {
//        DAO dao = new DAO();
//        String mess = "";
//
//        // Validate username
//        if (!Pattern.matches(USERNAME_REGEX, username)) {
//            mess = "Your username can only be consecutive lowercase letters and numbers";
//        } else if (dao.checkAccountExist(username)) {
//            mess = "Username is already exist.";
//        }
//
//        // Validate password
//        if (!Pattern.matches(PASSWORD_REGEX, password)) {
//            mess = "Your password must have at least 8 characters and contain uppercase, lowercase, numbers, and special characters (!, @, #, $, %)";
//        } else if (!password.equals(repassword)) {
//            mess = "Password does not match re-password.";
//        }
//
//        // Validate email
//        if (!Pattern.matches(EMAIL_REGEX, email)) {
//            mess = "Invalid email format.";
//        } else if (dao.checkExistedEmail(email)) {
//            mess = "Email is already exist.";
//        }
//
//        // The code below should be uncommented when you want to insert data into the database
//         if (mess.isEmpty()) {
//             //dao.insertAccount(username, getMd5(password), fullname, isAdmin, email, phone, questionId, cityId, answer);
//             mess = "Sign up successfully.";
//         }
//        return mess;
//    }

    public String checkForgetAccount(Account account, String questionId, String answer, String newpassword, String renewpassword) {
        String mess = "";
        DAO dao = new DAO();
        if (account == null) {
            mess = "Username is incorrect";
        } else if (!Pattern.matches(PASSWORD_REGEX, newpassword)) {
            mess = "New password format is invalid.";
        } else if (!Pattern.matches(PASSWORD_REGEX, renewpassword)) {
            mess = "Re-new password format is invalid.";
        } else if (!questionId.equals(account.getQuestionId())) {
            mess = "Question is incorrect";
        } else if (!answer.equals(account.getAnswer())) {
            mess = "Answer is incorrect";
        } else if (!newpassword.equals(renewpassword)) {
            mess = "New password must be equal re-new password";
        } else {
            mess = "successfully";
            dao.updatePassword(getMd5(newpassword), account.getUsername());
        }
        return mess;
    }

}
