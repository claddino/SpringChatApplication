package ie.claddino.chat.user;

import ie.claddino.chat.service.UserDatastoreService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Controller
public class UserController {
	 @Autowired
	    UserDatastoreService userDatastoreService ;
	
	 @RequestMapping("/getAllUsers")
     public void getAllUsers(HttpServletRequest request, HttpServletResponse response) {
                    
SecurityContext ctx= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                     
                     Authentication auth=ctx.getAuthentication();
                     
                     
                     //Gets the users name from the principal
                     String loggedUserName = auth.getName();
                    
                     List<Object> allUsers = userDatastoreService.getAllUsers(loggedUserName);
                    
                     response.setContentType("json");
                     
                     Gson gson = new GsonBuilder().create();
                     try {
                    	 response.getWriter().write(gson.toJsonTree(allUsers).getAsJsonArray().toString());
                                   
                     } catch (IOException e) {
                                     e.printStackTrace();
                     }
     }
     
  
     @RequestMapping("/getOnlineUsers")
     public void getOnlineUsers(HttpServletRequest request, HttpServletResponse response) {
                    
                  //   UserBean user = (UserBean) request.getSession().getAttribute("USER");
SecurityContext ctx= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                     
                     Authentication auth=ctx.getAuthentication();
                     
                     
                     //Gets the users name from the principal
                     String loggedUserName = auth.getName();
                    
                     List<Object> onlineUsers = userDatastoreService.getOnlineUsers(loggedUserName);
                    
                     response.setContentType("json");
                     Gson gson = new GsonBuilder().create();
                     try {
                    	 response.getWriter().write(gson.toJsonTree(onlineUsers).getAsJsonArray().toString());
                     } catch (IOException e) {
                                     e.printStackTrace();
                     }
     }
}
