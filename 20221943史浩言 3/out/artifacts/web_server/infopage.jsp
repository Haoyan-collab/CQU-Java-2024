<%@ page import="cache.SelfCache" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Web Server</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1E1E2E; /* 暗色背景 */
            color: #fff; /* 白色字体 */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            margin-top: 10px;
            text-align: center;
            color: #fff; /* 白色标题 */
        }

        h2 {
            text-align: center;
            color: #6E97FB; /* 亮蓝色标题 */
            margin-bottom: 20px;
        }

        .container {
            display: flex;
            justify-content: space-between;
            width: 900px;
            height: auto;
            background-color: #2A2C3A; /* 暗色容器背景 */
            border-radius: 8px; /* 圆角 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5); /* 阴影效果 */
            padding: 20px;
        }

        .system {
            flex: 1;
            padding: 20px;
            margin: 10px;
            background-color: transparent; /* 无背景色 */
            box-shadow: none; /* 无阴影 */
            transition: transform 0.2s;
        }

        .system:hover {
            transform: scale(1.02);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            border: 1px solid #6E97FB; /* 亮蓝色边框 */
            padding: 12px;
            text-align: left;
            background-color: #31353E; /* 暗色表格单元格背景 */
        }

        th {
            background-color: #282A36; /* 更深的暗色表头背景 */
        }

        a {
            display: inline-block;
            margin: 10px 0;
            padding: 10px 15px;
            background-color: #6E97FB; /* 亮蓝色背景 */
            color: #1E1E2E; /* 暗色文字 */
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #5C85D3; /* 悬停时更深的蓝色 */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="system">
        <h2>Web1 登录用户</h2>
        <a href="${pageContext.request.contextPath}/OtherWeb1">进入web1</a>
        <table>
            <tr>
                <th>用户名</th>
                <th>登录时间</th>
            </tr>
            <%
                HashMap<String, Date> web1Message = SelfCache.web1Cache;
                for (Map.Entry<String, Date> entry : web1Message.entrySet()) {
                    Date date1 = entry.getValue();
                    String dateTime1 = String.format("%tF", date1) + "   " + String.format("%tr", date1);
            %>
            <tr>
                <td><%= entry.getKey() %></td>
                <td><%= dateTime1 %></td>
            </tr>
            <% } %>
        </table>
    </div>

    <div class="system">
        <h2>Web2 登录用户</h2>
        <a href="${pageContext.request.contextPath}/OtherWeb2">进入web2</a>
        <table>
            <tr>
                <th>用户名</th>
                <th>登录时间</th>
            </tr>
            <%
                HashMap<String, Date> web2Message = SelfCache.web2Cache;
                for (Map.Entry<String, Date> entry : web2Message.entrySet()) {
                    Date date2 = entry.getValue();
                    String dateTime2 = String.format("%tF", date2) + "   " + String.format("%tr", date2);
            %>
            <tr>
                <td><%= entry.getKey() %></td>
                <td><%= dateTime2 %></td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>