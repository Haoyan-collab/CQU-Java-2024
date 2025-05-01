package servlet;

import dao.DBOperate;
import httpconstants.Constants;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取输入信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        System.out.println(password);
        // 判断输入信息是否有效
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {
            req.setAttribute("message", "用户名和密码不能为空！");
            req.setAttribute("messageType", "error");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        // 在密码不一致时
        if (!password.equals(confirmPassword)) {
            req.setAttribute("message", "密码和确认密码不一致！");
            req.setAttribute("messageType", "error");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        // 调用数据库操作类检查用户名是否已存在
        DBOperate dbOperate = new DBOperate();
        if (dbOperate.isUsernameExist(username)) {
            req.setAttribute("message", "用户名已存在！");
            req.setAttribute("messageType", "error");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        // 插入用户到数据库
        User user = new User();
        user.setCname(username);
        user.setPin(password); // 注意，实际开发中密码应进行加密处理
        user.setTimes(0);
        dbOperate = new DBOperate();
        boolean isRegistered = dbOperate.registerUser(user);

        // 注册成功后
        if (isRegistered) {
            resp.sendRedirect(Constants.SERVER_LOGIN_URL);
            return;
        } else {
            // 注册失败
            req.setAttribute("message", "注册失败，请稍后再试！");
            req.setAttribute("messageType", "error");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
