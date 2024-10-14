<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <jsp:useBean id="sb" scope="request" type="ua.mk.berkut.lecture5_web.beans.StudentBean"/>
    <table>
        <thead>
            <tr><th>#</th><th>Name</th><th>age</th><th>rating</th></tr>
        </thead>
        <tbody>
            <c:forEach var="s" items="${sb.students}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.age}</td>
                    <td>${s.rating}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="hello-servlet" method="post">
        <input type="text" name="name">
        <input type="number" name="age">
        <input type="number" step="0.1" name="rating">
        <button type="submit">Add</button>
    </form>
</body>
</html>
