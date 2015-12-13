<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--  <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/> --%>
<title><spring:message code="circuito.titulo" /></title>
</head>
<body>
    <form:form action="circuito" method="POST" modelAttribute="circuito">
        <table>
            <tr>
                <td><form:label path="nombre">
                        <spring:message code="circuito.label.nombre" />
                    </form:label></td>
                <td><form:input path="nombre"></form:input></td>
            </tr>
            <tr>
                <td><label><spring:message code="circuito.label.pais" /></label></td>
                <td><form:select path="pais.id">
                        <form:option value="0" label="Selecciona" />
                        <form:options items="${paises}" itemValue="id" itemLabel="nombre" />
                    </form:select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value=<spring:message code="circuito.button.guardar" /> /></td>
            </tr>
        </table>
    </form:form>
    <br />
    <br />
    <table align="center" border="1" cellspacing="0">
        <thead>
            <tr>
                <td><spring:message code="circuito.label.nombre" /></td>
                <td><spring:message code="circuito.label.pais" /></td>
                <td><spring:message code="circuito.label.eliminar" /></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${circuitos}" var="circuito" varStatus="status">
                <tr id="row_${circuito.id}">
                    <td>${circuito.nombre}</td>
                    <td>${circuito.pais.nombre}</td>
                    <td><a href="circuito/delete/${circuito.id}"><spring:message code="circuito.label.eliminar" /></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br />
    <br />
</body>
</html>