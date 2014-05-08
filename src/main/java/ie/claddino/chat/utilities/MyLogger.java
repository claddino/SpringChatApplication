package ie.claddino.chat.utilities;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MyLogger {

    private Logger log = LoggerFactory.getLogger(getClass());

    @After("execution(* com.example.web.HomeController.*(..))")
    public void log(JoinPoint point) {
        log.info(point.getSignature().getName() + " called...");
    }

	
}