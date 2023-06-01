package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LogInPage;
import page.ProfilePage;
import util.BrowserFactory;

public class AddCustomerTest{
   
	WebDriver driver;
	
	
	
	
	String userName;
	String password ;
	String fullName;
	String company;
	String emailId ;
	String phone ;;
	String address ;
	String city ;
	String state;
	String postal_Code;
	String countryName;
	String currencyName;
	String groupName;
	
	@Test
	@Parameters({"userName","password","fullName","company","emailId","phone","address","city","state","postal_Code","countryName","currencyName","groupName"})
	public void userShouldBeAbleToAddCustomer(String userName, String password, String fullName, String company, String emailId, String phone, String address, String city, String state, String postal_Code, String countryName, String currencyName,String groupName) {
		
        driver = BrowserFactory.init();
		
		LogInPage loginpage = PageFactory.initElements(driver, LogInPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickOnSignInButton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validateDashboardPage();
		
		dashboardpage.clickCustomerMenu();
		dashboardpage.clickAddCustomerMenu();
		
		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.validateAddCustomerPageHeader();
		addcustomerpage.insertFullName(fullName);
		addcustomerpage.selectCompanyNameFromDropDownMenu(company);
		addcustomerpage.insertEmailId(emailId);
		addcustomerpage.insertPhoneNumber(phone);
		addcustomerpage.insertAddress(address);
		addcustomerpage.insertCityName(city);
		addcustomerpage.insertStateName(state);
		addcustomerpage.insertPostalCode(postal_Code);
		addcustomerpage.selectCountryNameFromDropDownMenu(countryName);
		addcustomerpage.selectTags();
		addcustomerpage.selectCurrencyTypeFromDropDownMenu(currencyName);
		addcustomerpage.selectGroupTypeFromDropDownMenu(groupName);
		addcustomerpage.clickSaveButton();
		
		ProfilePage profilepage = PageFactory.initElements(driver, ProfilePage.class);
		profilepage.validateProfilePage();
		
		dashboardpage.clickListCustomerMenu();

		ListCustomerPage listcustomerpage = PageFactory.initElements(driver, ListCustomerPage.class);
		listcustomerpage.validateListCustomerPageElementHeader();
		
		listcustomerpage.validateInsertedNameAndDelete();
		listcustomerpage.clickOkDeleteButton();
		
		BrowserFactory.tearDown();
	}
	
}
