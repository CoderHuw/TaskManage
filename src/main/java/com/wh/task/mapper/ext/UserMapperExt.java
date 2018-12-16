package com.wh.task.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wh.task.model.User;

public interface UserMapperExt {

	/**
	 * 
	 * @Description:(查詢指定條數對相集合). <br/>
	 *
	 * @author HUW
	 * @param limitNum
	 * @return
	 * @since JDK 1.8
	 */
	List<User> queryListByLimit(@Param("limitNum") int limitNum);

}
