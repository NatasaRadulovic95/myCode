package p_01_10_2021_pages;
//getere za korisničko ime i lozinku
//metodu login koja submituje formu sa prosledjenim korisničkim nalogom i lozinkom.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
	}
	
	public void login(String username, String password) {
		
		this.getUsername().clear();
		this.getUsername().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getLoginButton().click();
		
	}
}
