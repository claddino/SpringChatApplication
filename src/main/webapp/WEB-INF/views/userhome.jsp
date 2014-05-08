<%@page import="ie.claddino.chat.user.UserBean"%> 
<%@page import="javax.swing.JOptionPane"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <title>User Home</title>
       
       <link rel="stylesheet" type="text/css" href="/chat/resources/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="/chat/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/chat/resources/css/animate-custom.css" />
     <script type="text/javascript"
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
       <script type="text/javascript">
              $(document).ready(function() {
                     getOnlineUsers();
                     getAllUsers();
                     getMyMessages();
                     setInterval(function(){getMyMessages()},30000);
                     setInterval(function(){getOnlineUsers()},30000);
              });
             
              function selectUser(string){
                     $("#users").val( string ).attr('selected',true);
              }
             
              function sendMessage(){
                     $.ajax({
                           type: "POST",
                          url: "sendMessage.htm",
                          data:"to="+$("#users option:selected").val()+"&message="+$("#message").val(),
                          success: function() {
                             $("#msgStatus").html("Message Sent Successfully to " + $("#users option:selected").val());
                          },
                          error: function(e){
                             alert("error"+e.toSource());
                             $("#msgStatus").html("Error : "+e);
                          }
                     });
              }
             
              function getOnlineUsers(){
                     $.ajax({
                           type: "POST",
                          url: "getOnlineUsers.htm",
                          dataType: "json",
                          success: function(result) {
                             for(var i=0; i<result.length; i++){
                                    var oo = "<a href=javascript:selectUser('"+result[i].userId+"')><font color='blue'>"+result[i].userId +"</font></a>";
                                    if(i==0){
                                            $("#onlineUsers").html(oo);    
                                    }else{
                                            $("#onlineUsers").append(", "+oo);    
                                    }
                             }
                          },
                          error: function(e){
                             alert("error"+e.toSource());
                          }
                     });
              }
              function getAllUsers(){
            	
                     $.ajax({
                           type: "POST",
                          url: "getAllUsers.htm",
                          dataType: "json",
                          success: function(result) {
                        	  console.log(result);
                             for(var i=0; i<result.length; i++){
                            	 
                                    var oo =  "<option name='"+result[i].userName+"'>"+
                                    result[i].userName + 
                                    "</option>";
                                                  if(i==0){
                                                         $("#users").html(oo);   
                                                  }else{
                                                         $("#users").append(oo); 
                                                  }
                             }
                          },
                          error: function(e){
                             alert("error"+e.toSource());
                          }
                     });
              }
             
              function getMyMessages(){
            	  
                     $.ajax({
                           type: "POST",
                          url: "getMyMessages.htm",
                          dataType: "json",
                          success: function(result) {
                        	  console.log("getMyMessages Jquery" + result);
                             for(var i=0; i<result.length; i++){
                            	 
                                    if(i  == 0){
                                           $("#maxVal").val(result[i].id);
                                    }else if(i == result.length-1){
                                           $("#minVal").val(result[i].id);
                                    }
                                    var time = "";
                                    time = result[i].time;
                                    var oo = "<tr bgcolor='gray' border='2' >"+
                                                              "<td>"+
                                                                            "<tr><td>"+result[i].message+"</td></tr>"+
                                                                            "<tr><td> by : "+result[i].senderName+" on "+ time/* .day+ "/"+time.getMonth+"/"+time.year+" - "+time.hour+
                                                                                            ":"+time.min+":"+time.sec */+"</td>"+
                                                                            "</tr>"+
                                                              "</td>"+
                                                  "</tr>"; 
                                     if(i==0){
                                            $("#inbox").html(oo);   
                                     }else{
                                            $("#inbox").append(oo); 
                                     }
                             }
                          },
                          error: function(e){
                             alert("error"+e.toSource());
                          }
                     });
              }
             
              function getMyPrevMessages(){
                     $.ajax({
                           type: "POST",
                          url: "getPrev.htm",
                          dataType: "json",
                          data:"minVal="+$("#minVal").val(),
                          success: function(result) {
                        	  
                                  console.log(result);
                              
                             for(var i=0; i<result.length; i++){
                                    if(i  == 0){
                                           $("#maxVal").val(result[i].id);
                                    }else if(i == result.length-1){
                                           $("#minVal").val(result[i].id);
                                    }
                                    var time = "";
                                    time = result[i].time;
                                    var oo = "<tr bgcolor='gray' border='2' >"+
                                                              "<td>"+
                                                              "<tr><td>"+result[i].message+"</td></tr>"+
                                                              "<tr><td> by : "+result[i].senderName+" on "+ time/* .day+ "/"+time.getMonth+"/"+time.year+" - "+time.hour+
                                                                              ":"+time.min+":"+time.sec */+"</td>"+
                                                              "</tr>"+
                                                                     "</td>"+
                                                  "</tr>";
                                     if(i==0){
                                            $("#inbox").html(oo);   
                                     }else{
                                            $("#inbox").append(oo); 
                                     }
                             }
                          },
                          error: function(e){
                             alert("error"+e.toSource());
                          }
                     });
              }
             
              function getMyNextMessages(){
                     $.ajax({
                           type: "POST",
                          url: "getMyMessages.htm",
                          dataType: "json",
                          data:"maxVal="+$("#maxVal").val(),
                          success: function(result) {
                             for(var i=0; i<result.length; i++){
                                    if(i  == 0){
                                           $("#maxVal").val(result[i].id);
                                    }else if(i == result.length-1){
                                           $("#minVal").val(result[i].id);
                                    }
                                    var time = "";
                                    time = result[i].time;
                                    var oo = "<tr bgcolor='gray' border='2' >"+
                                                              "<td>"+
                                                              "<tr><td>"+result[i].message+"</td></tr>"+
                                                              "<tr><td> by : "+result[i].senderName+" on "+ time/* .day+ "/"+time.getMonth+"/"+time.year+" - "+time.hour+
                                                                              ":"+time.min+":"+time.sec */+"</td>"+
                                                              "</tr>"+
                                                                     "</td>"+
                                                  "</tr>";
                                                  
                                     if(i==0){
                                            $("#inbox").html(oo);   
                                     }else{
                                            $("#inbox").append(oo); 
                                     }
                             }
                          },
                          error: function(e){
                             alert("error"+e.toSource());
                          }
                     });
                     
                     
              }
             
           
             
       </script>
