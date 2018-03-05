package com.weibo.testcases.login;
import java.util.Map;

import org.testng.annotations.Test;

import com.demo.test.task.LoginTask;
import com.weibo.base.BaseParpare;

/**
 * @description 登录之后验证用户名是不是正确的
 * */

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare{
  @Test
  public void loginSuccessFunction() {
	  
	  //等待登录页面加载
	  LoginTask.waitLoginPageLoad(seleniumUtil, timeOut);
//	  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
	  // 输入登录信息
	  LoginTask.loginInfo(seleniumUtil, "janyzhen15@163.com", "Zong890105");
//	  LoginPageHelper.typeLoginInfo(seleniumUtil,"jojo", "bean");
//	  //等待首页元素显示出来
//	  HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
//	  //检查用户名是不是期望的"jojo"
//	  HomePageHelper.checkUserName(seleniumUtil, timeOut, "jojo");
  }
}
