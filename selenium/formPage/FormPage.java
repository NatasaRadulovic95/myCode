package Domaci_01_10_2021;
//FormPage koja ima:

//metodu koja vraca da li su podaci uspesno sacuvani, tako sto proverava da li
//element koji nosi poruku za atribut style ima vrednost "visibility: visible"

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

	private WebDriver driver;
	private WebDriverWait wdWait;
	
	public FormPage(WebDriver driver, WebDriverWait wdWait) {
		this.driver = driver;
		this.wdWait = wdWait;
	}
	
	public WebElement getFullName() {
		return driver.findElement(By.id("first-name"));}
	public WebElement getDateOfBirthday() {
		return driver.findElement(By.id("dob"));
	}
	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}
	public void getRole(String text) {
		
		Select drpCountry = new Select(driver.findElement(By.name("role")));
		drpCountry.selectByVisibleText(text);
		
	}
	public WebElement getGardner(String sex) {
	
		WebElement male = driver.findElement(By.xpath("//*[@class='radio-container col-sm-10']/div/label[1]"));
		WebElement female = driver.findElement(By.xpath("//*[@class='radio-container col-sm-10']/div/label[2]"));
		WebElement between = driver.findElement(By.xpath("//*[@class='radio-container col-sm-10']/div/label[3]"));
		
		if(sex.equals("male")) {
			return male;
		}
		else if(sex.equals("female")) {
			return female;
		}
		
		else {
			return between;
		}
		
	}
	
	public WebElement getWaysOfDevelopment(String value) {
		
		WebElement readBook = (driver.findElement(By.xpath("//*[@type='checkbox'][@value='read_books']")));
		WebElement takeCourses = (driver.findElement(By.xpath("//*[@type='checkbox'][@value='online_courses']")));
		WebElement projects = (driver.findElement(By.xpath("//*[@type='checkbox'][@value='opensource']")));
		WebElement techCons = (driver.findElement(By.xpath("//*[@type='checkbox'][@value='tech_cons']")));
		WebElement texhBlogs = (driver.findElement(By.xpath("//*[@type='checkbox'][@value='tech_blogs']")));
		WebElement viaDelivery = (driver.findElement(By.xpath("//*[@type='checkbox'][@value='via_delivery']")));
		if(value.equals("Read books")) {
			return readBook;
		}
		else if(value.equals("Take online courses")) {
			return takeCourses;
		}
		else if(value.equals("Contribute to opensource projects")) {
			return projects;
		}
		else if(value.equals("Join tech cons")) {
			return techCons;
		}
		else if(value.equals("Read tech blogs")) {
			return texhBlogs;
		}
		else  {
			return viaDelivery;
		}
		
		
		
		
	}
	
	public WebElement getbuttonSubmit() {
		wdWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("submit"))));
		return driver.findElement(By.id("submit"));
	}
	//metodu koja vraca da li su podaci uspesno sacuvani, tako sto proverava da li
	//element koji nosi poruku za atribut style ima vrednost "visibility: visible"
	
	public boolean succefulSaved() {
		if(driver.findElement(By.xpath("//*[@class='message-element poruka']")).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
