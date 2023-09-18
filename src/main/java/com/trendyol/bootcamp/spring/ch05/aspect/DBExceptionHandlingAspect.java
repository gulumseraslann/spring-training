package com.trendyol.bootcamp.spring.ch05.aspect;

import com.trendyol.bootcamp.spring.ch05.exception.RewardDataAccessException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DBExceptionHandlingAspect {
	
	public static final String EMAIL_FAILURE_MSG = "Failed sending an email to Mister Smith : ";
	
	private Logger logger = LoggerFactory.getLogger(getClass());


	//	TODO-10 : Use AOP to log an exception.
	//
	//  - Configure this advice method to enable logging of
	//	  exceptions thrown by Repository class methods.
	//	- Select the advice type that seems most appropriate.
	@AfterThrowing(value = "execution(* *..*Repository.*(..))", throwing = "e")
	public void implExceptionHandling(RewardDataAccessException e) {
		// Log a failure warning
		logger.warn(EMAIL_FAILURE_MSG + e + "\n");
	}

	//	TODO-11 : Annotate this class as a Spring-managed bean.
	//	- Note that we enabled component scanning in an earlier step.

}
