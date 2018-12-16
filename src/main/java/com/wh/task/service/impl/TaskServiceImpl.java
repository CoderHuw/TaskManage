package com.wh.task.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.wh.task.annotation.LogAnno;
import com.wh.task.model.User;
import com.wh.task.service.intf.ITaskService;

@Component
public class TaskServiceImpl implements ITaskService {

	@LogAnno(logMessage="叫你一聲，你敢答應麼~~~~~~")
	public void dealMission(String objStr) {
		System.out.println("任務執行參數：" + objStr);
		User user = JSON.parseObject(objStr, User.class);
		System.out.println(user);
	}
}
