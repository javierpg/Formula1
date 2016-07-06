<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="circuito.titulo" /></title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"></link>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css"
    rel="stylesheet"></link>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/css/bootstrapValidator.css"
    rel="stylesheet"></link>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js" rel="stylesheet"></link>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"
    rel="stylesheet"></link>
</head>
<body>
    <br />
    <br />
    <br />
    <c:if test="${hasErrors}">
        <div class="form-group">
            <h2>
                <label class="col-md-12 control-label label label-danger" rows="5" id="errorTextArea"><span
                    class="glyphicon glyphicon-warning-sign"></span>&nbsp;&nbsp;&nbsp;${errorMessage}</textarea>
            </h2>
        </div>
        <br />
        <br />
    </c:if>    
    <form:form action="circuito/search" method="POST" modelAttribute="circuito" class="form-horizontal"
        data-toggle="validator">
        <div class="form-group">
            <form:label path="nombre" class="col-md-3 control-label">
                <spring:message code="circuito.label.nombre" />
            </form:label>
            <div class="col-md-5">
                <form:input id="nombre" type="text" path="nombre" class="form-control"></form:input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label"><spring:message code="circuito.label.pais" /></label>
            <div class="col-md-5">
                <form:select path="idPais">
                    <form:option value="0" label="Selecciona" />
                    <form:options items="${paises}" itemValue="id" itemLabel="nombre" />
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-11">
                <input type="submit" class="btn btn-primary pull-right"
                    value=<spring:message code="circuito.button.buscar" /> />
            </div>
        </div>
    </form:form>
    <br />
    <br />
    <table class="table table-striped table-hover">
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
                    <td>${circuito.nombrePais}</td>
                    <td><a href="circuito/delete/${circuito.id}"> <span class="glyphicon glyphicon-remove"></span> </a></td>                     
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br />
    <br />
    <br />
    <br />
    <!-- Button modal alta -->
    <div class="form-group">
        <div class="col-md-11">
            <button type="button" class="btn btn-primary pull-right" data-toggle="modal"
                data-target="#modalAltaCircuito">
                <spring:message code="circuito.button.alta" />
            </button>
        </div>
    </div>
    <br />
    <br />
    <br />
    <!--     Modal -->
    <div id="modalAltaCircuito" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!--             Modal content -->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">
                        <spring:message code="circuito.modalAlta.header" />
                    </h4>
                </div>
                <form:form action="circuito" method="POST" modelAttribute="circuito" class="form-horizontal"
                    data-toggle="validator">
                                        <div class="modal-body">
                    <div class="form-group">
                        <form:label path="nombre" class="col-md-3 control-label">
                            <spring:message code="circuito.label.nombre" />
                        </form:label>
                        <div class="col-md-5">
                            <form:input id="nombre" type="text" path="nombre" class="form-control"></form:input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label"><spring:message code="circuito.label.pais" /></label>
                        <div class="col-md-5">
                            <form:select path="idPais">
                                <form:option value="0" label="Selecciona" />
                                <form:options items="${paises}" itemValue="id" itemLabel="nombre" />
                            </form:select>
                        </div>
                    </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-default"
                                value=<spring:message code="circuito.button.guardar" /> />
                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                <spring:message code="circuito.modalAlta.button.cerrar" />
                            </button>
                        </div>   
                    </div>
                </form:form>
            </div>

        </div>
    </div>
</body>
</html>