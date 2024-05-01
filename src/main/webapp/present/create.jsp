<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/1/2024
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create new Present</title>
</head>
<body>

<h1>Create new Present</h1>
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
        <legend> Present Information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>CODE: </td>
                <td><input type="text" name="code" id="code"></td>
            </tr>
            <tr>
                <td>NAME: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>PRICE: </td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>SHIP: </td>
                <td><input type="text" name="ship" id="ship"></td>
            </tr>
            <tr>
                <td>IMG: </td>
                <td><input type="text" name="img" id="img"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create present"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
