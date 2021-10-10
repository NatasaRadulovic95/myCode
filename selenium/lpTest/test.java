package p_05_10_2021_Zadatak2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import p_05_10_2021_Zadatak1.TablePage;

public class test {

	private WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testing() throws IOException, InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get("http://hrm.pragmatictestlabs.com/symfony/web/index.php");
		File file = new File("data/noviPodaci.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetPrijavljivanje = wb.getSheet("Prijavljivanje");
		
		for (int i = 1; i <=3; i++) {
			String username = (sheetPrijavljivanje.getRow(i).getCell(0).getStringCellValue());
			String password = (sheetPrijavljivanje.getRow(i)).getCell(1).getStringCellValue();
			String error = (sheetPrijavljivanje.getRow(i)).getCell(2).getStringCellValue();
			
			loginPage.login(username, password);
			Thread.sleep(500);
			softAssert.assertEquals(loginPage.getErrorMessage().getText(), error);
			
		}
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void afterMethod() {
//		driver.quit();
	}
	
}
