<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--  <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/> --%>
<title><spring:message code="pais.titulo" /></title>
</head>
<body>
    <form:form action="pais" method="POST" modelAttribute="pais">
        <table>
            <tr>
                <td><form:label path="nombre">
                        <spring:message code="pais.label.nombre" />
                    </form:label></td>
                <td><form:input path="nombre"></form:input></td>
            </tr>  
            <tr>
                <td></td>
                <td><input type="submit"value=<spring:message code="pais.button.guardar" /> /></td>
            </tr>
        </table>
    </form:form>
    <br />
    <br />
    <table align="center" border="1" cellspacing="0">
        <thead>
            <tr>
                <td><spring:message code="pais.label.nombre" /></td>
                <td><spring:message code="pais.label.eliminar" /></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${paises}" var="pais" varStatus="status">
                <tr id="row_${pais.id}">
                    <td>${pais.nombre}</td>
                    <td><a href="pais/delete/${pais.id}"><spring:message code="pais.label.eliminar" /></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br />
    <br />
</body>
</html>