package servlet;

import cache.SelfCache;
import httpconstants.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;


@WebServlet("/RecordsServlet")
public class RecordsServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //回来路径
        String url = URLEncoder.encode(request.getContextPath()+"/loginRecords.jsp", "UTF-8");
        //发出查询记录的请求
        response.sendRedirect(Constants.SERVER_LOGIN_URL +"/LoginRecordServlet?backUrl=" + url);

    }
}
