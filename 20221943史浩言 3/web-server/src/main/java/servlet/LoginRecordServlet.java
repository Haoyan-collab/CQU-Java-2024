package servlet;

import dao.DBOperate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/LoginRecordServlet")
public class LoginRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp); // 修复递归问题，将 doPost 调用改为 doGet
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前登录的用户
        String username = (String) req.getSession().getAttribute("user");
        String backUrl = req.getParameter("backUrl"); // 获取 backUrl 参数

        if (username != null) {
            // 查询数据库获取该用户的登录记录
            DBOperate dbOperate = new DBOperate();
            List<Timestamp> loginRecords = dbOperate.getLoginRecords(username);

            // 将记录拼接成字符串或以某种形式传递
            StringBuilder recordsString = new StringBuilder();
            for (Timestamp record : loginRecords) {
                recordsString.append(record.toString()).append(",");
            }

            if (recordsString.length() > 0) {
                recordsString.deleteCharAt(recordsString.length() - 1); // 去掉最后的逗号
            }

            System.out.println(recordsString);
            // 编码 loginRecords 并附加到 backUrl
            if (backUrl != null) {
                backUrl += "?loginRecords=" + URLEncoder.encode(recordsString.toString(), "UTF-8");
                resp.sendRedirect(backUrl); // 重定向到 backUrl
            } else {
                resp.getWriter().write("Missing backUrl parameter.");
            }
        } else {
            resp.sendRedirect("index.jsp"); // 未登录则跳转到登录页面
        }
    }
}
