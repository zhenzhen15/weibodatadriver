package com.weibo.test.task;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.weibo.test.objects.LoginObject;
import com.weibo.test.pages.LoginUiUtil;
import com.weibo.utils.SeleniumUtil;

public class LoginTask {
	
	public static Logger logger = Logger.getLogger(LoginTask.class);
	
	/*1:等待登录页面元素加载
	 * *
	 */
	public static void waitLoginPageLoad(SeleniumUtil seleniumUtil, int timeOut){
		logger.info("开始检查登录页面元素");
		seleniumUtil.waitForElementToLoad(timeOut, LoginObject.getUserNameObject());
		seleniumUtil.waitForElementToLoad(timeOut, LoginObject.getUserPasswordObject());
		seleniumUtil.waitForElementToLoad(timeOut, LoginObject.getButtonLoginObject());
		logger.info("检查登录页面元素完毕");
	}
	/**
	 * @description 登录操作封装
	 * @param seleniumUtil
	 *            selenium api封装引用对象
	 * @param username
	 *            用户名值
	 * @param password
	 *            用户密码值
	 * @throws InterruptedException 
	 * */
	public static void loginInfo(SeleniumUtil seleniumUtil,String username,String password) throws InterruptedException{
		logger.info("开始输入登录信息");
		// 清空用户名输入框
		seleniumUtil.clear(LoginObject.getUserNameObject());
		// 输入用户名到用户名输入框
		seleniumUtil.type(LoginObject.getUserNameObject(), username);
		
		// 清空密码输入框
		seleniumUtil.clear(LoginObject.getUserPasswordObject());
		
		
		// 输入密码到密码输入框
		seleniumUtil.type(LoginObject.getUserPasswordObject(), password);
		
		logger.info("输入登录信息完毕");
		// 点击登录按钮
		 WebElement loginbutton= seleniumUtil.findElementBy(LoginObject.getButtonLoginObject());
		boolean aa =seleniumUtil.isEnabled(loginbutton);
		logger.info(aa);
		seleniumUtil.click(LoginObject.getButtonLoginObject());

	}
	

}
