package com.wh.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.wh.task.mapper.UserMapper;
import com.wh.task.model.User;
import com.wh.task.service.intf.ITaskService;

@Component
public class TaskServiceImpl implements ITaskService {
	
	@Autowired
	private UserMapper userMapper;
	

//	@LogAnno(logMessage="叫你一聲，你敢答應麼~~~~~~")
	@Transactional
	public void dealMission(String objStr) {
//		System.out.println("任務執行參數：" + objStr + ":" + Thread.currentThread().getName());
		User user = JSON.parseObject(objStr, User.class);
		user.setEmail("13916795947@163.com");
		userMapper.updateByPrimaryKey(user);		
		user.setPhoneNo("13916795"+user.getId());
		userMapper.updateByPrimaryKey(user);
		throw new RuntimeException("事务测试~~~~~~~~");
//		System.out.println(user + ":" + Thread.currentThread().getName());
	}
}
