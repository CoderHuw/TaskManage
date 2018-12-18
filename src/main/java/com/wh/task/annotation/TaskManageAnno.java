package com.wh.task.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: TaskManage <br/>
 *
 * @author HUW
 * @since JDK 1.8
 * date: 2018年12月15日 下午3:12:47 <br/>
 */
@Documented //包含在doc中
@Inherited //注解可以被继承
@Retention(RetentionPolicy.RUNTIME) //注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target(ElementType.METHOD) //标注在方法上
@SuppressWarnings("rawtypes")
public @interface TaskManageAnno {
	
	//是否多线程执行
	public boolean isMultiThreadExecute() default false;
	
	//任務執行類
	public Class excuteTaskServiceClass() default Object.class;

	//任務執行方法
	public String excuteTaskMethodName() default "";

	//執行任務方法參數類型
	public Class taskMethodArgClass() default Object.class;
	
	
}
