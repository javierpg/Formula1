<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
    <a class="btn btn-large btn-primary right" href="/Formula1/admin/adminHome"><spring:message code="adminMenu.item.admin" /></a>
    <a class="btn btn-large btn-primary right" href="/Formula1/admin/pais"><spring:message code="adminMenu.item.pais" /></a>
    <a class="btn btn-large btn-primary right" href="/Formula1/admin/escuderia"><spring:message code="adminMenu.item.escuderia" /></a>
    <a class="btn btn-large btn-primary right" href="/Formula1/admin/piloto"><spring:message code="adminMenu.item.piloto" /></a>
</body>
</html>