<%@ page import="cache.SelfCache" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$web2$</title>
  <style>

    /* 保留原有的button-container样式，并修改为垂直排列 */
    .button-container {
      display: flex;
      flex-direction: column; /* 修改为垂直排列 */
      align-items: center;
      width: 80%; /* 限制容器宽度以适应屏幕 */
      margin: 0 auto; /* 居中容器 */
    }

    /* 从Uiverse.io by StealthWorm引入的CSS样式，并稍作调整 */
    .btn {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 13rem;
      overflow: hidden;
      height: 3rem;
      background-size: 300% 300%;
      cursor: pointer;
      backdrop-filter: blur(1rem);
      border-radius: 5rem;
      transition: 0.5s;
      animation: gradient_301 5s ease infinite;
      border: double 4px transparent;
      background-image: linear-gradient(#212121, #212121),
      linear-gradient(
              137.48deg,
              #ffdb3b 10%,
              #fe53bb 45%,
              #8f51ea 67%,
              #0044ff 87%
      );
      background-origin: border-box;
      background-clip: content-box, border-box;
      margin: 1rem 0; /* 添加垂直间距 */
    }

    .container-stars {
      position: absolute;
      z-index: -1;
      width: 100%;
      height: 100%;
      overflow: hidden;
      transition: 0.5s;
      backdrop-filter: blur(1rem);
      border-radius: inherit; /* 继承父元素的边框半径 */
    }

    strong {
      z-index: 2;
      font-family: "Arial"; /* 使用Arial字体，因为"Avalors Personal Use"可能不可用 */
      font-size: 12px;
      letter-spacing: 5px;
      color: #ffffff;
      text-shadow: 0 0 4px white;
    }

    .glow {
      position: absolute;
      display: flex;
      width: calc(100% - 4px); /* 减去边框宽度 */
      height: calc(100% - 8px); /* 减去边框宽度 */
    }

    .circle {
      width: 100%;
      height: 30px;
      filter: blur(2rem);
      animation: pulse_3011 4s infinite;
      z-index: -1;
    }

    .circle:nth-of-type(1) {
      background: rgba(254, 83, 186, 0.636);
    }

    .circle:nth-of-type(2) {
      background: rgba(142, 81, 234, 0.704);
    }

    .btn:hover .container-stars {
      z-index: 1;
      background-color: #212121;
    }

    .btn:hover {
      transform: scale(1.1);
    }

    .btn:active {
      border: double 4px #fe53bb;
      background-origin: border-box;
      background-clip: content-box, border-box;
      animation: none;
    }

    .btn:active .circle {
      background: #fe53bb;
    }

    .stars {
      position: relative;
      background: transparent;
      width: 200rem;
      height: 200rem;
    }

    .stars::after {
      content: "";
      position: absolute;
      top: -10rem;
      left: -100rem;
      width: 100%;
      height: 100%;
      animation: animStarRotate 90s linear infinite;
      background-image: radial-gradient(#ffffff 1px, transparent 1%);
      background-size: 50px 50px;
    }

    .stars::before {
      content: "";
      position: absolute;
      top: 0;
      left: -50%;
      width: 170%;
      height: 500%;
      animation: animStar 60s linear infinite;
      background-image: radial-gradient(#ffffff 1px, transparent 1%);
      background-size: 50px 50px;
      opacity: 0.5;
    }

    @keyframes animStar {
      from {
        transform: translateY(0);
      }
      to {
        transform: translateY(-135rem);
      }
    }

    @keyframes animStarRotate {
      from {
        transform: rotate(360deg);
      }
      to {
        transform: rotate(0);
      }
    }

    @keyframes gradient_301 {
      0% {
        background-position: 0% 50%;
      }
      50% {
        background-position: 100% 50%;
      }
      100% {
        background-position: 0% 50%;
      }
    }

    @keyframes pulse_3011 {
      0% {
        transform: scale(0.75);
        box-shadow: 0 0 0 0 rgba(0, 0, 0, 0.7);
      }
      70% {
        transform: scale(1);
        box-shadow: 0 0 0 10px rgba(0, 0, 0, 0);
      }
      100% {
        transform: scale(0.75);
        box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
      }
    }

    /* 将容器的背景颜色改为黑色 */
    .container {
      width: 100%;
      height: 100%;
      background-image: url('列车.jpg'); /* 使用相对路径引用图片 */
      background-size: cover; /* 覆盖整个容器 */
      background-position: center; /* 图片居中显示 */
      background-repeat: no-repeat; /* 不重复图片 */
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Shadow for depth */
      border-radius: 10px; /* Rounded corners */
      position: relative;
      overflow: hidden;
    }

    /* 美化标题字体 */
    h2 {
      color: #333333; /* 深色字体 */
      font-family: 'Arial', sans-serif;
      font-size: 24px; /* 字体大小 */
      text-align: center; /* 文字居中 */
      margin: 20px 0; /* 上下边距 */
      padding: 10px; /* 内边距 */
      border: 1px solid #666666; /* 边框 */
      border-radius: 5px; /* 圆角边框 */
      box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3); /* 阴影 */
      background-color: #f0f0f0; /* 背景颜色 */
    }

    /* 美化登录记录字体 */
    p {
      color: #ffffff; /* 白色字体 */
      font-family: 'Arial', sans-serif;
      font-size: 16px; /* 字体大小 */
      text-align: center; /* 文字居中 */
      margin: 10px 0; /* 上下边距 */
      padding: 5px; /* 内边距 */
      border-bottom: 1px solid #cccccc; /* 下边框 */
    }


    .container::before {
      content: none; /* 移除伪元素 */
    }

    @keyframes move {
      0% {
        background-position: 0 0;
      }
      100% {
        background-position: 40px 40px;
      }
    }
  </style>
</head>
<body>
<div class="container">
  <h2>欢迎访问web2</h2>
  <div class="button-container">
    <!-- 登出按钮 -->
    <form action="${pageContext.request.contextPath}/LogoutServlet" method="post" style="display:inline;">
      <button type="submit" class="btn">
        <strong>登出</strong>
        <div class="container-stars">
          <div class="stars"></div>
        </div>
        <div class="glow">
          <div class="circle"></div>
          <div class="circle"></div>
        </div>
      </button>
    </form>

    <!-- 刷新按钮 -->
    <form action="${pageContext.request.contextPath}/RefreshInfoServlet" method="get" style="display:inline;">
      <button type="submit" class="btn">
        <strong>刷新</strong>
        <div class="container-stars">
          <div class="stars"></div>
        </div>
        <div class="glow">
          <div class="circle"></div>
          <div class="circle"></div>
        </div>
      </button>
    </form>

    <!-- 进入web1按钮 -->
    <a href="${pageContext.request.contextPath}/OtherWeb" class="btn" style="text-decoration: none;">
      <strong>进入web1</strong>
      <div class="container-stars">
        <div class="stars"></div>
      </div>
      <div class="glow">
        <div class="circle"></div>
        <div class="circle"></div>
      </div>
    </a>
  </div>

  <%
    // 获取存储用户登录信息的 HashMap
    HashMap<String, Date> userLoginMessage = SelfCache.userLoginMessage;
    // 检查 HashMap 是否为空
    if (userLoginMessage != null && !userLoginMessage.isEmpty()) {
      // 获取 HashMap 中的键集合
      Set<String> keys = userLoginMessage.keySet();
      // 迭代键集合并逐行展示 HashMap 中的信息
      Iterator<String> iterator = keys.iterator();
      while (iterator.hasNext()) {
        String key = iterator.next();
        Date loginDate = userLoginMessage.get(key);

        String dateTime = String.format("%tF", loginDate) + "   " + String.format("%tr", loginDate);
        String showInfo = String.format("%-40s | %20s", "用户：" + key, "登录时间：" + dateTime);
  %>
  <p><%= showInfo %></p>
  <%
    }
  } else {
  %>
  <p>No user login information available.</p>
  <%
    }
  %>
</div>
</body>
</html>