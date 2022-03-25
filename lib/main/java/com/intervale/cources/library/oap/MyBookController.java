package com.intervale.cources.library.oap;

import com.sun.xml.bind.v2.TODO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Аспектно-ориентированное программирование, Spring AOP
 * Aspect — модуль в котором собраны описания Pointcut и Advice.
 */
@Aspect
@Component
public class MyBookController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Pointcut — это срез, запрос точек присоединения, — это может быть одна и более точек
     */
    @Pointcut("execution(public * com.intervale.cources.library.api.BookController.getAllBooks())")
    public void callAtBookController(){}

    @Pointcut("execution(public * com.intervale.cources.library.api.BookController.getBooksByAuthor(..))")
    public void callAtBookControllers(){}


    /**
     * Before — перед вызовом метода
     * @param jp
     */
    @Before("callAtBookControllers()")
    public void callAtBookControllers(JoinPoint jp){
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + " args=[" + args + "]");
    }



    /**
     * Before — перед вызовом метода
     * @param jp
     */
    @Before("callAtBookController()")
    public void beforeCallAtGetAllBooks(JoinPoint jp){
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        log.info("before " + jp.toString() + " args=[" + args + "]");
    }

}