</head>


<body>

<table width=100% >
  <tr>
    <td>&nbsp;</td>
    <td><div id="welcomeuser">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
		
			Welcome to Spring Chat ${pageContext.request.userPrincipal.name}  
		
	</c:if>
	
	</div></td>
    <td><div id="logoutlink">
    <input type="image" id="myimage" style="height:50px;width:50px;" src="${pageContext.servletContext.contextPath}/resources/images/logout.jpg"  onclick="javascript:formSubmit()" />
           
                          <c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</div></td>
  </tr>
  <tr>
    <td><div id ="userlist"   align="right" style="text-align: right; vertical-align: top;">
	
                                                       Select User :
                                             
                                                       <select id="users"  name="to"></select>
                                              
                                                       <a href="javascript:getAllUsers();"><font color="red">refresh Userlist</font>
                                                       
                                                       </a>
                                        
	</div> </td>
    <td><div id ="writemessage">
              <table border="2" align="center">
                            <tr bordercolor="blue">
                                         <td bgcolor="green"> Online Users </td>
                           </tr>
                           <tr bordercolor="blue">
                                  <td bgcolor="red">
                                         <div id="onlineUsers" >
                                         </div>
                                  </td> 
                           </tr>
                     </table>
                     
                           <form >
                                  <table align="center"  >
                                         <tr>
                                               
                                         <tr>
                                                <td>
                                                       <textarea name="message" id="message" COLS="50" ROWS="16"></textarea>
                                                </td>
                                                <td>
                                                       <div id="msgStatus"></div>
                                                </td>
                                         </tr>
                                         <tr>
                                                <td>
                                           <input type="button" value="Send Message"  onclick="javascript:sendMessage();" />
                                                 
                                                   
                                                       
                                                </td>
                                         </tr>
                                  </table>
                           </form>
                     
                    
	
	</div></td>
    <td><div id="yourinbox">
                    
                    
                    <div id ="yourinboxbuttons">
        <table width="100%" >
  <tr>
    <td>
                             <form action="getPrev.htm" >
                                  <table>
                                         <tr>
                                                <td>
                                                       <input type="hidden" id="minVal" name="minVal"/>
                                                </td>
                                                <td>
                                                       <input type="button" value="previous" onclick="getMyPrevMessages();"/>
                                                </td>
                                         </tr>
                                  </table>
                           </form></td>
    <td>Tour Inbox</td>
    <td>    <form action="getNext.htm"  >
                                  <table>
                                         <tr>
                                                <td>
                                                      <input type="hidden" id="maxVal" name="maxVal" />
                                                </td>
                                                <td>
                                                       <input type="button" value="next"  onclick="getMyNextMessages();"/>
                                                </td>
                                         </tr>
                                  </table>
                           </form></td>
  </tr>
</table>
                 
                       
                           </div>
                           <table id="inbox" border="2" height="800px" width="300px" bgcolor="white"  align="right" style="text-align: right; vertical-align: top;">
                                 
                           </table>
                           </div></td>
  </tr>
 
</table>

	
        
	
	
	<script>
		function formSubmit() {
		 	$.ajax({  
                type : 'POST',  
                url : "removeonlinestatus.htm",  
                success: function(result) {
                	document.getElementById("logoutForm").submit();
                }
                }
            ); 
			
		}
	</script>
 
	
                 
                     
                 
            
                     
                         
                 
                     
         
             
     

</body>

</html> 