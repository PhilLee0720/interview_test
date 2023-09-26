<%@ page import="com.lee.util.CaptchaUtil" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        label, input[type="text"], input[type="password"], input[type="email"], input[type="submit"] {
            display: block;
            width: 100%;
            margin-bottom: 10px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"], input[type="password"], input[type="email"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 10px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Login Form</h1>
    <form action="${pageContext.request.contextPath}/login.do" method="GET">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <label for="captcha">验证码：</label>
        <input type="text" id="captcha" name="captcha" required>
        <img src="${pageContext.request.contextPath}/code" alt="验证码">
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>