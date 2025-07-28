package com.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ReusableMethods.Baseclass;
import com.naukriInterfaceElement.LoginPageElements;
import com.utility.FileReaderManager;

public class LoginPageModel extends Baseclass implements LoginPageElements {
	
	@FindBy(id = Homeloginbtn_id)
	private WebElement homelogin;
	
	@FindBy(xpath = username_xpath)
	private WebElement userName;
	
	@FindBy(xpath = password_xpath)
	private WebElement password;
	
	@FindBy(xpath = loginButton_xpath)
	private WebElement login;
	
	public LoginPageModel() {
		
		PageFactory.initElements(driver, this);
	}
	FileReaderManager reader = new FileReaderManager();
	
public void getLoginPage()  {
	
	elementclick(homelogin);
	waitUntilVisible(userName, 5);
	inputPassing(userName , reader.getDataProperty("loginusername"));
	inputPassing(password , reader.getDataProperty("loginpassword"));
	elementclick(login);
}
}
