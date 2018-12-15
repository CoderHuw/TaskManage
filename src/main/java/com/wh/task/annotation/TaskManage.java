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
public @interface TaskManage {

}
