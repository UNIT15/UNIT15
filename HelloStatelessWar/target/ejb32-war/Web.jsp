<%-- 
    Document   : Web
    Created on : 20.04.2015, 1:35:18
    Author     : Дарья
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>People information</title>
    </head>
    <body>
        <h1>People information</h1>
        <form action="./PeopleServlet" method="POST">

        </form>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${People.name}"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="last name" value="${People.lastname}"/></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" value="${People.age}"/></td>
            </tr>
        </tr>
        <td colspan="2">
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="Edit"/>
            <input type="submit" name="action" value="Delete"/>
            <input type="submit" name="action" value="Search"/>
        </td>
    </tr>
</table>
<br>
<table border="1">
    <th>Name</th>
    <th>Last Name</th>
    <th>Age</th>
        <c:forEach items="${AllPeople}" var="peop">
        <tr>
            <td>${peop.name}<td>
            <td>>${peop.lastname}<td>
            <td>>${peop.age}<td>

        <tr>
        </c:forEach>
</table>
</body>
</html>
