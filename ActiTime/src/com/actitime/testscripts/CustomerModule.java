package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners()
public class CustomerModule extends BaseClass {
@Test
public void CreateCustomer() throws EncryptedDocumentException, IOException {
	Reporter.log("createcustomer",true);
	FileLib f=new FileLib();
	String custname = f.getExcelData("CreateCustomer", 1, 2);
	String custdes = f.getExcelData("CreateCustomer", 1, 3);
	HomePage hp=new HomePage(driver);
	hp.clickTaskTab();
	TaskListPage tp=new TaskListPage(driver);
	tp.getAddNewBtn().click();
	tp.getNewCustomerOption().click();
	tp.getCustNameTbx().sendKeys(custname);
	tp.getCustDescpTbx().sendKeys(custdes);
	tp.getSelectCustDD().click();
	tp.getOurCompanyOption().click();
	tp.getCreatCustBtn().click();
} 
}
