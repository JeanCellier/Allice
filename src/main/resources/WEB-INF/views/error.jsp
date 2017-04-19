<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" media="all" href="../../static/css/styles.css"/>
    <link rel="stylesheet" type="text/css" media="all" href="../../static/css/styleCustom.css"/>
</head>

<body>
<h1>Page d'erreur</h1>
<p>L'application a rencontr&eacute; une erreur. Veuillez lire la ligne d'exception ou contacter le support sur
    contact@polytech-tours.fr</p>
<c:if test="${url != null && exception != null}">
    <p>
        <span style="font-weight: bold;">Failed URL:</span> ${url} <br/>
        <span style="font-weight: bold;">Exception:</span> ${exception.message} <br/>
        <span style="font-weight: bold;">Trace:</span><br/>
        <c:forEach items="${exception.stackTrace}" var="ste">
            ${ste} <br/>
        </c:forEach>
    </p>
</c:if>
</body>