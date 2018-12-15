package com.wh.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wh.task.annotation.TaskManageAnno;
import com.wh.task.mapper.UserMapper;
import com.wh.task.model.User;
import com.wh.task.service.intf.IUserService;


/**
 * 
 * @Description: UserServiceImpl <br/>
 *
 * @author HUW
 * @since JDK 1.8
 * date: 2018年12月15日 下午3:38:49 <br/>
 */
@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 
	 * @Description:(批量新增用户信息). <br/>
	 *
	 * @author HUW
	 * @since JDK 1.8
	 */
	public void batchCreateUser() {
		for (int i = 0; i < 10000; i++) {
			User user = new User();
			user.setId(String.valueOf(i));
			user.setRealName("TaskManager" + i);
			userMapper.insert(user);
		}
	}
	
	/**
	 * 
	 * @Description:(測試AOP). <br/>
	 *
	 * @author HUW
	 * @since JDK 1.8
	 */
	@TaskManageAnno
	public void doMrakMethod() {
		Thread.currentThread().setName("嘿嘿嘿》》》》");
		System.out.println("lalalalala>>>>>>");
	}
	
}
