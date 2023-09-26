<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Interview Practice</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    .practice {
      text-align: center;
      font-size: 24px;
      font-weight: bold;
      color: #333;
      padding: 20px;
      background-color: #f9f9f9;
      border-radius: 5px;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Interview Exercise</h1>
  <div class="practice">
    Interview Exercise
    <a href="pages/login.jsp">登录</a>
    <a href="pages/register.jsp">注册</a>
    <a href="${pageContext.request.contextPath}/commService/userAgent.do">访问者浏览器信息</a>
  </div>
</div>
</body>
</html>