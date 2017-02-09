<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<!-- <link rel="stylesheet" type="text/css" media="all" href="static/css/style.css"/> -->
		<link rel="stylesheet" type="text/css" media="all" href="../../../static/css/style.css"/>
	</head>

	<body>
		<div id="menu">
			<!-- Bouton accueil et retour -->
			<a class="accueil" href="<s:url value='/'/>">Accueil</a>
			<input class="retour" type="button" value="Retour" onClick="window.history.back()">
			<!-- Rajouter fonction pour bouton pour retour => bloquer lorsqu'on est à l'accueil -->
		</div>

	</body>
</html>

