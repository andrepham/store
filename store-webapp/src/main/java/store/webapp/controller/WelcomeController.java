package store.webapp.controller;

import java.util.Calendar;


import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import store.model.dto.SubscribingUserDTO;
import store.model.validator.SubscriptionValidator;
import store.service.SubscriptionService;

@Controller
@RequestMapping("/welcome")
@SessionAttributes("subscribingUser")
public class WelcomeController {
	
	private SubscriptionService subscriptionService;
	private SubscriptionValidator subscriptionValidator;
	@RequestMapping(method=RequestMethod.GET)
	public String subscribe(Model model) {
		model.addAttribute("today", Calendar.getInstance());
		model.addAttribute("subscribingUser", new SubscribingUserDTO());
		
		return "subscribeForm";
	}
	
	@RequestMapping(value="/subscribeSuccess", method=RequestMethod.GET)
	public String redirectSubscribeSuccess() {
		return "subscribeSuccess";
	}
	
	@RequestMapping(value="/testInternalViewResolver", method=RequestMethod.GET)
	public String testInternalView() {
		return "testInternalView";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitForm(@ModelAttribute("subscribingUser") SubscribingUserDTO userSubscribeDTO, BindingResult result, SessionStatus status) {
		subscriptionValidator.validate(userSubscribeDTO, result);
		if(!result.hasErrors()){
			subscriptionService.storeUser(userSubscribeDTO);
			return "redirect:welcome/subscribeSuccess";
		}
		else{
			return "subscribeForm";
		}
	}

	@Required
	public void setSubscriptionService(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@Required
	public void setSubscriptionValidator(SubscriptionValidator subscriptionValidator) {
		this.subscriptionValidator = subscriptionValidator;
	}
	
	
}
