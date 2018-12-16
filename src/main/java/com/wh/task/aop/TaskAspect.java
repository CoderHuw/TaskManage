package com.wh.task.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.wh.task.annotation.TaskManageAnno;

@Aspect
@Component
public class TaskAspect {
	
	@Autowired
	ApplicationContext context;
	
	@Pointcut("@annotation(com.wh.task.annotation.TaskManageAnno)")
	public void mark() {
	}
	
//	@After("mark()")
//	public void taskExcute() {
//		System.out.println("do mark method:" + Thread.currentThread().getName());
//	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@AfterReturning(pointcut="mark()",returning="returnVal")
	public void afterReturnDeal(JoinPoint joinPoint, Object returnVal) throws Exception {
		//切點所在類class名稱
		String targetClassName = joinPoint.getTarget().getClass().getName();
		//獲取切點所在方法名稱
		String methodName = joinPoint.getSignature().getName();
		//獲取切點防範參數列表
		Object[] argList = joinPoint.getArgs();
		//反射生成切點類
		Class<?> targetClass = Class.forName(targetClassName);
		//獲取切點類下所有方法
		Method[] methods = targetClass.getMethods();
		//遍歷獲取方法
		for (Method method : methods) {
			//判斷是否是切點方法
			if(method.getName().equals(methodName)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				if(parameterTypes.length == argList.length) {
					TaskManageAnno annotation = method.getAnnotation(TaskManageAnno.class);
					if(annotation != null) {
						//獲取執行任務類的Class對象
						Class excuteTaskServiceClass = annotation.excuteTaskServiceClass();
						Object excuteService = context.getBean(excuteTaskServiceClass);
						//獲取執行任務的方法
						String excuteTaskMethodName = annotation.excuteTaskMethodName();
						Class<?> taskService = Class.forName(excuteTaskServiceClass.getName());
						Method excuteTaskMethod = taskService.getMethod(excuteTaskMethodName, annotation.taskMethodArgClass());
						List returnValueList = (List) returnVal;
						for (Object obj : returnValueList) {
							String missionStr = JSON.toJSONString(obj);
							excuteTaskMethod.invoke(excuteService, missionStr);
						}
					}
					break;
				}
			}
		}
		System.err.println("yoyoyoyoyo~~~~~~~~~");
	}
	
}
