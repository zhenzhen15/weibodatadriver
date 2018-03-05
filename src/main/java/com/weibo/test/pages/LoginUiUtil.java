package com.weibo.test.pages;

/**
 * @description 登录页面元素定位声明
 * */
public class LoginUiUtil {
	/**用户名输入框*/
	public static final String LU_INPUT_LOGINNAME_ID = "loginname";
	
	/**密码输入框*/
	//public static final String LU_INPUT_PASSWORD_XPATH = "//input[@class ='W_input' and @name= 'password']";
	public static final String LU_INPUT_PASSWORD_XPATH=".//*[@id='pl_login_form']/div/div[3]/div[2]/div/input";
//	public static final String LU_INPUT_PASSWORD_NAME="password";
	/**登录按钮*/
	public static final String  LU_BUTTON_LOGIN_XPTAHT = ".//*[@id='pl_login_form']/div/div[3]/div[6]/a";
	
//	/**登录错误信息*/
//	public static final By LP_TEXT_ERROR= By.xpath("//*[@color='red']");
	
}
