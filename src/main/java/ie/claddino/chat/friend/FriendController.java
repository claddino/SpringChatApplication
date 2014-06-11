package ie.claddino.chat.friend;

import ie.claddino.chat.service.UserDatastoreService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FriendController {

	
	@Autowired
	UserDatastoreService userDatastoreService;
	@RequestMapping("/addFriend")
	public void addContact(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		SecurityContext ctx = (SecurityContext) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");

		Authentication auth = ctx.getAuthentication();
		String loggedUserName = auth.getName();
		String friendname = request.getParameter("friendname");

		/*
		 * Gets the Friend id TODO Messy find a better way
		 */
		userDatastoreService.addFriend(friendname, loggedUserName);
		
	}
	
	@RequestMapping("/getFriendList")
	public void getFriendList(HttpServletRequest request,
			HttpServletResponse response) {

		SecurityContext ctx = (SecurityContext) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");

		Authentication auth = ctx.getAuthentication();

		// Gets the users name from the principal
		String loggedUserName = auth.getName();
		
		userDatastoreService.getFriendList(loggedUserName, response);
		

		
	}
}
