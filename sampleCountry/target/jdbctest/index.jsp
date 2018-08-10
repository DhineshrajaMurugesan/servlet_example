<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Country Application</title>
</head>
<body>
<center>
    <h1>Country Management</h1>
    <h2>
        <a href="/new">Add New Country</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/country">List All Countries</a>
         
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Countries</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Abbrevation</th>
        </tr>
        <c:forEach var="country" items="${list}">
            <tr>
                <td><c:out value="${country.id}" /></td>
                <td><c:out value="${country.name}" /></td>
                <td><c:out value="${country.abrrev}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>   
</body>
</html>
