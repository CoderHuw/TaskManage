package com.wh.task.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wh.task.TaskManageApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskManageApplication.class)
public class TaskServiceImplTest {

	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@Test
	public void testDealMission() {
		for (int i = 0; i < 100; i++) {
			taskServiceImpl.dealMission("南无阿弥陀佛" + i);		
		}
	}

}
