<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>web2初始页面</title>
    <style>
        /* From Uiverse.io by jeremyssocial */
        .container {
            /* Basic dimensions and centering */
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

            /* Dark mode colors and gradient */
            background: #121212; /* Fallback for browsers that don't support gradients */
            background: linear-gradient(
                    135deg,
                    #121212 25%,
                    #1a1a1a 25%,
                    #1a1a1a 50%,
                    #121212 50%,
                    #121212 75%,
                    #1a1a1a 75%,
                    #1a1a1a
            );
            background-size: 40px 40px;

            /* Animation */
            animation: move 4s linear infinite;
        }

        @keyframes move {
            0% {
                background-position: 0 0;
            }
            100% {
                background-position: 40px 40px;
            }
        }

        body {
            background-color: #2b2b2b; /* 暗色背景 */
            color: #ffffff; /* 白色字体 */
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh; /* 使内容垂直居中 */
        }

        h1 {
            color: #ffffff; /* 白色字体 */
            margin-bottom: 20px; /* 下边距 */
        }

        /* From Uiverse.io by Smit-Prajapati */
        .button {
            /* in scss with just one variable i can change opacity with rgba(variable, opacity) but in css it's not possible so i have used three seperate variables */
            /* with hue-rotate color can be changed */
            --main-color: rgb(46, 213, 115);
            --main-bg-color: rgba(46, 213, 116, 0.36);
            --pattern-color: rgba(46, 213, 116, 0.073);

            /* change this rotation value */
            filter: hue-rotate(0deg);

            cursor: pointer;
            text-transform: uppercase;
            letter-spacing: 0.5rem;
            background: radial-gradient(
                    circle,
                    var(--main-bg-color) 0%,
                    rgba(0, 0, 0, 0) 95%
            ),
            linear-gradient(var(--pattern-color) 1px, transparent 1px),
            linear-gradient(to right, var(--pattern-color) 1px, transparent 1px);
            background-size:
                    cover,
                    15px 15px,
                    15px 15px;
            background-position:
                    center center,
                    center center,
                    center center;
            border-image: radial-gradient(
                    circle,
                    var(--main-color) 0%,
                    rgba(0, 0, 0, 0) 100%
            )
            1;
            border-width: 1px 0 1px 0;
            color: var(--main-color);
            padding: 1rem 3rem;
            font-weight: 700;
            font-size: 1.5rem;
            transition: background-size 0.2s ease-in-out;
        }

        .button:hover {
            background-size:
                    cover,
                    10px 10px,
                    10px 10px;
        }
        .button:active {
            filter: hue-rotate(250deg);
        }

        /* 其他样式和动画保持不变 */
    </style>
</head>
<body>
<div class="container">
    <h1>web2</h1>
    <a href="${pageContext.request.contextPath}/index.jsp" class="button" role="button">Start</a>
</div>
</body>
</html>