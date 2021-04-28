package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplyCreditCardPage {

	private WebDriver driver;
	private By name = By.xpath("//input[@name=\"name\"]");
	private By email = By.xpath("//input[@name=\"email\"]");
	private By address = By.xpath("//input[@name=\"address\"]");
	private By submitLogin = By.xpath("//button[@type=\"submit\"]");
	

	public ApplyCreditCardPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterName(String name1) {
		driver.findElement(name).sendKeys(name1);
	}
	public void enterEmail(String mail) {
		driver.findElement(email).sendKeys(mail);
	}
	public void enterAddress(String add) {
		driver.findElement(address).sendKeys(add);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitLogin).click();
	}

	public String getCardType() {
		String result="";
		List<WebElement> list=driver.findElements(By.xpath("//div[@class=\"sc-fubCfw ibmTIR\"]"));
		if(list.isEmpty())
		{
			return "No card available";
		}
		for(WebElement e:list) {
			result +=e.getText();
		}
		
		
		return result;
	}


}
