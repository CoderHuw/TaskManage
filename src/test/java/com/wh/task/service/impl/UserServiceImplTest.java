package com.wh.task.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wh.task.TaskManageApplication;
import com.wh.task.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskManageApplication.class)
public class UserServiceImplTest {
	
	@Autowired
	private UserServiceImpl userService;

	@Test
	public void batchCreateUserTest() {
		userService.batchCreateUser();
	}
	
	@Test
	public void testDoMrakMethod() {
		userService.doMrakMethod();
	}
	
	@Test
	public void testGetUserList() {
		List<User> userList = userService.getUserList(500);
		System.err.println(userList);
	}

}
