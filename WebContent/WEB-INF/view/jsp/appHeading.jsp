<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:importAttribute name="userDetails" />

<script language=javascript>
	function CloseWindow(){
		if(confirm('Are you sure you want to proceed with Logoff?\n(System will close the Browser.)')){
			window.open('','_self','');
			window.close();
		}
	}
</script>

<div class="helpAndLogout">
	<c:if test="${userDetails != \"Not Authenticated\"}">
		<a href="#" onclick="JavaScript:CloseWindow();">Logoff</a><br>
		${userDetails.displayName}<br><br>
	</c:if>
	<a href="${help.link}">Help</a>
</div>

<div class="appHeading">
	<h1 class="appHeading">
		<c:if test="${not empty appHeading }">
			<c:out value="${appHeading}" />
		</c:if>
		<c:if test="${empty appHeading }">
			<resource:message code="app.heading" />
		</c:if>
	</h1>
</div>
