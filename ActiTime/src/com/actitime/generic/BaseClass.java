package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		Reporter.log("openBrowser",true);
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	}
	@AfterTest
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);	
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login",true);
		FileLib f=new FileLib();
		String url = f.getProperty("url");
		String un = f.getProperty("username");
		String pw = f.getProperty("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.getLogin(un, pw);
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("logout",true);
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
		h.setLogout();
	}
}
