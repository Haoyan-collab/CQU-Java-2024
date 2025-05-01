<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<html>
<head>
  <title>用户登录记录</title>
  <style>
    body {
      background-color: #2b2b2b; /* 暗色背景 */
      color: #ffffff; /* 白色字体 */
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
    }

    h2 {
      color: #ffffff; /* 白色字体 */
      text-align: center;
      margin: 20px 0;
    }

    .button-container {
      display: flex;
      justify-content: center;
      margin: 20px 0;
    }

    /* 新增的登出按钮样式 */
    .Btn {
      display: flex;
      align-items: center;
      justify-content: flex-start;
      width: 45px;
      height: 45px;
      border: none;
      border-radius: 50%;
      cursor: pointer;
      position: relative;
      overflow: hidden;
      transition-duration: .3s;
      box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.199);
      background-color: rgb(255, 65, 65);
    }

    .sign {
      width: 100%;
      transition-duration: .3s;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .sign svg {
      width: 17px;
    }

    .sign svg path {
      fill: white;
    }

    .text {
      position: absolute;
      right: 0%;
      width: 0%;
      opacity: 0;
      color: white;
      font-size: 1.2em;
      font-weight: 600;
      transition-duration: .3s;
    }

    .Btn:hover {
      width: 125px;
      border-radius: 40px;
      transition-duration: .3s;
    }

    .Btn:hover .sign {
      width: 30%;
      transition-duration: .3s;
      padding-left: 20px;
    }

    .Btn:hover .text {
      opacity: 1;
      width: 70%;
      transition-duration: .3s;
      padding-right: 10px;
    }

    .Btn:active {
      transform: translate(2px ,2px);
    }

    button {
      background-color: #333333; /* 暗色按钮背景 */
      color: #ffffff; /* 白色字体 */
      border: none;
      padding: 10px 20px;
      margin: 0 10px;
      cursor: pointer;
      border-radius: 5px;
      transition: background-color 0.3s;
    }

    button:hover {
      background-color: #444444; /* 悬停时的按钮背景 */
    }

    .login-record {
      margin: 20px;
      text-align: center;
    }

    .return-button {
      display: block;
      width: 200px;
      margin: 20px auto;
      padding: 10px;
      background-color: #444444; /* 暗色返回按钮背景 */
      color: #ffffff; /* 白色字体 */
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .return-button:hover {
      background-color: #555555; /* 悬停时的返回按钮背景 */
    }
    /* 其他样式保持不变 */
  </style>
</head>
<body>
<h2>用户登录记录</h2>

<div class="button-container">
  <!-- 新增的登出按钮 -->
  <a href="${pageContext.request.contextPath}/LogoutServlet" class="Btn">
    <div class="sign">
      <svg viewBox="0 0 512 512">
        <path d="M377.9 105.9L500.7 228.7c7.2 7.2 11.3 17.1 11.3 27.3s-4.1 20.1-11.3 27.3L377.9 406.1c-6.4 6.4-15 9.9-24 9.9c-18.7 0-33.9-15.2-33.9-33.9l0-62.1-128 0c-17.7 0-32-14.3-32-32l0-64c0-17.7 14.3-32 32-32l128 0 0-62.1c0-18.7 15.2-33.9 33.9-33.9c9 0 17.6 3.6 24 9.9zM160 96L96 96c-17.7 0-32 14.3-32 32l0 256c0 17.7 14.3 32 32 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32l-64 0c-53 0-96-43-96-96L0 128C0 75 43 32 96 32l64 0c17.7 0 32 14.3 32 32s-14.3 32-32 32z"></path>
      </svg>
    </div>
    <div class="text">登出</div>
  </a>

  <!-- 刷新按钮保持不变 -->
  <form action="${pageContext.request.contextPath}/RefreshInfoServlet" method="get">
    <button type="submit">刷新</button>
  </form>
</div>

<!-- 登录记录显示部分保持不变 -->
<%
  // 尝试从请求属性中获取登录记录
  List<Timestamp> loginRecords = (List<Timestamp>) request.getAttribute("loginRecords");

  if (loginRecords == null) {
    // 如果请求属性为空，尝试从 URL 参数中获取数据
    String loginRecordsParam = request.getParameter("loginRecords");
    if (loginRecordsParam != null && !loginRecordsParam.isEmpty()) {
      loginRecords = new ArrayList<>();
      String[] recordsArray = loginRecordsParam.split(",");
      for (String record : recordsArray) {
        try {
          loginRecords.add(Timestamp.valueOf(record.trim())); // 转换为 Timestamp
        } catch (IllegalArgumentException e) {
          // 处理格式错误
          out.println("<p>无法解析的登录记录：" + record + "</p>");
        }
      }
    }
  }

  // 显示登录记录
  if (loginRecords != null && !loginRecords.isEmpty()) {
    for (Timestamp loginTime : loginRecords) {
      String dateTime = String.format("%tF", loginTime) + " " + String.format("%tr", loginTime);
%>
<div class="login-record">
  <p>登录时间：<%= dateTime %></p>
</div>
<%
  }
} else {
%>
<p>No login records found.</p>
<%
  }
%>

<form action="${pageContext.request.contextPath}/index.jsp" method="get">
  <button type="submit" class="return-button">返回web1</button>
</form>
</body>