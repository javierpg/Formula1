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
<!-- <link href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" rel="stylesheet"></link> -->
<!-- <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script> -->
<!-- <script type="text/javascript" src="validator.js"></script> -->
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"></link> -->
<!-- <link href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" rel="stylesheet"></link> -->
<!-- <script src="//oss.maxcdn.com/jquery/1.11.1/jquery.min.js"></script> -->
<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
<!-- <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script> -->
<!-- <script type="text/javascript" src="validator.js"></script> -->
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
    <form:form id="buscarPiloto" action="piloto/search" method="POST" modelAttribute="piloto" class="form-horizontal"
        data-toggle="validator">

        <!--         <div class="form-group has-feedback"> -->
        <%--             <form:label path="nombre" class="col-md-3 control-label"> --%>
        <%--                 <spring:message code="piloto.label.nombre" /> --%>
        <%--             </form:label> --%>
        <!--             <div class="col-md-5"> -->
        <%--                 <form:input id="nombre" type="text" path="nombre" class="form-control" data-minlength="5" required="true"></form:input> --%>
        <!--             </div> -->
        <!--             <span class="glyphicon form-control-feedback" aria-hidden="true"></span> -->
        <!--             <div class="help-block with-errors">Hey look, this one has feedback icons!</div> -->
        <!--         </div> -->

        <div class="form-group">
            <form:label path="nombre" class="col-md-3 control-label">
                <spring:message code="piloto.label.nombre" />
            </form:label>
            <div class="col-md-5">
                <form:input id="nombre" type="text" path="nombre" class="form-control"></form:input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label"><spring:message code="piloto.label.pais" /></label>
            <div class="col-md-5">
                <form:select path="idPais">
                    <form:option value="0" label="Selecciona" />
                    <form:options items="${paises}" itemValue="id" itemLabel="nombre" />
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label"><spring:message code="piloto.label.escuderia" /></label>
            <div class="col-md-5">
                <form:select path="idEscuderia">
                    <form:option value="0" label="Selecciona" />
                    <form:options items="${escuderias}" itemValue="id" itemLabel="nombre" />
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-11">
                <input type="submit" class="btn btn-primary pull-right"
                    value=<spring:message code="piloto.button.buscar" /> />
            </div>
        </div>

    </form:form>
    <br />
    <br />
    <table class="table table-striped table-hover">
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
                    <td>${piloto.nombrePais}</td>
                    <td>${piloto.nombreEscuderia}</td>
                    <td><a href="piloto/delete/${piloto.id}"> <span class="glyphicon glyphicon-remove"></span>
                    </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br />
    <br />
    <!-- Button modal alta -->
    <div class="form-group">
        <div class="col-md-11">
            <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#modalAltaPiloto">
                <spring:message code="piloto.button.alta" />
            </button>
        </div>
    </div>
    <br />
    <br />
    <br />
    <!--     Modal -->
    <div id="modalAltaPiloto" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <!--             Modal content -->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">
                        <spring:message code="piloto.modalAlta.header" />
                    </h4>
                </div>
                <form:form id="altaPiloto" action="piloto" method="POST" modelAttribute="piloto" class="form-horizontal">
                    <div class="modal-body">
                        <div class="form-group">
                            <form:label path="nombre" class="col-md-3 control-label">
                                <spring:message code="piloto.label.nombre" />
                            </form:label>
                            <div class="col-md-5">
                                <form:input id="nombre" type="text" path="nombre" class="form-control"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"><spring:message code="piloto.label.pais" /></label>
                            <div class="col-md-5">
                                <form:select path="idPais">
                                    <form:option value="0" label="Selecciona" />
                                    <form:options items="${paises}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"><spring:message code="piloto.label.escuderia" /></label>
                            <div class="col-md-5">
                                <form:select path="idEscuderia">
                                    <form:option value="0" label="Selecciona" />
                                    <form:options items="${escuderias}" itemValue="id" itemLabel="nombre" />
                                </form:select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" class="btn btn-default"
                                value=<spring:message code="piloto.button.guardar" /> />
                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                <spring:message code="piloto.modalAlta.button.cerrar" />
                            </button>
                        </div>
                </form:form>
            </div>

        </div>
    </div>
    <!--     <script type=”text/javascript”> 
$(document).ready(function() {
$(‘#buscarPiloto’).bootstrapValidator({
    message: ‘This value is not valid’,
         feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nombre: {
                message: ‘The username is not valid’,
                validators: {
                    notEmpty: {
                        message: ‘The username is required and can\’t be empty’
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: ‘The username must be more than 6 and less than 30 characters long’
                    }

                }
            }
        }
    });
});
 </script> -->

</body>

</html>