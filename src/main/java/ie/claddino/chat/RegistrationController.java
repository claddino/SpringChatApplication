package ie.claddino.chat;

import ie.claddino.chat.service.UserDatastoreService;
import ie.claddino.chat.user.UserBean;
import ie.claddino.chat.user.UserDAO;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *@author : Richard Downing
 * @version : 1.0 8-5-2014
 * @since : 1.0
 *
 */
@Controller
@RequestMapping("/regform")
@SessionAttributes("UserBean")
public class RegistrationController {
	   @Autowired
	    UserDatastoreService userDatastoreService ;
	 
	   
	    @Autowired private UserDAO userDAO;
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	// Invoked on every request
	@ModelAttribute("UserBean")
	public UserBean createUserBean() {
		return new UserBean();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void regform() {
		
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registrationSubmit(@Valid UserBean user, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		logger.info("Processing New User");
		if (result.hasErrors()) {
			return null;
		}
		userDAO.addUser(user);
		
	
		String message = "Form submitted successfully.  Bound " + user;
		// Success response handling
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", message);
			return null;
		} else {
			
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/login";			
		}
	}
	
	

	 
}
