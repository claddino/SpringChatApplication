<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login to Spring Chat</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="/chat/resources/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="/chat/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/chat/resources/css/animate-custom.css" />
    </head>
    <body>
    <body onload='document.f.j_username.focus();'>

	
        
                <div class="clr"></div>
            <!--/ Codrops top bar -->
            
                  <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                
				
					
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form name="f" action="<c:url value='j_spring_security_check' />" method="POST">
                                <h1>Log in</h1> 
                                <c:if test="${not empty error}">
		<div class="errorblock" id="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
                                <p> 
                                    <label for="username" class="uname" data-icon="u"> Your email or username </label>
                                    <input type="text" value="Rich "name="username" value="" required="required" placeholder="myusername or mymail@mail.com">
                                  
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <input type="password" value="rich" name="password" required="required" type="password" placeholder="eg. X8df!90EO">
                                    
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping"> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
                                    <input name="submit" type="submit" value="log in">
								</p>
                                <p class="change_link">
									Create an Account?
									<a href="<c:url value="/regform" />" class="to_register">Register</a>
								</p>
                            </form>
                        </div>

                        </div>
                  
            
        
    </body>
</html>
<!-- <!DOCTYPE html>
[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]
[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]
[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]
[if (gte IE 9)|!(IE)]><! <html lang="en"> <![endif] -->
<%-- <head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link type="text/css" rel="stylesheet" href="/chat/resources/css/loginstyle.css" />
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

<body onload='document.f.j_username.focus();'>
	<h3>Login</h3>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
<div class="container">
	<section id="content">
		<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
			<h1>Login Form</h1>
			<div>
				<input type='text' name='username' value=''>
			</div>
			<div>
				<input type='password' name='password' />
			</div>
			<div>
				<input name="submit" type="submit"
					value="submit" />
				<a href="#">Lost your password?</a>
				<a href="<c:url value="/regform" />" title="reg">Register</a>
			</div>
		</form>form
		<div class="button">
			<a href="#">Download source file</a>
		</div>button
	</section>content
</div>container
</body>
</html>

 --%>