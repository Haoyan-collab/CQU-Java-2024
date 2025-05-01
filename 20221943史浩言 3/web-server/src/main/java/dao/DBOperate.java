package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperate {
    public User JudgeUser(String username,String password) {
        Connection conn = null;
        Statement stmt = null;
        User user = null;
        ResultSet rs;
        try {
            conn = DBConnect.getConn();
            String sql = "select cname , pin from users where cname = ? and pin = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);//将输入字符串同时在学号和姓名中查询
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String selUsername = rs.getString("cname");
                String selPassword = rs.getString("pin");
                user = new User(selUsername,selPassword,0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closeConn(conn, stmt);
        }
        return user;
    }

    // 检查用户名是否存在
    public boolean isUsernameExist(String username) {
        try (Connection connection = DBConnect.getConn()) {
            String query = "SELECT COUNT(*) FROM users WHERE cname = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0;  // 如果查询结果大于0，说明用户名已存在
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 注册用户
    public boolean registerUser(User user) {
        try (Connection connection = DBConnect.getConn()) {
            String query = "INSERT INTO users (cname, pin) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, user.getCname());
                stmt.setString(2, user.getPin());  // 注意：密码应进行加密存储
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;  // 如果影响行数大于0，说明插入成功
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 插入登录记录到数据库的record表
    public void insertLoginRecord(User user) {
        try (Connection connection = DBConnect.getConn()) {
            String query = "INSERT INTO records (cname, logintime) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, user.getCname());
                stmt.setTimestamp(2,new Timestamp(System.currentTimeMillis()));//因为数据库版本不支持
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从数据库获取某个用户的登录记录
    public List<Timestamp> getLoginRecords(String username) {
        List<Timestamp> loginRecords = new ArrayList<>();
        System.out.println("查询记录人："+username);
        String query = "SELECT logintime FROM records WHERE cname = ? ORDER BY logintime DESC";
        try (Connection conn = DBConnect.getConn();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                loginRecords.add(rs.getTimestamp("logintime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginRecords;
    }
}
