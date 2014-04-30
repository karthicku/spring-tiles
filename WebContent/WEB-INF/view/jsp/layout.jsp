<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<html>
<head>
<title>Flex Space Management</title>
<style type="text/css">
body {
	font-family: Arial, Verdana, sans-serif;
}

.header,.footer,.leftPane {
	border: 1px solid gray;
}

.header,.main,.footer {
	width: auto;
	color: #665544;
	clear: both;
}

.leftPane,.rightPane {
	float: left;
	height: 400px;
}

.leftPane {
	width: auto;
}

.rightPane {
	width: auto;
}

.leftMenu {
	list-style: none;
	padding: 0;
	margin: 10px;
}
</style>
</head>
<body>
<tiles:insertAttribute name="header"/>
	<div class="main">
		<tiles:insertAttribute name="menu"/>
		<div class="rightPane">
			<tiles:insertAttribute name="body"/>
		</div>
	</div>
<tiles:insertAttribute name="footer" />
	
</body>
</html>