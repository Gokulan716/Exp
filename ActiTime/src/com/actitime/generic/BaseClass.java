package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.LoginPage;

public class BaseClass {
static {
   System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
}
public static WebDriver driver;
@BeforeClass
public void OpenBrowser() {
	Reporter.log("OpenBrowser",true);
	driver=new ChromeDriver();
}
@AfterClass
public void CloseBrowse() {
	Reporter.log("CloseBrowser",true);
	driver.close();
}
@BeforeMethod
public void Login() throws IOException {
	Reporter.log("Login",true);
	FileLib f=new FileLib();
	String url = f.getProperty("url");
	String usn = f.getProperty("username");
	String pwd = f.getProperty("password");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(url);
	LoginPage l=new LoginPage(driver);
	l.getLogin(usn, pwd);
}
@AfterMethod
public void Logout() {
     Reporter.log("Logout",true);
}
}
