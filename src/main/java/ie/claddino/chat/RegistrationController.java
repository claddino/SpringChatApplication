package ie.claddino.chat;

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
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	@Autowired private UserDAO userDAO;
	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	

	@ModelAttribute("UserBean")
	public UserBean createUserBean() {
		return new UserBean();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid UserBean user, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		logger.info("Processing New User");
		if (result.hasErrors()) {
			return null;
		}
		userDAO.addUser(user);
		
		System.out.println("Saving User object");
	
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
