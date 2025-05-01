<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出成功</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f7f7f7;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* From Uiverse.io by elijahgummer */
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            width: 100%;
            height: 100%;
            background: lightblue;
            position: relative;
            overflow: hidden;
        }

        .container::before {
            content: "";
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, #3498db 10%, transparent 20%),
            radial-gradient(circle, transparent 10%, #3498db 20%);
            background-size: 30px 30px; /* Adjust the size of the pattern */
            animation: moveBackground 8s linear infinite; /* Adjust the animation duration and timing function */
        }

        @keyframes moveBackground {
            0% {
                transform: translate(0, 0);
            }
            100% {
                transform: translate(20%, 20%);
            }
        }



        /* From Uiverse.io by SouravBandyopadhyay */
        .notification {
            display: flex;
            flex-direction: column;
            isolation: isolate;
            position: relative;
            width: 18rem;
            height: 8rem;
            background: #29292c;
            border-radius: 1rem;
            overflow: hidden;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            font-size: 16px;
            --gradient: linear-gradient(to bottom, #2eadff, #3d83ff, #7e61ff);
            --color: #32a6ff;
            margin-bottom: 20px;
        }

        .notification:before {
            position: absolute;
            content: "";
            inset: 0.0625rem;
            border-radius: 0.9375rem;
            background: #18181b;
            z-index: 2
        }

        .notification:after {
            position: absolute;
            content: "";
            width: 0.25rem;
            inset: 0.65rem auto 0.65rem 0.5rem;
            border-radius: 0.125rem;
            background: var(--gradient);
            transition: transform 300ms ease;
            z-index: 4;
        }

        .notification:hover:after {
            transform: translateX(0.15rem)
        }

        .notititle {
            color: var(--color);
            padding: 0.65rem 0.25rem 0.4rem 1.25rem;
            font-weight: 500;
            font-size: 1.1rem;
            transition: transform 300ms ease;
            z-index: 5;
        }

        .notification:hover .notititle {
            transform: translateX(0.15rem)
        }

        .notibody {
            color: #99999d;
            padding: 0 1.25rem;
            transition: transform 300ms ease;
            z-index: 5;
        }

        .notification:hover .notibody {
            transform: translateX(0.25rem)
        }

        .notiglow,
        .notiborderglow {
            position: absolute;
            width: 20rem;
            height: 20rem;
            transform: translate(-50%, -50%);
            background: radial-gradient(circle closest-side at center, white, transparent);
            opacity: 0;
            transition: opacity 300ms ease;
        }

        .notiglow {
            z-index: 3;
        }

        .notiborderglow {
            z-index: 1;
        }

        .notification:hover .notiglow {
            opacity: 0.1
        }

        .notification:hover .notiborderglow {
            opacity: 0.1
        }

        .note {
            color: var(--color);
            position: fixed;
            top: 80%;
            left: 50%;
            transform: translateX(-50%);
            text-align: center;
            font-size: 0.9rem;
            width: 75%;
        }


        /* From Uiverse.io by kirzin */
        button {
            text-decoration: none;
            position: relative;
            border: none;
            font-size: 16px; /* 增大字体大小 */
            font-weight: bold; /* 加粗字体 */
            font-family: inherit;
            cursor: pointer;
            color: #fff; /* 字体颜色为白色 */
            width: 120px; /* 按钮宽度 */
            height: 40px; /* 按钮高度 */
            line-height: 40px; /* 行高与按钮高度一致，使文本垂直居中 */
            text-align: center;
            background: linear-gradient(90deg, #03a9f4, #f441a5, #ffeb3b, #03a9f4);
            background-size: 300%;
            border-radius: 30px;
            overflow: hidden; /* 防止文本溢出 */
            transition: all 0.3s ease; /* 平滑过渡效果 */
            z-index: 1;
            margin-top: 20px; /* 与通知之间的间距 */
        }

        button:hover {
            animation: ani 8s linear infinite;
            border: none;
        }

        @keyframes ani {
            0% {
                background-position: 0%;
            }

            100% {
                background-position: 400%;
            }
        }

        button:before {
            content: "";
            position: absolute;
            top: -5px;
            left: -5px;
            right: -5px;
            bottom: -5px;
            z-index: -1;
            background: linear-gradient(90deg, #03a9f4, #f441a5, #ffeb3b, #03a9f4);
            background-size: 400%;
            border-radius: 35px;
            transition: 1s;
        }

        button:hover::before {
            filter: blur(20px);
        }

        button:active {
            background: linear-gradient(32deg, #03a9f4, #f441a5, #ffeb3b, #03a9f4);
        }

    </style>
</head>
<body>
<div class="container">
    <div class="notification">
        <div class="notiglow"></div>
        <div class="notiborderglow"></div>
        <div class="notititle">您已成功退出</div>
        <div class="notibody">我们时刻欢迎您的再次访问！</div>
    </div>
    /* From Uiverse.io by Navarog21 */
    <button onclick="window.location.href='${pageContext.request.contextPath}/initpage.jsp'">
        BACK
    </button>

</div>
</body>
</html>