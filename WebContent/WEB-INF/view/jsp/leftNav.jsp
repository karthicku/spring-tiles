
<tiles:importAttribute name="leftNavList" />

<script type=text/javascript>
	function minimizeLeftNav() {
		var leftNavElement = document.getElementById("leftNav");
		var leftNavMinElement = document.getElementById("leftNavMin");
		var contentMinElement = document.getElementById("contentMin");
		var contentMaxElement = document.getElementById("contentMax");
 
		leftNavElement.style.display = "none";
		leftNavMinElement.style.display = "block";
		contentMaxElement.scrollTop = contentMinElement.scrollTop;
		contentMinElement.style.visibility = "hidden";
		contentMaxElement.style.visibility = "visible";
	}
	function maximizeLeftNav() {
		var leftNavElement = document.getElementById("leftNav");
		var leftNavMinElement = document.getElementById("leftNavMin");
		var contentMinElement = document.getElementById("contentMin");
		var contentMaxElement = document.getElementById("contentMax");

		leftNavElement.style.display = "block";
		leftNavMinElement.style.display = "none";
		contentMinElement.scrollTop = contentMaxElement.scrollTop;
		contentMinElement.style.visibility = "visible";
		contentMaxElement.style.visibility = "hidden";
	}
</script>

<table class="leftNav">
	<tr>
		<td class="leftMinimize">
			<div id="leftMinimize" align="right">
				<a href="javascript:void(0)" class="minMax" onclick="minimizeLeftNav()"> &lt;- </a>
			</div>
		</td>
	</tr>
	<c:forEach var="nav" items="${leftNavList}">
		<tr>
			<c:if test="${nav.heading}">
				<td class=leftNavHeading>
					<c:choose>
					    <c:when test="${nav.link != null}">
					      <a href="${nav.link}${nav.queryString}" class=leftNavHeading><c:out value="${nav.label}" /></a>
					    </c:when>
					    <c:otherwise>
					      <c:out value="${nav.label}" />
					    </c:otherwise>
					</c:choose>
				</td>
			</c:if>
			<c:if test="${!nav.heading}">
				<c:if test="${nav.label != null}">
					<td>
						<div id="para1">
							<a href="${nav.link}${nav.queryString}" class="leftNav"><c:out value="${nav.label}" /></a>
						</div>
					</td>
				</c:if>
				<c:if test="${nav.label == null}">
					<td class="dynLeftNav">
						<c:choose>
						    <c:when test="${nav.html != null}">
								${nav.html}
						    </c:when>
						    <c:otherwise>
								${nav.queryString}
						    </c:otherwise>
						</c:choose>
					</td>
				</c:if>
			</c:if>
		</tr>
	</c:forEach>
	<tr>
		<td class="helpHeaderTd">
			<div id="helpHeader"></div>
		</td>
	</tr>
	<tr>
		<td class="helpTextTd">
			<div id="helpTextDiv"></div>
		</td>
	</tr>
</table>
