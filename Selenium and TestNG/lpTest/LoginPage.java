package p_05_10_2021_Zadatak2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(By.id("txtUsername"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.id("txtPassword"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.id("btnLogin"));
	}
	
	public WebElement getErrorMessage() {
		return driver.findElement(By.id("spanMessage"));
	}
	
	public void login(String username, String password) {
		this.getUsername().clear();
		this.getUsername().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getLoginButton().click();
	}
}
