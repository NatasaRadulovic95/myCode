package p_04_10_2021;






import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment",
//(iskoriste logiku preko liste, ako je lista prazna element nije na stanici)
//Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu 
// "dd/mm/yyyy" => npr: "21/09/2020"

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {

	private WebDriver driver;
	
	public AppointmentPage(WebDriver driver) {
		this.driver = driver;
	}
	//getter za facility select
	public Select getDropSelect() {
		Select drpFacility = new Select(driver.findElement(By.name("facility")));
		return drpFacility;
		
	}
	public void selectfacility(String text) {
		this.getDropSelect().selectByVisibleText(text);
		
	}
	//getter za apply for hospital readmission
	public WebElement apply() {
		return driver.findElement(By.id("chk_hospotal_readmission"));
	}
	
	//getter za radio dugme (trazeno po value atributu)
	//xpath-u - kao parametar se prima value za trazeno radio dugme
	////*[@name='programs'][@value='"+ radioInputName +"']
	
	public void radioButton(String text) {
		WebElement medicare = driver.findElement(By.xpath("//*[@class='col-sm-4']/label"));
		WebElement medicaid = driver.findElement(By.xpath("//*[@class='col-sm-4']/label[2]"));
		WebElement none = driver.findElement(By.xpath("//*[@class='col-sm-4']/label[3]"));
		
		if(text.equals("medicare")) {
			medicare.click();
		}
		else if(text.equals("medicaid")) {
			medicaid.click();
		}
		else {
			none.click();
		}
		
	}
	//getter za visit date input
	
	public WebElement visitDateInput() {
		return driver.findElement(By.id("txt_visit_date"));
		
	}
	
	public void setDateInput(String date){
		
	
		visitDateInput().sendKeys(date);
		
	}
	
	//getter za comment input
	
	public WebElement getCommentInput() {
		return driver.findElement(By.id("txt_comment"));
	}
	
	public void setComment(String comment) {
		getCommentInput().sendKeys(comment);
	}
	//getter za book appointment button
	public WebElement getBookAppButton() {
		return driver.findElement(By.id("btn-book-appointment"));
	}
//	metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment", (iskoriste logiku
//			preko liste, ako je lista prazna element nije na stanici)
//			Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu 
//			 "dd/mm/yyyy" => npr: "21/09/2020"

	public boolean isFormPresented() {
		List<WebElement> lists = driver.findElements(By.xpath("//*[@id='appointment']"));
		
		if(lists.size()>0) {
			return true;
		}
		else {
			return false;
		}
	}
}
