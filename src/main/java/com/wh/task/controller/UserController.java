package com.wh.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wh.task.model.User;
import com.wh.task.service.impl.UserServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("list")
	@ResponseBody
	public List<User> getUserList(Integer limitNum){
		return userService.getUserList(limitNum);
	}
	
}
