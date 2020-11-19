package com.wyu.issue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyu.issue.pojo.Params;
import com.wyu.issue.pojo.User;
import com.wyu.issue.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 获取用户名与密码，用户登录
	 * 
	 * @param parsms
	 * @return 登录成功页面
	 */

	@RequestMapping("/login")
	public User userLogin(@RequestBody Params parsms) {
		User user = parsms.getParams();
		if (user.getLoginId() != null && user.getUserPassword() != null) {
			// 超级用户登录
			if (user.getLoginId().equals("Admin") && user.getUserPassword().equals("Admin123")) {
				user.setLoginId("Admin");
				user.setUserName("Admin");
				user.setUserPassword(null);
				return user;
			}

			// 普通用户登录
			String md5Password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());// 对密码进行 md5 加密
			user.setUserPassword(md5Password);
			user = userService.userLogin(parsms.getParams());
			if (user == null) {
				System.out.println("输入信息有误！请重新输入!");
				return null;
			}
			if (user.getIscancel() == 1) {
				System.out.println("用户已注销！请联系管理员!");
				return null;
			}

			else if (user != null && user.getIscancel() == 0) { // 登录成功
				return user;
			}
		}
		return null;
	}

	/**
	 * 修改个人信息
	 * 
	 * @param user
	 */
	@RequestMapping("/update")
	public void modifyUser(@RequestBody Params parsms) {

		// 对密码进行 md5 加密
		User user = parsms.getParams();
		String md5Password = DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes());
		user.setUserPassword(md5Password);
		userService.modifyUser(user);

	}

}
