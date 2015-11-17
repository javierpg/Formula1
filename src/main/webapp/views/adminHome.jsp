<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--  <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/> --%>
<title>TITULO ADMIN</title>
</head>
<body>
    <h1>ADMIN</h1>
    <form:form action="adminHome" method="POST" modelAttribute="usuario">
        <table>
            <tr>
                <td> <form:label path="nombre"><spring:message code="adminHome.label.nombre"/></form:label></td>
                <td><form:input path="nombre"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Texto boton"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>