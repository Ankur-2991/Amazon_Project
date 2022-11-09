package Create_Account;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Search_TC67_Category_Keyword {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Select drop=new Select(driver.findElement(By.id("searchDropdownBox")));
		drop.selectByValue("search-alias=computers-intl-ship");
		driver.findElement(By.id("nav-search-submit-button")).click();
	}

}
