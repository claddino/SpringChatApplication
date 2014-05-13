package ie.claddino.chat.message;

import ie.claddino.chat.service.MessageDatastoreService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class MessageController {
	
	  @Autowired
	    MessageDatastoreService messageDatastoreService ;
	 @RequestMapping("/sendMessage")
     public ModelAndView sendMessage(HttpServletRequest request, HttpServletResponse response) {
		  SecurityContext ctx= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
         
         Authentication auth=ctx.getAuthentication();
                    
                     String sender = auth.getName();
                     String receiver = request.getParameter("to");
                     String message = request.getParameter("message");
                    
                     messageDatastoreService.sendMessageToThisUser(receiver, message, sender);
                    
                     return new ModelAndView("userhome");
     }
    
     @RequestMapping("/getMyMessages")
     public void getMyMessages(HttpServletRequest request, HttpServletResponse response) {
                    
   	 
SecurityContext ctx= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                     
                     Authentication auth=ctx.getAuthentication();
                     
                     
                     //Gets the users name from the principal
                     String loggedUserName = auth.getName();
                     @SuppressWarnings("unchecked")
                     List<Object> messages = messageDatastoreService.getMyLatestMessages(loggedUserName);
                    
                     response.setContentType("json");
                     Gson gson = new GsonBuilder().create();
                     try {
                    	 response.getWriter().write(gson.toJsonTree(messages).getAsJsonArray().toString());
                     } catch (IOException e) {
                                     e.printStackTrace();
                     }
                     System.out.println(gson.toJsonTree(messages).getAsJsonArray());
     }
     
     @RequestMapping("/getPrev")
     public void getPrev(HttpServletRequest request, HttpServletResponse response){
                     String minVal = request.getParameter("minVal");
                    
SecurityContext ctx= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
                     
                     Authentication auth=ctx.getAuthentication();
                     
                     
                     //Gets the users name from the principal
                     String loggedUserName = auth.getName();
                     @SuppressWarnings("unchecked")
                     List<Object> messages = messageDatastoreService.getMyPrevMessages(loggedUserName, minVal);
                    
                     response.setContentType("json");
                     Gson gson = new GsonBuilder().create();
                     try {
                    	 response.getWriter().write(gson.toJsonTree(messages).getAsJsonArray().toString());
                     } catch (IOException e) {
                                     e.printStackTrace();
                     }
     }
    
}
