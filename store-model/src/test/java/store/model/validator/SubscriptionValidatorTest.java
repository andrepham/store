package store.model.validator;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"/store-model-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionValidatorTest{

	
	@Resource(name="subscriptionValidator")
	private SubscriptionValidator subscriptionValidator;
	
	@Test
	public void test() {
		String email = "abcd5_e@provider.com";
		String notEmail = "abcd5_e";
		
		try {
			Method method = subscriptionValidator.getClass().getDeclaredMethod("isEmail", String.class);
			method.setAccessible(true);
			boolean isEmail =(Boolean)method.invoke(subscriptionValidator, email);
			Assert.assertTrue(isEmail);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
