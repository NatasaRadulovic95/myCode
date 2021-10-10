package p_01_10_2021_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p_01_10_2021_pages.LoginPage;
import p_01_10_2021_pages.RequestPage;

public class RequestTest {

	private WebDriver driver;
	private LoginPage loginPage;
	private RequestPage requestPage;
	private WebDriverWait wdwait;
	
	@BeforeMethod
	public void beforMethod() {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
		this.requestPage = new RequestPage(driver, wdwait);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	







//	Proverava da li je prikazana poruka koja sadrzi tekst “Friend request deleted!”
//	I na kraju proverava da li na stranici je prikazano Add Friend dugme


	@Test
	public void proveraTest() throws InterruptedException {
		driver.get("https://demo.opensource-socialnetwork.org/login");
		Thread.sleep(1000);
		loginPage.login("administrator", "administrator");
		driver.get("https://demo.opensource-socialnetwork.org/u/wVandervort");
		
		Assert.assertTrue(requestPage.isAddFriendDisplayeed(),"Dugme nije prikazano na stranici");
		requestPage.getAddFriend().click();
		
		Assert.assertTrue(requestPage.getMEssageText().contains("Your friend request has been sent!"),"Poruka nije prikazana");
		//Proverava da li na stranici postoji dugme Cancel Request
		Assert.assertTrue(requestPage.isCancelRequest());
		
		Thread.sleep(500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		Assert.assertTrue(requestPage.isCancelRequest());
		//Ponistava zahtev za prijateljstvo
		requestPage.getCancelRequest().click();
		//Proverava da li je prikazana poruka koja sadrzi tekst “Friend request deleted!”
		
		Assert.assertEquals(requestPage.getMEssageText(), "×\r\n" + 
				"Friend request deleted!");
		//I na kraju proverava da li na stranici je prikazano Add Friend dugme
		Assert.assertTrue(requestPage.isAddFriendDisplayeed());
		
		

	}
	
	@AfterMethod
	public void afterMethod() {
		//U AfterClass metodi zatvara stranicu
		driver.quit();
	}
}
