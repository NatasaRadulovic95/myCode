package p_04_10_2021;
import org.openqa.selenium.By;
//ima gettere za sve elemenete sa summary stranice koji nose informacije appointment-a
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {

	private WebDriver driver;
	
	public SummaryPage(WebDriver driver) {
		this.driver = driver;
		
	}
	public WebElement getFacility() {
		return driver.findElement(By.id("facility"));
	}
	public WebElement getApply() {
		return driver.findElement(By.id("hospital_readmission"));
		
	}
	public WebElement getHealthCare() {
		return driver.findElement(By.id("program"));
	}
	public WebElement getVisitDate() {
		return driver.findElement(By.id("visit_date"));
	}
	public WebElement getComment() {
		return driver.findElement(By.id("comment"));
	}
}
