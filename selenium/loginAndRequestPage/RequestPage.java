package p_01_10_2021_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestPage {

	private WebDriver driver;
	private WebDriverWait wdwait;

	public RequestPage(WebDriver driver, WebDriverWait wdwait) {
		this.driver = driver;
		this.wdwait = wdwait;
	}

	public WebElement getAddFriend() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Add friend')]"));
	}

	public WebElement getCancelRequest() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Cancel Request')]"));
	}

	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[@class='ossn-system-messages-inner']/div"));
	}

	public boolean isMessageExist() {
		try {
			getMessage();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// metodu koja vraca tekst poruke (tekst elementa koji prikazuje poruku)

	public String getMEssageText() {

		return this.getMessage().getText();
	}
	// metodu koja vraca da li dugme Add Friend je na stranici - koristeci logiku sa
	// listama
	// (hvatajte element kao listu ako je lista prazna
	// element ne postoji)

	public void waitToDisappear() {
		wdwait.until(
				ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@class='ossn-system-messages-inner']/div"), 0));

	}

	public boolean isAddFriendDisplayeed() {
		try {
			this.getAddFriend();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// metodu koja vraca da li je dugme Cancel Request na stranici - po istoj logici
	// kao i prethodna metoda

	public boolean isCancelRequest() {
		try {
			this.getCancelRequest();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
