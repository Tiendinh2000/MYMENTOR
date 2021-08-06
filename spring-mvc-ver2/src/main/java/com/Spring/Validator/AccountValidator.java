package com.Spring.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.Spring.Service.Impl.UserAccountService;

@Component
public class AccountValidator implements ConstraintValidator {
 @Autowired
 UserAccountService UserAccountService;

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return false;
	}

	
//	public static final String[] CONSTRAINTS= {
//			"AccountName is already registed, please choose another AccountName",
//			"AccountName's length > 6"
//			
//	}
//	
//	private final int ACCOUNTNAME_DUPLICATED=0,
//	
//	private String validateName(String accountName) {
//		int nameLength= accountName.length();
//		
//	}
}
