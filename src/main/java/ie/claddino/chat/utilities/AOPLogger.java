package ie.claddino.chat.utilities;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AOPLogger {

    private Logger log = LoggerFactory.getLogger(getClass());

    
   
    /**
     * @param point
     * Logs mappings
     */
    @After("execution(* ie.claddino.chat.LoginController.*(..))")
    public void log(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }
    
   
    /**
     * Logs mappings in Registration Controller
     * @param point
     */
    @After("execution(* ie.claddino.chat.RegistrationController.*(..))")
    public void logreg(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }
   

	
}