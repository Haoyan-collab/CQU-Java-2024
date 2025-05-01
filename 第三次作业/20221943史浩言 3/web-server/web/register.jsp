
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>注册页面</title>
  <style>
    /* 样式表可以在这里添加 */
    /* From Universe.io by Pinparker, adapted for Register Page */
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh; /* 使body高度充满整个视口 */
      margin: 0; /* 移除默认的body边距 */
      background-color: #000; /* 设置背景颜色以对比表单 */
    }
    .form.register-form {
      transform: scale(1.5);
      transform-origin: center center; /* 设置缩放的基点为中心 */
      position: relative;
      display: block;
      padding: 2.2rem;
      max-width: 350px;
      background: linear-gradient(
              14deg,
              rgba(2, 0, 36, 0.8) 0%,
              rgba(24, 24, 65, 0.7) 66%,
              rgb(20, 76, 99) 100%
      ),
      radial-gradient(
              circle,
              rgba(2, 0, 36, 0.5) 0%,
              rgba(32, 15, 53, 0.2) 65%,
              rgba(14, 29, 28, 0.9) 100%
      );
      border: 2px solid #fff;
      -webkit-box-shadow: rgba(0, 212, 255) 0px 0px 50px -15px;
      box-shadow: rgba(0, 212, 255) 0px 0px 50px -15px;
      overflow: hidden;
      z-index: +1;
      border-radius: 8px;
    }

    .form-title {
      font-size: 1.25rem;
      line-height: 1.75rem;
      font-family: monospace;
      font-weight: 600;
      text-align: center;
      color: #fff;
      text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.7);
      animation-duration: 1.5s;
      overflow: hidden;
      transition: 0.12s;
    }

    .form-title span {
      animation: flickering 2s linear infinite both;
    }


    .input-container {
      position: relative;
      margin-bottom: 1.5rem;
    }

    .input-container input {
      outline: none;
      border: 2px solid #ffffff;
      padding: 0.5rem;
      font-family: monospace;
      border-radius: 4px;
      background-color: #fff;
      width: 100%;
      box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
    }

    .submit {
      position: relative;
      display: block;
      padding: 0.75rem;
      background: linear-gradient(90deg, #243949 0%, #517fa4 100%);
      color: #ffffff;
      text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.5);
      font-size: 0.875rem;
      line-height: 1.25rem;
      font-weight: 500;
      width: 100%;
      text-transform: uppercase;
      overflow: hidden;
      border: none;
      cursor: pointer;
    }

    .submit:hover {
      -webkit-transition: all 0.2s ease-out;
      -moz-transition: all 0.2s ease-out;
      transition: all 0.2s ease-out;
      box-shadow: 4px 5px 17px -4px #ffffff;
    }

    @keyframes flickering {
      0%,
      100% {
        opacity: 1;
      }
      41.99% {
        opacity: 1;
      }
      42% {
        opacity: 0;
      }
      43% {
        opacity: 0;
      }
      43.01% {
        opacity: 1;
      }
      47.99% {
        opacity: 1;
      }
      48% {
        opacity: 0;
      }
      49% {
        opacity: 0;
      }
      49.01% {
        opacity: 1;
      }
    }

    .bg-stars {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      z-index: -2;
      background-size: cover;
      animation: animateBg 50s linear infinite;
    }

    @keyframes animateBg {
      0%,
      100% {
        transform: scale(1);
      }
      50% {
        transform: scale(1.2);
      }
    }

    .star {
      position: absolute;
      top: 50%;
      left: 50%;
      width: 4px;
      height: 4px;
      background: #fff;
      border-radius: 50%;
      box-shadow: 0 0 0 4px rgba(255, 255, 255, 0.1),
      0 0 0 8px rgba(255, 255, 255, 0.1), 0 0 20px rgba(255, 255, 255, 0.1);
      animation: animate 3s linear infinite;
    }

    .star::before {
      content: "";
      position: absolute;
      top: 50%;
      transform: translateY(-50%);
      width: 300px;
      height: 1px;
      background: linear-gradient(90deg, #fff, transparent);
    }

    @keyframes animate {
      0% {
        transform: rotate(315deg) translateX(0);
        opacity: 1;
      }
      70% {
        opacity: 1;
      }
      100% {
        transform: rotate(315deg) translateX(-1000px);
        opacity: 0;
      }
    }

    .star:nth-child(1) {
      top: 0;
      right: 0;
      left: initial;
      animation-delay: 0s;
      animation-duration: 1s;
    }

    .star:nth-child(2) {
      top: 0;
      right: 100px;
      left: initial;
      animation-delay: 0.2s;
      animation-duration: 3s;
    }

    .star:nth-child(3) {
      top: 0;
      right: 220px;
      left: initial;
      animation-delay: 2.75s;
      animation-duration: 2.75s;
    }

    .star:nth-child(4) {
      top: 0;
      right: -220px;
      left: initial;
      animation-delay: 1.6s;
      animation-duration: 1.6s;
    }
  </style>
  <script>
    window.onload = function() {
      var message = "${message}";
      var messageType = "${messageType}";

      if (message) {
        alert(messageType === "error" ? "错误: " + message : "成功: " + message);
      }
    };
  </script>
</head>
<body>
<form class="form register-form" action="${pageContext.request.contextPath}/RegisterServlet" method="post">
  <div class="form-title"><span>注册您的账号</span></div>

  <div class="input-container">
    <input placeholder="用户名" type="text" name="username" class="input-user" required />
    <span> </span>
  </div>

  <section class="bg-stars">
    <span class="star"></span>
    <span class="star"></span>
    <span class="star"></span>
    <span class="star"></span>
  </section>

  <div class="input-container">
    <input placeholder="密码" type="password" name="password" class="input-pwd" required />
  </div>

  <div class="input-container">
    <input placeholder="确认密码" type="password" name="confirmPassword" class="input-pwd" required />
  </div>

  <button class="submit" type="submit">
    <span class="sign-text">注册</span>
  </button>
</form>
</body>
</html>
