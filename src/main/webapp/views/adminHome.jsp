<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--  <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/> --%>
<title><spring:message code="adminHome.label.titulo" /></title>
</head>
<body>
     <form:form action="adminHome" method="POST" modelAttribute="usuario">
        <table>
            <tr>
                <td><form:label path="nombre">
                        <spring:message code="adminHome.label.nombre" />
                    </form:label></td>
                <td><form:input path="nombre"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="correo">
                        <spring:message code="adminHome.label.correo" />
                    </form:label></td>
                <td><form:input path="correo"></form:input></td>
            </tr>
            <tr>
                <td><form:label path="password">
                        <spring:message code="adminHome.label.password" />
                    </form:label></td>
                <td><form:input path="password"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value=<spring:message code="adminHome.button.guardar" /> /></td>
            </tr>
        </table>
    </form:form>
    <br />
    <br />
    <table align="center" border="1" cellspacing="0">
        <thead>
            <tr>
                <td><spring:message code="adminHome.label.nombre" /></td>
                <td><spring:message code="adminHome.label.correo" /></td>
                <%--                 <td><spring:message code="adminHome.label.nombre"/></td> --%>
                <%--                 <td><spring:message code="adminHome.label.nombre"/></td> --%>
                <td><spring:message code="adminHome.label.eliminar" /></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user" varStatus="status">
                <tr id="row_${user.id}">
                    <td>${user.nombre}</td>
                    <td>${user.correo}</td>
                    <td><a href="adminHome/delete/${user.id}"><spring:message code="adminHome.label.eliminar" /></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br />
    <br />
</body>
</html>