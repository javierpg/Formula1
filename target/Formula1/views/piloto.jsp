<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%--  <link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/> --%>
<title><spring:message code="piloto.titulo" /></title>
<link href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" rel="stylesheet"></link>
<script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
<!-- <script type="text/javascript" src="validator.js"></script> -->
</head>
<body>
    <form:form id="altaPiloto" action="piloto" method="POST" modelAttribute="piloto">
        <table>
            <tr>
                <td><form:label path="nombre">
                        <spring:message code="piloto.label.nombre" />
                    </form:label></td>
                <td><form:input id="nombre" path="nombre"></form:input></td>
            </tr>
            <tr>
                <td><label><spring:message code="piloto.label.pais" /></label></td>
                <td><form:select path="pais.id">
                        <form:option value="0" label="Selecciona" />
                        <form:options items="${paises}" itemValue="id" itemLabel="nombre" />
                    </form:select></td>
            </tr>
            <tr>
                <td><label><spring:message code="piloto.label.escuderia" /></label></td>
                <td><form:select path="escuderia.id">
                        <form:option value="0" label="Selecciona" />
                        <form:options items="${escuderias}" itemValue="id" itemLabel="nombre" />
                    </form:select></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value=<spring:message code="piloto.button.guardar" /> /></td>
            </tr>
        </table>
    </form:form>
    <br />
    <br />
    <table class="table table-striped">
        <thead>
            <tr>
                <th><spring:message code="piloto.label.nombre" /></th>
                <th><spring:message code="piloto.label.pais" /></th>
                <th><spring:message code="piloto.label.escuderia" /></th>
                <th><spring:message code="piloto.label.eliminar" /></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pilotos}" var="piloto" varStatus="status">
                <tr id="row_${piloto.id}">
                    <td>${piloto.nombre}</td>
                    <td>${piloto.pais.nombre}</td>
                    <td>${piloto.escuderia.nombre}</td>
                    <td><a href="piloto/delete/${piloto.id}"><spring:message code="piloto.label.eliminar" /></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br />
    <br />
</body>
<script type=”text/javascript”>
    <script>
    $(document).ready(function() {
        alert( "document loaded");
    });
 
    $(window).load(function() {
       alert("window loaded");
    });
</script>
</html>