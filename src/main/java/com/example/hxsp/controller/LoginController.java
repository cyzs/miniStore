package com.example.hxsp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.hxsp.bean.AccessToken;
import com.example.hxsp.bean.UserInfo;
import com.example.hxsp.common.UserLoginToken;
import com.example.hxsp.service.TokenService;
import com.example.hxsp.service.UserInfoService;
import com.example.hxsp.utils.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Zoran
 * @CreateDate 2020年05月25日 15:59:11
 * @Version 1.0.0
 */

@Controller
@RequestMapping("/hxsp/api")
public class LoginController extends BaseController {

	@Autowired
	private UserInfoService userService;
	@Resource
	private TokenService tokenService;

	public static Map<String, Object> userInfoMap = new HashMap<>();

	/**
	 * 登录
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public JsonResult<String> login(HttpServletResponse response, String account, String pwd,
			HttpServletRequest request, HttpSession session) {
		UserInfo userInfo = new UserInfo();
		userInfo.setAccount(account);
		userInfo.setPwd(pwd);
		UserInfo u = userService.login(userInfo);
		String code = "code";
		String msg = "msg";
		String data = "data";
		String token = null;
		token = tokenService.getToken(u);
		AccessToken accessToken = new AccessToken();
		accessToken.setToken(token);
		// 将用户信息存入map
		Map<String, Object> userMap = userService.getUser(u);
		userInfoMap.put(token, userMap);

		Cookie cookie = new Cookie("token", accessToken.getToken());
		cookie.setPath("/");
		response.addCookie(cookie);
		return new JsonResult<String>(SUCCESS, token);

	}

	/**
	 * 根据token获取用户信息
	 *
	 * @return
	 */
	@UserLoginToken
//    @CrossOrigin
	@RequestMapping("getUserInfo")
	@ResponseBody
	public JsonResult<Map<String, Object>> getUserInfo(String token, HttpSession session) {
		Map<String, Object> m = (Map<String, Object>) userInfoMap.get(token);
		return new JsonResult<Map<String, Object>>(SUCCESS, m);
	}

	/**
	 * 退出登录
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("layout")
	@ResponseBody
	public JsonResult<Void> layout(String token, HttpSession session) {
		session.setAttribute(token, "");
		return new JsonResult<>(SUCCESS);
	}

}
