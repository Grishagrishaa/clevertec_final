package ru.clevertec.logging.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class CommonPointcuts {

    /*
            Check for controllers
    */
    @Pointcut("within(ru.clevertec.*.controller.*Controller) && " +
              "@annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public void isControllerMethod() {
    }

    /**
     * Pointcut that matches all repositories, services and Controllers.
     */
    @Pointcut("@within(org.springframework.stereotype.Repository)" +
            " || @within(org.springframework.stereotype.Service)" +
            " || @within(org.springframework.web.bind.annotation.RestController)")
    public void isApplicationLayerComponent() {
    }
}
