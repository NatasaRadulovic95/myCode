package p_04_10_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver ) {
		this.driver = driver;
		
	}
	public void makeAppClick() {
		driver.findElement(By.id("btn-make-appointment")).click();
	}
	public WebElement getUsername() {
		return driver.findElement(By.id("txt-username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.id("txt-password"));
	}
	
	public WebElement getButton() {
		return driver.findElement(By.id("btn-login"));
	}
}
