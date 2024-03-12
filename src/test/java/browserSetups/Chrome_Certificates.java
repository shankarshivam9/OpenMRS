package browserSetups;


import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Chrome_Certificates {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\2023\\Automation\\Softwares\\BrowserDrivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=P","--ignore-certificate-errors", "--incognito");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Success Code : " + LocalDateTime.now());

	}

}
