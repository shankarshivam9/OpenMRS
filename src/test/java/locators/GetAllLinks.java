package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(WebElement link:allLinks) {
			System.out.println(link.getText()+ "    -------     " + link.getAttribute("href"));
		}
	}

}
