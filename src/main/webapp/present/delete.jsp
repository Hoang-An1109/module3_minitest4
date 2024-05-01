<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/1/2024
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Present</title>
</head>
<body>
<h1>Delete Present</h1>
<p>
    <a href="/present">Back to present list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Present information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td>${requestScope["present"].getId()}</td>
            </tr>
            <tr>
                <td>CODE: </td>
                <td>${requestScope["present"].getCode()}</td>
            </tr>
            <tr>
                <td>NAME: </td>
                <td>${requestScope["present"].getName()}</td>
            </tr>
            <tr>
                <td>PRICE: </td>
                <td>${requestScope["present"].getPrice()}</td>
            </tr>
            <tr>
                <td>SHIP: </td>
                <td>${requestScope["present"].getShip()}</td>
            </tr>
            <tr>
                <td>IMG: </td>
                <td>${requestScope["present"].getImg()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
