<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<c:if test="${!ajaxRequest}">
	<html>
<head>
<title>Registration</title>
<link type="text/css" rel="stylesheet"
	href="/chat/resources/css/form.css" />
<%-- 	<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet"  type="text/css" />		 --%>
<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
	
        <link rel="stylesheet" type="text/css" href="/chat/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/chat/resources/css/animate-custom.css" />
</head>
<body>
</c:if>


  <div id="wrapper">
<div id="registration" class="animate form">
	<form:form id="form" action="registrativfsgdfgdfsgsgsgon.htm" method="POST" modelAttribute="UserBean">
		
			
			<c:if test="${not empty message}">
				<div id="message" class="success">${message}</div>
			</c:if>
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="error">Form has errors</div>
				</c:if>
			</s:bind>
		  <h1>Registration</h1> 
                                <p> 
                                    <form:label for="username" path="userName" class="uname" data-icon="u"> Your email or username </form:label>
                                     
                                  <form:input path="userName" type="text" name="username" value="" required="required" placeholder="myusername or mymail@mail.com"/>
                                </p>
                                <p> 
                                   <form:label for="password" path="passWord" class="youpasswd" data-icon="p"> Your password </form:label>
                                    <form:input  path="passWord"  name="password" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                    
                                </p>
	
<p class="signin button"> 
									<input type="submit" value="Sign up"> 
									</p>
	</form:form>
	<script type="text/javascript">
		$(document).ready(
				function() {
					$("#form").submit(
							function() {
								$.post($(this).attr("action"), $(this)
										.serialize(), function(html) {
									$("#formsContent").replaceWith(html);
									$('html, body').animate({
										scrollTop : $("#message").offset().top
									}, 500);
								});
								return false;
							});
				});
	</script>
</div>
   </div>
<c:if test="${!ajaxRequest}">

	</body>
	</html>
</c:if>