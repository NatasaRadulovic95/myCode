package Domaci_01_10_2021;
//FormTest
//Ucitava stranicu
//Popunite formu proizvoljnim podacima
//Submitujte formu 
//Proverite da li su podaci uspesno sacuvani. (imate metodu iz page-a koja vam vraca da li je uspesno sacuvano, iskorisite je)
//U AfterClass metodi zatvaramo stranicu

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p_01_10_2021_pages.LoginPage;
import p_01_10_2021_pages.RequestPage;

public class FormTest {

	private WebDriver driver;
	private WebDriverWait wdWait;
	private FormPage formPage;
	
	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.wdWait = new WebDriverWait(driver, 10);
		this.formPage = new FormPage(driver, wdWait);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testCheck() {
		driver.get("file:///C:/Users/Info/Downloads/form%20(1).html");
		formPage.getFullName().sendKeys("Natasa Radulovic");
		formPage.getGardner("female").click();
		formPage.getDateOfBirthday().sendKeys("16.12");
		formPage.getEmail().sendKeys("alkdjasd@ldf.sdf");
		formPage.getRole("QA");
		formPage.getWaysOfDevelopment("Read books").click();
		formPage.getWaysOfDevelopment("Read tech blogs").click();
		formPage.getbuttonSubmit().click();
		Assert.assertTrue(formPage.succefulSaved());
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}
}
