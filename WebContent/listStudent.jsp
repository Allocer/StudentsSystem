<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<center>
<table style="border-size: 1px; border-style: solid; border-color: blue">
    <thead>
    <tr>
        <th>ID</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Data urodzenia</th>
        <th>Adres</th>
        <th colspan=2>Akcja</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.studentId}"/></td>
            <td><c:out value="${student.firstname}"/></td>
            <td><c:out value="${student.lastname}"/></td>
            <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${student.dateOfBirth}"/></td>
            <td><c:out value="${student.address}"/></td>
            <td><a href="StudentController?action=edit&studentId=<c:out value="${student.studentId}"/>">Aktualizuj</a>
            </td>
            <td><a href="StudentController?action=delete&studentId=<c:out value="${student.studentId}"/>">Usun</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="StudentController?action=insert">Dodaj studenta</a></p>
</center>
</body>
</html>