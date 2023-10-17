/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.SQLException;
import model.Account;

/**
 *
 * @author leha1
 */
public class AccountDAO extends DBContext {

    //Lay ttin tai khoang tu database
    public Account getAccount(String username) {
        Account account = null;
        try {
            String sql = "SELECT * FROM Account WHERE username = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Lấy thông tin tài khoản từ kết quả truy vấn
                int account_id = rs.getInt("account_id");
                String accountUsername = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                // Lấy thêm các trường thông tin khác tại đây

                // Tạo một đối tượng Account và gán thông tin
                account = new Account();
                account.setAccount_id(account_id);
                account.setUsername(accountUsername);
                account.setPassword(password);
                account.setFullname(fullname);
                account.setEmail(email);
                // Gán các trường thông tin khác tại đây
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return account;
    }

    public boolean checkExistedEmail(String email) {
        try {
            String sql = "SELECT COUNT(*) AS count FROM Account WHERE email = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0; // Trả về true nếu email đã tồn tại, ngược lại trả về false.
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean checkExistedUsername(String username) {
        try {
            String sql = "SELECT COUNT(*) AS count FROM Account WHERE username = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0; // Trả về true nếu username đã tồn tại, ngược lại trả về false.
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //Neu dang ki thanh cong se tao 1 tai khoan trong database
    public boolean createAccount(Account account) {
        try {
            String sql = "INSERT INTO Account (username, password, fullname, email) VALUES (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getFullname());
            ps.setString(4, account.getEmail());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean checkUser(String username, String password) {
        try {
            String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false; // Nếu có lỗi xảy ra, trả về false để xác định rằng tên người dùng và mật khẩu không hợp lệ.
    }

}
