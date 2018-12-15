package com.wh.task.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaskAspect {
	
	@Pointcut("@annotation(com.wh.task.annotation.TaskManageAnno)")
	public void mark() {
	}

	
	@After("mark()")
	public void taskExcute() {
		System.out.println("do mark method:" + Thread.currentThread().getName());
	}
	
}
