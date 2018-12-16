package com.wh.task.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.wh.task.annotation.TaskManageAnno;
import com.wh.task.model.User;

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
					if(annotation != null && !annotation.returnValueClass().equals("")) {
//						String returnValueClassName = annotation.returnValueClass();
//						Type[] genericInterfaces = Class.forName(returnValueClassName).getGenericInterfaces();
//						int dotIndex = StringUtils.lastIndexOf(".", returnValueClassName);
//						String returnClass = StringUtils.substring(returnValueClassName, dotIndex);
//						Type type = genericInterfaces[0];
//						ArrayList arrayList = (ArrayList) returnVal;
						//TODO
					}
					break;
				}
			}
		}
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) returnVal;
		System.err.println("yoyoyoyoyo~~~~~~~~~");
		System.err.println(JSON.toJSONString(users));
	}
	
}
