package com.zhang.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.util.BaseController;

@RestController
@RequestMapping("/api/userController")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;

	/**
	 * 分页查询全部数据
	 * @return
	 */
	@RequestMapping("/getUserListPage")
	public IPage<User> getUserListPage(){
		IPage<User> page = new Page<User>();
		page.setCurrent(1);//当前页
		page.setSize(5);//每页条数
		page = userService.page(page);
		return page;
	}
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping("/getList")
	public List<User> getList(){
		List<User> userLists = userService.list();
		return userLists;
	}
	
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/getUserById")
	public User getUserById(String id) {
		User user = userService.getById(id);
		return user;
	}
	
	/**
	 * 根据指定字段查询信息集合
	 * @return
	 */
	@RequestMapping("/getListMap")
	public Collection<User> getListMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		//key是字段名，value是字段值
		map.put("username", "admin");
		Collection<User> userLists = userService.listByMap(map);
		return userLists;
	}
	
	/**
	 * 新增一条数据
	 */
	@RequestMapping("/saveInfo")
	public void saveInfo() {
		User user = new User();
		user.setId(getUUID());
		user.setUsername("小米");
		user.setPassword("123");
		userService.save(user);
	}
	
	/**
	 * 批量新增用户信息
	 */
	@RequestMapping("/saveInfoList")
	public void saveInfoList() {
		User xiaoming = new User();
		xiaoming.setId(getUUID());
		xiaoming.setUsername("小明");
		xiaoming.setPassword("1");
		User xiaohong = new User();
		xiaoming.setId(getUUID());
		xiaohong.setUsername("小红");
		xiaohong.setPassword("2");
		List<User> userList = new ArrayList<User>();
		userList.add(xiaoming);
		userList.add(xiaohong);
		userService.saveBatch(userList);
	}
	
	/**
	 * 更新信息
	 */
	@RequestMapping("/updateInfo")
	public void updateInfo() {
		User user = new User();
		user.setId("1");
		user.setPassword("sysadmin");
		userService.updateById(user);
	}
	
	/**
	 * 新增或者更新信息
	 */
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate() {
		//传入的实体类user中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
		User user = new User();
		user.setId("1");
		user.setPassword("1122");
		userService.saveOrUpdate(user);
	}
	
	/**
	 * 根据Id删除信息
	 * @param id
	 */
	@RequestMapping("/deleteInfo")
	public void deleteInfo(String id) {
		userService.removeById(id);
	}
	
	/**
	 * 根据id批量删除信息
	 */
	@RequestMapping("/deleteInfoList")
	public void deleteInfoList() {
		List<String> userLists = new ArrayList<String>();
		userLists.add("1");
		userService.removeByIds(userLists);
	}
	
	/**
	 * 根据指定字段删除信息
	 */
	@RequestMapping("/deleteInfoMap")
	public void deleteInfoMap() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", "admin");
		userService.removeByMap(map);
	}

}
