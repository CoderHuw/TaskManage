package com.wh.task.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.wh.task.annotation.LogAnno;

@Aspect
@Component
public class LogAspect {
	
	@Autowired
	ApplicationContext context;
	
	@Pointcut("@annotation(com.wh.task.annotation.LogAnno)")
	public void logger() {
	}
	
	@Before("logger()")
	public void beforeMethodExcute(JoinPoint point) throws ClassNotFoundException {
		String className = point.getTarget().getClass().getName();
		Class<?> clazz = Class.forName(className);
		String methodName = point.getSignature().getName();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if(method.getName().equals(methodName)) {
				LogAnno annotation = method.getAnnotation(LogAnno.class);
				System.err.println(annotation.logMessage() + ":" + Thread.currentThread().getName());
				break;
			}
		}
	}
	
	
	@After("logger()")
	public void afterMethodExcute() {
		System.err.println("嘿嘿，你爺爺在此~~~~~~" + Thread.currentThread().getName());
	}
	
	
	
}
