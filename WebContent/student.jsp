<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Dodaj studenta</title>
</head>
<body>
<script>
    $(function () {
        $('input[name=dateOfBirth]').datepicker();
    });
</script>

<center>
    <form method="POST" action='StudentController' name="frmAddStudent">
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" readonly="readonly" name="studentId" value="<c:out value="${student.studentId}" />"/></td>
            </tr>
            <tr>
                <td>Imie</td>
                <td><input type="text" name="firstname" value="<c:out value="${student.firstname}" />"/></td>
            </tr>
            <tr>
                <td>Nazwisko</td>
                <td><input type="text" name="lastname" value="<c:out value="${student.lastname}" />"/></td>
            </tr>
            <tr>
                <td>Data urodzenia</td>
                <td><input type="text" name="dateOfBirth" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${student.dateOfBirth}" />"/></td>
            </tr>
            <tr>
                <td>Adres</td>
                <td><input type="text" name="address" value="<c:out value="${student.address}" />"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Zapisz"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>