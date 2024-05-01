<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/1/2024
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Present</title>
</head>
<body>
<h1>Edit Present</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="present">Back to present list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Present information</legend>
        <table>
            <tr>
                <td>CODE: </td>
                <td><input type="text" name="code" id="code" value="${requestScope['present'].getCode()}"></td>
            </tr>
            <tr>
                <td>NAME: </td>
                <td><input type="text" name="name" id="name" value="${requestScope['present'].getName()}"></td>
            </tr>
            <tr>
                <td>PRICE: </td>
                <td><input type="text" name="price" id="price" value="${requestScope['present'].getPrice()}"></td>
            </tr>
            <tr>
                <td>SHIP: </td>
                <td><input type="text" name="ship" id="ship" value="${requestScope['present'].getShip()}"></td>
            </tr>
            <tr>
                <td>IMG: </td>
                <td><input type="text" name="img" id="img" value="${requestScope['present'].getImg()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update present"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
