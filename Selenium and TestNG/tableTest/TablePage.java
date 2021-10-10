package p_05_10_2021_Zadatak1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Kreirati TablePage za potrebe ovog testa, koji pribavlja sve elemente sa stranice.
//Napisati test koji vrsi dodavanje redova u tabelu citaju iz Zaposleni sheeta xlsx fajla. (SKINITE FAJL KAO XLSX i 
//		ubacite u sklopu vaseg projekta)
//
//Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php

public class TablePage {

	private WebDriver driver;
	
	public TablePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getAddButton() {
		return driver.findElement(By.xpath("//*[@class='btn btn-info add-new']"));
		
	}
	public WebElement getInputName() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getDepartmantInput() {
		return driver.findElement(By.id("department"));
	}
	public WebElement getPhoneInput() {
		return driver.findElement(By.id("phone"));
	}
	public WebElement getAdd() {
		return driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a"));
	}
	public WebElement getLastName() {
		return driver.findElement(By.xpath("//tbody/tr[last()]/td"));
	}
	public void insertEmployee(String name, String departmant, String phone) {
		this.getAddButton().click();
		this.getInputName().sendKeys(name);
		this.getDepartmantInput().sendKeys(departmant);
		this.getPhoneInput().sendKeys(phone);
		this.getAdd().click();
	}
}
