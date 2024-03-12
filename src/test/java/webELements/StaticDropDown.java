package webELements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		WebDriver driver  = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		System.out.println("StaticDropdown" + staticDropdown);
		System.out.println("StaticDropdown" + staticDropdown.getText());
		
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByValue("INR");
		dropDown.selectByIndex(3);
	//	dropDown.deselectAll();
		System.out.println(dropDown.getFirstSelectedOption()); 
		
	}

}
