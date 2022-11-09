package Create_Account;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search_TC71_Pagination_Next {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Next")).click();
	}

}
