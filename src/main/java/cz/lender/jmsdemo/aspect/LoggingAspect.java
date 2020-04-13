package cz.lender.jmsdemo.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public * cz.lender..*.*(..))")
    public void publicMethod() {
    }

    @Around("publicMethod()")
    public Object logBeanExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(
                joinPoint.getSignature().getDeclaringType());
        String method = String.format("%s.%s",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());
        if (logger.isDebugEnabled()) {
            logger.debug("{}({})", method, StringUtils.join(joinPoint.getArgs(), ", "));
        }
        Object result = joinPoint.proceed();
        if (logger.isDebugEnabled()) {
            logger.debug("{} returns {}", method, result);
        }
        return result;
    }

    @AfterThrowing(pointcut = "publicMethod()", throwing = "throwable")
    public void logBeanFailed(JoinPoint joinPoint, Throwable throwable) throws Throwable{
        Logger logger = LoggerFactory.getLogger(
                joinPoint.getSignature().getDeclaringType());
        String method = String.format("%s.%s",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName());
        logger.error(method + " failed: " + throwable.getMessage(), throwable);
    }

}
