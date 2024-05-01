<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/1/2024
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Present List</title>
</head>
<body>

<h1>Present List</h1>
<p>
    <a href="present?action=create">Create new present</a>
</p>

<table border="=1">
    <tr>
        <td>ID</td>
        <td>CODE</td>
        <td>NAME</td>
        <td>PRICE</td>
        <td>SHIP</td>
        <td>IMG</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${requestScope['present']}" var="pr">
        <tr>
            <td><a href="present?action=view&id=${pr.getId()}">${pr.getId()}</a></td>
            <td>${pr.getCode()}</td>
            <td>${pr.getName()}</td>
            <td>${pr.getPrice()}</td>
            <td>${pr.getShip()}</td>
            <td>${pr.getImg()}</td>
            <td><a href="present?action=edit&id=${pr.getId()}">edit</a></td>
            <td><a href="present?action=delete&id=${pr.getId()}">delete</a></td>

        </tr>
    </c:forEach>
</table>


</body>
</html>
