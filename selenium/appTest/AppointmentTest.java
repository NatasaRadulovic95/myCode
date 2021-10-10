package p_04_10_2021_tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Domaci_01_10_2021.FormPage;
import p_04_10_2021.AppointmentPage;
import p_04_10_2021.LoginPage;
import p_04_10_2021.SummaryPage;

public class AppointmentTest {

	private WebDriver driver;
	private LoginPage loginPage;
	private AppointmentPage appPage;
	private SummaryPage summaryPage;
	@BeforeMethod
	
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
		this.appPage = new AppointmentPage(driver);
		this.summaryPage = new SummaryPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testProvera() {
		String username = "John Doe";
		String password = "ThisIsNotAPassword";
		String facility = "Hongkong CURA Healthcare Center";
		String radioButton = "None";
		String date = "10/10/2022";
		String comment = "Komentar";
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		loginPage.makeAppClick();
		loginPage.getUsername().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getButton().click();
		Assert.assertTrue(appPage.isFormPresented(),"Korisnik nije ulogovan");
		appPage.selectfacility(facility);
		appPage.apply().click();
		appPage.radioButton(radioButton);
		appPage.setDateInput(date);
		
		appPage.setComment(comment);
		//Za proveru da li je korisnik ulogovan iskoristite metodu isFormPresented iz AppointmentPage klase.
		
		appPage.getBookAppButton().click();
		
		Assert.assertEquals(summaryPage.getFacility().getText(), "Hongkong CURA Healthcare Center");
		Assert.assertEquals(summaryPage.getHealthCare().getText(), "None");
		Assert.assertEquals(summaryPage.getVisitDate().getText(), date);
		Assert.assertEquals(summaryPage.getApply().getText(), "Yes");
		Assert.assertEquals(summaryPage.getComment().getText(), comment);
		
		
	}
}
