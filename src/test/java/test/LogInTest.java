package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LogInPage;
import util.BrowserFactory;


public class LogInTest {

	WebDriver driver;
	
	String userName;
	String password;
	
	@Test
	@Parameters({"userName","password"})
	public void validUserShouldAbleToLogIn(String userName, String password) {
		
		driver = BrowserFactory.init();
		
		LogInPage loginpage = PageFactory.initElements(driver, LogInPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickOnSignInButton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validateDashboardPage();
		
		BrowserFactory.tearDown();
		
	}
	
}
