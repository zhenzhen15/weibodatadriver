package com.weibo.base;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.weibo.utils.ExcelDataProvider;
import com.weibo.utils.LogConfiguration;
import com.weibo.utils.SeleniumUtil;
public class BaseParpare {
	//输出本页面日志 初始化
	static Logger logger = Logger.getLogger(BaseParpare.class.getName());
	protected SeleniumUtil seleniumUtil = null;
	// 添加成员变量来获取beforeClass传入的context参数
	protected ITestContext testContext = null;
	protected String webUrl="";
	protected int timeOut = 0;
	
	@BeforeClass
	/**启动浏览器并打开测试页面*/
	public void startTest(ITestContext context) {
		LogConfiguration.initLog(this.getClass().getSimpleName());
		seleniumUtil = new SeleniumUtil();
		// 这里得到了context值
		this.testContext = context;
		//从testng.xml文件中获取浏览器的属性值
		String browserName = context.getCurrentXmlTest().getParameter("browserName");
		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		webUrl = context.getCurrentXmlTest().getParameter("testurl");
		

		try {
			//启动浏览器launchBrowser方法可以自己看看，主要是打开浏览器，输入测试地址，并最大化窗口
			seleniumUtil.launchBrowser(browserName, context,webUrl,timeOut);
		} catch (Exception e) {
			logger.error("浏览器不能正常工作，请检查是不是被手动关闭或者其他原因",e);
		}
		//设置一个testng上下文属性，将driver存起来，之后可以使用context随时取到，主要是提供arrow 获取driver对象使用的，因为arrow截图方法需要一个driver对象
		testContext.setAttribute("SELENIUM_DRIVER", seleniumUtil.driver);
	}

	@AfterClass
	/**结束测试关闭浏览器*/
	public void endTest() {
		if (seleniumUtil.driver != null) {
			//退出浏览器
			seleniumUtil.quit();
		} else {
			logger.error("浏览器driver没有获得对象,退出操作失败");
			Assert.fail("浏览器driver没有获得对象,退出操作失败");
		}
	}
	/**
	 * 测试数据提供者 - 方法
	 * */
	@DataProvider(name = "testData")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; // 模块的名字
		String caseNum = null; // 用例编号
		String className = this.getClass().getName();
		//System.out.println(className);com.weibo.testcases.login.LoginPage_001_LoginSuccessFunction_Test
		int dotIndexNum = className.indexOf("."); // 取得第一个出现.的index(位置)
		//System.out.println(dotIndexNum);3
		int underlineIndexNum = className.indexOf("_"); // 取得第一个出现_的index(位置)
		//System.out.println(underlineIndexNum);35

		if (dotIndexNum > 0) {	
			moduleName = className.substring(20, className.lastIndexOf(".")); // 取到模块的名称,从第20个字符开始，到最后一个出现.结束。返回中间的字符串
			//System.out.println(moduleName);login
		}

		if (underlineIndexNum > 0) {
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
		//	System.out.println(caseNum);001
		}
		//将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}
}
