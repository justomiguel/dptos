<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="home.title" /></title>
<meta name="menu" content="Home" />
<link href="<c:url value="/scripts/main.css" />" rel="stylesheet">
<script src="/scripts/jquery.1.10.2.min.js" type="text/javascript"></script>
<script src="/scripts/jquery.autocomplete.min.js" type="text/javascript"></script>
<script type="text/javascript">
	//javascript para el autocomplete de ciudades
	$(document).ready(function() {
		$('#locationToSearch').autocomplete({
			serviceUrl : '/getTags',
			paramName : "tagName",
			delimiter : ",",
			transformResult : function(response) {
				return {
					suggestions : $.map($.parseJSON(response), function(item) {
						return {
							value : item.tagName,
							data : item.id
						};
					})
				};
			}
		});
	});
</script>
</head>
<body class="home">
	<h2>
		<fmt:message key="home.heading" />
	</h2>


	<!-- 
    
    //menu del user
    <p><fmt:message key="home.message"/></p>
    <ul class="glassList">
        <li>
            <a href="<c:url value='/userform'/>"><fmt:message key="menu.user"/></a>
        </li>
        <li>
            <a href="<c:url value='/fileupload'/>"><fmt:message key="menu.selectFile"/></a>
        </li>
    </ul>
    
     -->
	<form:form commandName="homeSearch" method="post" action="home"
		enctype="multipart/form-data" id="mainSearchBox">
		<spring:bind path="homeSearch.locationToSearch">
			<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
		</spring:bind>
			<appfuse:label key="homeSearch.locationToSearch" styleClass="control-label" />
			<form:input cssClass="form-control" path="locationToSearch" placeHolder="${mainPlaceHolder}" id="locationToSearch" />
			<form:errors path="locationToSearch" cssClass="help-block" />
		</div>

		<spring:bind path="homeSearch.roomCount">
			<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
		</spring:bind>
			    <appfuse:label key="homeSearch.roomCount" styleClass="control-label" />
			    <br />
				<form:select path="roomCount" id="locationToSearch">
					<!-- value="NONE" label="--- Select ---" />  --> 
					<form:options items="${roomCount}" />
				</form:select>
				<form:errors path="roomCount" cssClass="help-block" />
			</div>
			
		<spring:bind path="homeSearch.operationType">
			<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
		</spring:bind>
			    <appfuse:label key="homeSearch.operationType" styleClass="control-label" />
			    <br />
				<form:select path="operationType" id="operationType">
					<!-- value="NONE" label="--- Select ---" />  --> 
					<form:options items="${operationType}" />
				</form:select>
				<form:errors path="operationType" cssClass="help-block" />
			</div>
		
		<spring:bind path="homeSearch.propertyType">
			<div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
		</spring:bind>
			    <appfuse:label key="homeSearch.propertyType" styleClass="control-label" />
			    <br />
				<form:select path="propertyType" id="propertyType">
					<!-- value="NONE" label="--- Select ---" />  --> 
					<form:options items="${propertyType}" />
				</form:select>
				<form:errors path="propertyType" cssClass="help-block" />
			</div>
		

		<div class="form-group">
			<button type="submit" name="upload" class="btn btn-primary"
				onclick="bCancel=false">
				<i class="icon-upload icon-white"></i>
				<fmt:message key="button.upload" />
			</button>
		</div>
	</form:form>
</body>
