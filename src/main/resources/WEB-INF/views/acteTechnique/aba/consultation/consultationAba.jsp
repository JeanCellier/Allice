<%@ include file="../../../headersimplifie.jsp" %>

<h1>Fiche ABA : ${nom}</h1>

<div id="partieCentrale">

	<%@ include file="enteteAba.jsp" %>
	<%@ include file="infoGeneralAba.jsp" %>
	<%@ include file="collecteMaturationAba.jsp" %>
	<%@ include file="fecondationInVitroAba.jsp" %>
	<%@ include file="cultureInVitroAba.jsp" %>
	<%@ include file="infoSiCryoAba.jsp" %>

</div>

<%@ include file="../../../footersimplifie.jsp" %>

