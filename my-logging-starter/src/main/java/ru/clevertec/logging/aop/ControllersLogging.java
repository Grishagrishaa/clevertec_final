package ru.clevertec.logging.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Aspect for logging controller methods.
 */
@Slf4j
@Aspect
public class ControllersLogging {

    @Autowired
    private ObjectMapper mapper;

    /**
     * Logs the method parameters before the controller method is invoked.
     *
     * @param joinPoint join point for advice
     */
    @Before("ru.clevertec.logging.aop.CommonPointcuts.isControllerMethod()")
    public void logMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RequestMapping mapping = signature.getMethod().getAnnotation(RequestMapping.class);

        Map<String, Object> parameters = getParameters(joinPoint);

        try {
            log.info("Request:: path: {}, method: {}, arguments: {} ",
                    mapping.path(), mapping.method(), mapper.writeValueAsString(parameters));
        } catch (JsonProcessingException e) {
            log.error("Error while converting", e);
        }
    }

    /**
     * Logs the method response after the controller method has been invoked.
     *
     * @param joinPoint join point for advice
     * @param entity    response entity
     */
    @AfterReturning(pointcut = "ru.clevertec.logging.aop.CommonPointcuts.isControllerMethod()", returning = "entity")
    public void logMethodAfter(JoinPoint joinPoint, ResponseEntity<?> entity) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RequestMapping mapping = signature.getMethod().getAnnotation(RequestMapping.class);

        try {
            log.info("Response:: path: {}, method: {}, returning: {}",
                    mapping.path(), mapping.method(), mapper.writeValueAsString(entity));
        } catch (JsonProcessingException e) {
            log.error("Error while converting", e);
        }
    }

    /**
     * Retrieves the method parameters and their values.
     *
     * @param joinPoint join point for advice
     * @return a map of parameter names and values
     */
    private Map<String, Object> getParameters(JoinPoint joinPoint) {
        String[] parameterNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        Object[] args = joinPoint.getArgs();

        return IntStream.range(0, parameterNames.length)
                .boxed()
                .collect(Collectors.toMap(i -> parameterNames[i], i -> args[i]));
    }
}

