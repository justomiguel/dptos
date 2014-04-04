<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
    <link href="<c:url value="/scripts/main.css" />" rel="stylesheet">
    <script src="/scripts/jquery.1.10.2.min.js" type="text/javascript"></script>
    <script src="/scripts/jquery.autocomplete.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        //javascript para el autocomplete de ciudades
        $(document).ready(function() {
            $('#locationToSearch').autocomplete(
            {
                serviceUrl: '/getTags',
                paramName: "tagName",
                delimiter: ",",
                transformResult: function(response) 
                {
                    return {suggestions: $.map
                        ($.parseJSON(response), function(item) 
                            { return { value: item.tagName, data: item.id };}
                            )   
                    };
                }   
            }
            );          
        });
        </script>
</head>
<body class="home">
    <h2><fmt:message key="home.heading"/></h2>
    <p><fmt:message key="home.message"/></p>

    <ul class="glassList">
        <li>
            <a href="<c:url value='/userform'/>"><fmt:message key="menu.user"/></a>
        </li>
        <li>
            <a href="<c:url value='/fileupload'/>"><fmt:message key="menu.selectFile"/></a>
        </li>
    </ul>
   <form:form commandName="homeSearch" method="post" action="home" enctype="multipart/form-data"
        id="mainSearchBox">
    <spring:bind path="homeSearch.locationToSearch">
        <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
            <appfuse:label key="homeSearch.locationToSearch" styleClass="control-label"/>
            <form:input cssClass="form-control" path="locationToSearch" placeholder="Ingrese la ciudad o Provincia, para comenzar" id="locationToSearch"/>
            <form:errors path="locationToSearch" cssClass="help-block"/>
        </div>
    <div class="form-group">
        <button type="submit" name="upload" class="btn btn-primary" onclick="bCancel=false">
            <i class="icon-upload icon-white"></i> <fmt:message key="button.upload"/>
        </button>
        <button type="submit" name="cancel" class="btn btn-default" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
    R    </button>
    </div>
    </form:form>
</body>
