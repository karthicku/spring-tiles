<!-- IE into quirks mode -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
	<%
String basePath = request.getScheme() + "://"
        + request.getServerName() + ":" + request.getServerPort()
        + request.getContextPath();
	System.out.println("path :"+basePath);
%>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>/themes/ffLowesStyle.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/themes/appStyle.css"/>


<%-- 		<title>
			<c:if test="${not empty browserTitle }">
				${browserTitle}
			</c:if>
			<c:if test="${empty browserTitle }">
				<resource:message code="browser.title" />
			</c:if>
		</title> --%>
	</head>
 
	<body>
		<div id="leftNavMin">
			<table class="leftNavMin">
				<tr>
					<td class="leftMaximize">
						<div id="leftMaximize" align="right">
							<a href="javascript:void(0)" class="minMax" onclick="maximizeLeftNav()"> -> </a>
						</div>
					</td>
				</tr>
			</table>
		</div>

		<div id="leftNav">
			<div class="leftNav-inner">
				<tiles:insertAttribute name="leftNav-tile"/>
			</div>
		</div>
		 
		<div id="contentMin">
			<div class="inner">
				<tiles:insertAttribute name="pageHeading-tile"/>
				<tiles:insertAttribute name="content"/>
			</div>
		</div>
		
		<div id="contentMax">
			<div class="inner">
				<tiles:insertAttribute name="pageHeading-tile"/>
				<tiles:insertAttribute name="content"/>
			</div>
		</div>
		
		<div id="app-heading">
			<div id="logo">
				<tiles:insertAttribute name="logo-tile"/>
			</div>
			<tiles:insertAttribute name="appHeading-tile"/>
		</div>
		
		<div id="top-nav">
			<tiles:insertAttribute name="topMenu-tile"/>
		</div>
		
		<div class="footer">
			<tiles:insertAttribute name="footer-tile"/>
		</div>
	</body>
</html>