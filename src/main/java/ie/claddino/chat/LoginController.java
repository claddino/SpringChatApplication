package ie.claddino.chat;


import ie.claddino.chat.service.UserDatastoreService;
import ie.claddino.chat.user.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */


@Controller
public class LoginController {
    @Autowired
    UserDatastoreService userDatastoreService ;
 
   
    @Autowired private UserDAO userDAO;
    
    
    
  //after login button press
    @RequestMapping(value="/",method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
    	changeOnlineStatus(request);
        	
    		return "userhome";
		} 
        
	

	
 
	@RequestMapping(value="/userhome", method = RequestMethod.GET)
	public ModelAndView  showuserhome (Model model, HttpServletRequest request, HttpServletResponse response) {
 
changeOnlineStatus(request);
		  ModelAndView modeluserhome = new ModelAndView();
		  modeluserhome.addObject("title", "Spring Security Login Form - Database Authentication");
		  modeluserhome.addObject("message", "This page is for ROLE_ADMIN only!");
		  modeluserhome.setViewName("userhome");
		  return modeluserhome;
		
        }




	/**
	 * Called when user is logging in or logging out.
	 * if user logs in online status will be changed to 1 and to 0 when user is logging out
	 */
	private void changeOnlineStatus(HttpServletRequest request) {
		SecurityContext ctx= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		        
		        Authentication auth=ctx.getAuthentication();
		        
		        
		        //Gets the users name from the principal
		        String loggedUserName = auth.getName();
		        System.out.println(loggedUserName +  "authgetname login");
		        
		        if (loggedUserName != null) {
		        	userDatastoreService.changeMyOnlineStatus(loggedUserName,1);
		        }
		        else{
		        	userDatastoreService.changeMyOnlineStatus(loggedUserName,0);
		        }
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }
 
	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  
	  model.setViewName("login");
 
	  return model;
	}
	
	 @RequestMapping("/removeonlinestatus")
    public void getAllUsers(HttpServletRequest request, HttpServletResponse response) {
                   
                 //   UserBean user = (UserBean) request.getSession().getAttribute("USER");
		 SecurityContext ctx= (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
	        
	        Authentication auth=ctx.getAuthentication();
	        
	        
	        //Gets the users name from the principal
	        String loggedUserName = auth.getName();
       userDatastoreService.changeMyOnlineStatus(loggedUserName,0);
    }
    
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model,HttpServletRequest request, HttpServletResponse response, HttpSession HSession) {
		  try {
			 
} catch (Exception e) {
              e.printStackTrace();
}
request.getSession(true).invalidate();



		return "login";
 
	}
	
                  
     
     

	}

