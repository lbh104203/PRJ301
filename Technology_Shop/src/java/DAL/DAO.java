package DAL;

import java.security.NoSuchAlgorithmException;
import model.Account;
import model.Order;
import model.Product;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.City;
import model.Comment;
import model.OrderDetail;
import model.Question;
import model.TempOrder;
import model.Total;
import model.UpdatePrice;
import security.MD5Encryption;

public class DAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //Account table  -----------------------------------------------------------
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from [Account]";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getBoolean(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertAccount(String username, String password, String fullname, String email, String phone, String questionId, String cityId, String answer) throws NoSuchAlgorithmException {
        String query = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[fullname]\n"
                + "           ,[isAdmin]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[questionId]\n"
                + "           ,[cityId]\n"
                + "           ,[answer])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, '0', ?, ?, ?, ?, ?)";

        password = new MD5Encryption().convertPassword(password);

        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);  // Đặt giá trị '0' vào cột isAdmin tại vị trí thứ 4
            ps.setString(5, phone);
            ps.setString(6, questionId);
            ps.setString(7, cityId);
            ps.setString(8, answer);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkAccountExist(String username) {
        List<Account> list = getAllAccount();
        for (Account account : list) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistedEmail(String email) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = new DBContext().getConnection(); // Khởi tạo kết nối đến cơ sở dữ liệu ở đây.

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
        } finally {
            // Đóng tất cả tài nguyên (ResultSet, PreparedStatement, Connection) sau khi sử dụng.
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public boolean checkExistedUsername(String username) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = new DBContext().getConnection(); // Khởi tạo kết nối đến cơ sở dữ liệu ở đây.

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
        } finally {
            // Đảm bảo đóng tất cả tài nguyên ở đây.
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }

    public Account findAccountByUsername(String username) {
        List<Account> list = getAllAccount();
        for (Account account : list) {
            if (username.equals(account.getUsername())) {
                return account;
            }
        }
        return null;
    }

    public void updatePassword(String password, String username) {
        String query = "update [Account] set password = ? where username = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void AddNewAdmin(String username) {
        String query = "update [Account] set isAdmin = ? where username = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setBoolean(1, true);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAccount(String email, String phone, String cityId, String username) {
        String query = "update [Account] set email = ?, phone = ?, cityId = ? where username = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, cityId);
            ps.setString(4, username);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // TempOrder table-----------------------------------------------------------
    public void insertTempOrder(String username, String productId, int price, int quantity) {
        String query = "insert into [TempOrder] values(?,?,?,?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.setInt(3, price);
            ps.setInt(4, quantity);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public int getQuantityTempOrder(String username, String productId) {
        String query = "select * from [TempOrder] where username = ? and productId = ?";
        int quantity = 0;
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt(4);
            }
        } catch (Exception e) {
        }
        return quantity;
    }

    public void updateQuantityTempOrder(String username, String productId) {
        int quantity = getQuantityTempOrder(username, productId);
        String query = "update TempOrder set quantity = ? where username = ? and productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, quantity + 1);
            ps.setString(2, username);
            ps.setString(3, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void updatePriceInTempOrder(String productId, int price) {
        String query = "update TempOrder set price = ? where productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, price);
            ps.setString(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<TempOrder> getTempOrderByUsername(String username) {
        List<TempOrder> list = new ArrayList<>();
        String query = "select * from [TempOrder] where username = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TempOrder(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<TempOrder> getAllTempOrder() {
        List<TempOrder> list = new ArrayList<>();
        String query = "select * from [TempOrder]";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TempOrder(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

//    public void deleteProductInTempOrder(String id){
//        String query = "delete from [TempOrder] where productId = ?";
//        try {
//            connection=new DBContext().getConnection();
//            ps = connection.prepareStatement(query);
//            ps.setString(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }
    public boolean checkOldPriceExistInTempOrder(Product product) {
        String query = "select * from [TempOrder] where productId = ? and price <> ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getId());
            ps.setInt(2, product.getPrice());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void deleteProductInTempOrderByUserName(String username, String productId) {
        String query = "delete from [TempOrder] where username = ? and productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        Product product = getProductById(productId);
        if (!checkOldPriceExistInTempOrder(product)) {
            deleteUpdatePrice(productId);
        }
    }

    public int getSumQuantityProduct(String username) {
        int quantity = 0;
        String query = "SELECT SUM(quantity)\n"
                + "FROM [TempOrder]\n"
                + "WHERE username = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return quantity;
    }

    public boolean checkExist(List<TempOrder> list, String id) {
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Product table -----------------------------------------------------------
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from [Product]";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProductByQuantity(int quantity) {
        List<Product> list = new ArrayList<>();
        String query = "select * from [Product] where quantity < ? order by quantity";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, quantity);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductPerPage(List<Product> list, int index, int nrpp) {
        List<Product> listPerPage = new ArrayList<>();
        int total = list.size();
        int end = (nrpp * index) > total ? total : (nrpp * index);
        int start = index == 1 ? 0 : (end - nrpp);
        start = (nrpp * index) > total ? (end - end % nrpp) : start;

        for (int i = start; i < end; i++) {
            listPerPage.add(list.get(i));
        }

        return listPerPage;
    }

    public void updateQuantity(String id, int quantity) {
        Product product = getProductById(id);
        int newQuantity = product.getQuantity() - quantity;
        String query = "update [Product] set quantity = ? where productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, newQuantity);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Product> searchProduct(String productName) {
        List<Product> list = new ArrayList<>();
        String query = "select * from [Product] where productName like ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + productName + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProductByCategoryId(String categoryId) {
        List<Product> list = new ArrayList<>();
        String query = "select * from [Product] where categoryId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductById(String id) {
        Product product;
        String query = "select * from [Product] where productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getString(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getInt(7));
                return product;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertProduct(String id, String name, int price, String image, String description, String categoryId, int quantity) {
        String query = "insert into Product values(?,?,?,?,?,?,?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, price);
            ps.setString(4, image);
            ps.setString(5, description);
            ps.setString(6, categoryId);
            ps.setInt(7, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateProduct(String id, String name, int price, String image, String description, String categoryId, int quantity) {
        String query = "update [Product] set productName = ?,"
                + "price = ?, image = ?, description = ?, categoryId = ?, quantity = ? where productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3, image);
            ps.setString(4, description);
            ps.setString(5, categoryId);
            ps.setInt(6, quantity);
            ps.setString(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkProductExist(List<Product> list, String id) {
        for (Product product : list) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void deleteProduct(String id) {
        String query = "delete from [Product] where productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //Category table ------------------------------------------------------------
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from [Category]";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //City tabble -----------------------------------------------------------------
    public List<City> getAllCity() {
        List<City> list = new ArrayList<>();
        String query = "select * from City";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new City(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getCityById(String cityId) {
        List<City> list = getAllCity();
        for (City city : list) {
            if (cityId.equals(city.getCityId())) {
                return city.getCityName();
            }
        }
        return null;
    }

    //Question table -------------------------------------------------------------
    public List<Question> getAllQuestion() {
        List<Question> list = new ArrayList<>();
        String query = "select * from Question";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Question(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getQuestionById(String questionId) {
        List<Question> list = getAllQuestion();
        for (Question question : list) {
            if (questionId.equals(question.getQuestionId())) {
                return question.getContent();
            }
        }
        return null;
    }

    //Order table -----------------------------------------------------------------
    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String query = "select * from [Order] order by status, orderId";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Order getOrderbyOrderId(String id) {
        String query = "select * from [Order] where orderId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Order> getAllOrderByDate(String from, String to) {
        List<Order> list = new ArrayList<>();
        String query = "select * from [Order] where status=1 and date between ? and ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, from);
            ps.setString(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertOrder(String username, String email, String phone, String address, boolean status) {
        String query = "insert into [Order](username,date,phone,email,address,status) values(?,?,?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, dtf.format(now));
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setBoolean(6, status);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getLastOrder() {
        String query = "select top 1 orderId from [Order] order by orderId desc";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }

    public void updateOrder(String id) {
        String query = "update [Order] set status = '1' where orderId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteOrderByOrderId(String id) {
        String query = "delete from [Order] where orderId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // OrderDetail table --------------------------------------------------------
    public List<OrderDetail> getAllOrderDetail() {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select * from [OrderDetail] order by orderId";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getOrderDetailbyOrderId(String id) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select * from [OrderDetail] where orderId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertOrderDetail(int orderId, String productId, String quantity, String price) {
        String query = "insert into [OrderDetail] values(?,?,?,?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.setString(2, productId);
            ps.setString(3, quantity);
            ps.setString(4, price);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteOrderDetailByOrderId(String id) {
        String query = "delete from [OrderDetail] where orderId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Total> getTotalInOrder(List<Order> orderList, List<OrderDetail> orderDetail) {
        List<Total> list = new ArrayList();
        int total = 0;
        for (Order o : orderList) {
            total = 0;
            for (OrderDetail od : orderDetail) {
                if (o.getOrderId() == od.getOrderId()) {
                    total += od.getPrice() * od.getQuantity();
                }
            }
            list.add(new Total(o.getOrderId(), total));
        }
        return list;
    }

    //Comment table -------------------------------------------------------------
    public List<Comment> getCommentByProductId(String productId) {
        List<Comment> list = new ArrayList<>();
        String query = "select * from [Comment] where productId = ? order by date desc";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertComment(String username, String productId, String content, int reply) {
        String query = "insert into [Comment](username,productId,content,date,reply) values(?,?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.setString(3, content);
            ps.setString(4, dtf.format(now));
            ps.setInt(5, reply);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertCommentByCommentId(String username, String productId, String content, int reply) {
        String query = "insert into [Comment](username,productId,content,date,reply) values(?,?,?,?,?)";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, productId);
            ps.setString(3, content);
            ps.setString(4, dtf.format(now));
            ps.setInt(5, reply);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Update Price table --------------------------------------------------------
    public void insertUpdatePrice(String productId, int newprice, String date) {
        String query = "insert into [UpdatePrice] values(?,?,?)";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, productId);
            ps.setInt(2, newprice);
            ps.setString(3, date);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<UpdatePrice> getAllUpdatePrice() {
        List<UpdatePrice> list = new ArrayList<>();
        String query = "select * from [UpdatePrice]";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UpdatePrice(rs.getString(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean checkExistUpdatePrice(String productId) {

        for (UpdatePrice u : getAllUpdatePrice()) {
            if (u.getProductId().equals(productId)) {
                return true;
            }
        }
        return false;
    }

    public void updatePrice(String productId, int price, String date) {
        String query = "update [UpdatePrice] set newPrice = ?, date = ? where productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, price);
            ps.setString(2, date);
            ps.setString(3, productId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void changePrice() {
        List<TempOrder> list = getAllTempOrder();
        List<UpdatePrice> listUpdate = getAllUpdatePrice();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        if (listUpdate == null || list == null) {
            return;
        } else {
            for (TempOrder t : list) {
                for (UpdatePrice u : listUpdate) {
                    if (t.getProductId().equals(u.getProductId()) && dtf.format(now).equals(u.getDate())) {
                        updatePriceInTempOrder(t.getProductId(), u.getPrice());
                        deleteUpdatePrice(u.getProductId());
                    }
                }
            }
        }

    }

    private void deleteUpdatePrice(String productId) {
        String query = "delete from [UpdatePrice] where productId = ?";
        try {
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, productId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addAccGoogle(String fullname, String email) {
        String sql = "insert into Account(username, [password], fullname, [isAdmin], email, [phone], [questionId], [cityId], [answer])\n"
                + "values('','',?,'0',?,'0332526273','123','27','aaa')";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // check existed account
    public boolean checkExistAccGoogle(List<Account> list, String email) {
        for (Account account : list) {
            if (account.getUsername().equals(email) && account.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Account findAccountByEmail(String email) {
        String sql = "select * from Account\n"
                + "where email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account acc = new Account();
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setFullname(rs.getString("fullname"));
                acc.setIsAdmin(rs.getBoolean("isAdmin"));
                acc.setEmail(rs.getString("email"));
                acc.setPhone(rs.getString("phone"));
                acc.setQuestionId(rs.getString("questionId"));
                acc.setCityId(rs.getString("cityId"));
                acc.setAnswer(rs.getString("answer"));
                acc.setOtp(rs.getString("otp"));

            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Account login(String username, String password) {
        String sql = "SELECT * FROM Account\n"
                + "WHERE username = ? AND [password] = ? AND isAdmin = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setFullname(rs.getString("fullname"));
                acc.setIsAdmin(rs.getBoolean("isAdmin"));
                acc.setEmail(rs.getString("email"));
                acc.setPhone(rs.getString("phone"));
                acc.setQuestionId(rs.getString("questionId"));
                acc.setCityId(rs.getString("cityId"));
                acc.setAnswer(rs.getString("answer"));
                acc.setOtp(rs.getString("otp"));
                return acc;
            }
        } catch (SQLException e) {
        }
        return null;
    }
//    public static void main(String[] args) {
//        try {
//            String username = "testuser";
//            String password = "testpassword";
//            String fullname = "Test User";
//            String email = "test@example.com";
//            String phone = "1234567890";
//            String questionId = "123";
//            String cityId = "27";
//            String answer = "Test Answer";
//
//            DAO dao = new DAO();
//            dao.insertAccount(username, password, fullname, email, phone, questionId, cityId, answer);
//            System.out.println("Account inserted successfully.");
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }

}
