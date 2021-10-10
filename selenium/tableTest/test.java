package p_05_10_2021_Zadatak1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import p_01_10_2021_pages.LoginPage;
import p_01_10_2021_pages.RequestPage;

public class test {

	private WebDriver driver;
	private TablePage tablePage;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.tablePage = new TablePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@Test
	public void testing() throws IOException, InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		File file = new File("data/podaci.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetKorisnici = wb.getSheet("Korisnici");
		tablePage.getAddButton().click();

		for (int i = 1; i <= 3; i++) {

			String name = (sheetKorisnici.getRow(i).getCell(0).getStringCellValue());
			String departmant = (sheetKorisnici.getRow(i).getCell(1).getStringCellValue());
			String phone = (sheetKorisnici.getRow(i).getCell(2).getStringCellValue());
			tablePage.insertEmployee(name, departmant, phone);
			Thread.sleep(500);
			softAssert.assertTrue(tablePage.getLastName().getText().contains(name));

		}
		softAssert.assertAll();

	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}
}
