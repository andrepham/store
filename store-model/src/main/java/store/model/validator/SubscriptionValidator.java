package store.model.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import store.model.dto.SubscriptionDTO;

public class SubscriptionValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return SubscriptionDTO.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName","First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email","Email is required.");
		SubscriptionDTO subscriptionDTO = (SubscriptionDTO)target;
		if(!isEmail(subscriptionDTO.getEmail())){
			errors.rejectValue("email", "format.email", "Not an email");
		}
	}
	
	private boolean isEmail(String string){
		Pattern p = Pattern.compile("^\\w+@\\w+\\.\\w+$");
		Matcher m = p.matcher(string);
		
		return m.find();
	}

}
