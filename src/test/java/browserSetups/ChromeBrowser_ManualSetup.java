package browserSetups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser_ManualSetup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\2023\\Automation\\Softwares\\BrowserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

	}

}
