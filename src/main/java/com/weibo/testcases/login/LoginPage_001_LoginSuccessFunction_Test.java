package com.weibo.testcases.login;
import java.util.Map;

import org.testng.annotations.Test;

import com.weibo.base.BaseParpare;
import com.weibo.test.task.LoginTask;

/**
 * @description 登录之后验证用户名是不是正确的
 * */

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare{
  @Test(dataProvider="testData")
  public void loginSuccessFunction(Map<String, String> data) throws InterruptedException {
	  
	  //等待登录页面加载
	  LoginTask.waitLoginPageLoad(seleniumUtil, timeOut);
//	  LoginTask.waitLoginPageLoad(seleniumUtil, timeOut);
	  // 输入登录信息
	  LoginTask.loginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
//	  LoginPageHelper.typeLoginInfo(seleniumUtil,"jojo", "bean");
//	  //等待首页元素显示出来
//	  HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
//	  //检查用户名是不是期望的"jojo"
//	  HomePageHelper.checkUserName(seleniumUtil, timeOut, "jojo");
  }
//  public static void main(String [] args) throws Exception{
//	  LoginPage_001_LoginSuccessFunction_Test  loginTest= new  LoginPage_001_LoginSuccessFunction_Test();
//	  loginTest.loginSuccessFunction();
//	  
//  }
}
