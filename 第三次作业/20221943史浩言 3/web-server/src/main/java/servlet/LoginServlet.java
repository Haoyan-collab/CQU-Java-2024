package servlet;

import cache.SelfCache;
import dao.DBConnect;
import dao.DBOperate;
import model.TGT;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.UUID;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String backUrl = req.getParameter("backUrl");

        DBOperate dbOperate = new DBOperate();
        User user = dbOperate.JudgeUser(username, password);

        if (user == null) {
            // 用户不存在或密码错误
            String errorMsg;
            try (Connection conn = DBConnect.getConn();
                 PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET times = times + 1 WHERE cname = ?")) {
                pstmt.setString(1, username);
                pstmt.executeUpdate();

                // 查询错误次数
                try (PreparedStatement queryStmt = conn.prepareStatement("SELECT times FROM users WHERE cname = ?")) {
                    queryStmt.setString(1, username);
                    try (ResultSet rs = queryStmt.executeQuery()) {
                        if (rs.next()) {
                            int times = rs.getInt("times");
                            if (times >= 3) {
                                // 账号被禁用
                                errorMsg = "账号已被禁用，请重新注册！";
                                // 删除用户
                                try (PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM users WHERE cname = ?")) {
                                    deleteStmt.setString(1, username);
                                    deleteStmt.executeUpdate();
                                }
                            } else {
                                // 账号或密码错误
                                errorMsg = "密码输入错误，请重新输入！";
                            }
                        } else {
                            errorMsg = "账号不存在，请检查输入！";
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException("数据库操作失败", e);
            }
            // 将错误消息和返回URL设置到请求属性中
            req.setAttribute("errorMsg", errorMsg);
            req.setAttribute("backUrl", backUrl);
            // 转发到登录页面，带有错误消息
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        else {
            dbOperate.insertLoginRecord(user);  // DBOperate的方法，传递java.sql.Timestamp
            req.getSession().setAttribute("user", user.getCname());
            System.out.println(req.getSession().getId());

            // 生成随机Token，处理生成32位随机连续字符串
            String Token = UUID.randomUUID().toString().replace("-", "");

            // 生成cookie
            Cookie cookie = new Cookie("CAS-TGC", Token);
            cookie.setPath("/");
            resp.addCookie(cookie);

            // 签发ST并生成票据
            String st = UUID.randomUUID().toString().replace("-", "");
            SelfCache.stCache.put(st, user.getCname());

            // 生成TGT并缓存用户信息
            TGT tgt = new TGT();
            tgt.user = user;
            tgt.safeUrl.put(st, backUrl);
            SelfCache.tgtCache.put(Token, tgt);

            // 装入session中
            req.getSession().setAttribute("TGC", Token);
            req.getSession().setAttribute("TGT", tgt);

            System.out.println((String) req.getSession().getAttribute("user"));

            if (backUrl != null && backUrl.length() != 0) {
                // 判断从web1或web2跳转而来
                System.out.println(backUrl + "?ST=" + st);
                Date nowdate = new Date();
                String jsonstr = null;
                if (backUrl.indexOf("web1") >= 0) {
                    SelfCache.web1Cache.put(username, nowdate);
                } else if (backUrl.indexOf("web2") >= 0) {
                    SelfCache.web2Cache.put(username, nowdate);
                } else {
                    System.out.println("未获取到当前用户系统类别");
                }
                resp.sendRedirect(backUrl + "/index.jsp?ST=" + st);
            } else {
                // 否则返回主界面（还未添加，暂时设置为登录界面）
                resp.sendRedirect("/LoginServlet");
                System.out.println("返回server主界面");
            }
        }
    }
}
