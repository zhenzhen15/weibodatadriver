package com.weibo.test.objects;

import org.openqa.selenium.By;

import com.weibo.test.pages.LoginUiUtil;

public class LoginObject {
	/* 获取用户名输入框元素信息
	 * */
	public static By getUserNameObject(){
		return By.id(LoginUiUtil.LU_INPUT_LOGINNAME_ID);
	}
	
	/*获取用户密码输入框元素信息
	 * */
	public static By getUserPasswordObject(){
		return By.xpath(LoginUiUtil.LU_INPUT_PASSWORD_XPATH);
	}
	/*获取登录按钮元素信息
	 * */
	public static By getButtonLoginObject(){
		return By.xpath(LoginUiUtil.LU_BUTTON_LOGIN_XPTAHT);
	}

}
