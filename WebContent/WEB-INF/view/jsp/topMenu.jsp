
<tiles:importAttribute name="topMenuList" />

<ul class="topMenu">
	<c:forEach var="nav" items="${topMenuList}" varStatus="status">
		<li class="topMenu">
			<a class="topMenu" href="${nav.link}"><c:out value="${nav.label}"/></a>
		</li>
	</c:forEach>
	<li class="topMenu">
		&nbsp;
	</li>
</ul>
