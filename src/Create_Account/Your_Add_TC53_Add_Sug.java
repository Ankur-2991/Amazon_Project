package Create_Account;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Your_Add_TC53_Add_Sug {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://www.amazon.com/");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		List <WebElement> check=driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1"));
		if(check.size()!=0) {
			driver.findElement(By.id("ap_email")).sendKeys("bansalankur834@gmail.com");
			driver.findElement(By.id("continue")).click();
			List <WebElement> reCheck=driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/h1"));
			List <WebElement> reCheckTwo=driver.findElements(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/div/span"));
			if(reCheck.size()!=0 && reCheckTwo.size()!=0) {
				driver.findElement(By.id("ap_password")).sendKeys("B@nsalankur834");
				driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/div/form/div/div[2]/div/div/label/div/label/input")).click();
				driver.findElement(By.id("signInSubmit")).click();
				action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-al-your-account")));
				driver.findElement(By.linkText("Account")).click(); 
				List <WebElement> FinalCheck=driver.findElements(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[1]/h1"));
				if(FinalCheck.size()!=0) {
					driver.findElement(By.linkText("Your addresses")).click();
					driver.findElement(By.id("ya-myab-plus-address-icon")).click();
					String reFinalCheck = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/h2")).getText();
					String order="Add a new address";
					//System.out.println(reFinalCheck);
					//System.out.println("Level1");
					if(reFinalCheck.equals(order)) {
						//System.out.println("Level2");
						Select drop=new Select(driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
						drop.selectByValue("CA");    
						//System.out.println("Level3");
						driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).clear();
						driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Ankur Bansal");
						driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("4379867511");
						driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Swans Arce Trail");
						driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("26");
						driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Delhi");
						Select province=new Select(driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
						province.selectByValue("Ontario");
						driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L6R 0B3");
						driver.findElement(By.id("address-ui-widgets-use-as-my-default")).click();
						
						driver.findElement(By.id("address-ui-widgets-addr-details-gate-code")).sendKeys("call 4379867511");
						Select delivery=new Select(driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[9]/div[5]/span/select")));
						delivery.selectByValue("BOTH");
						driver.findElement(By.linkText("I can receive shipments any day of the week")).click();
						//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("dropdown1_1"))));
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-form-submit-button")));
						driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
						Boolean find=driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-suggested-address-block_id-outer\"]/label/span/div/span")).isDisplayed();
						if(find) {
							WebElement radioButton1= driver.findElement(By.id("address-ui-widgets-suggested-address-block_id-input"));
							WebElement radioButton2= driver.findElement(By.id("address-ui-widgets-original-address-block_id-input"));
							radioButton1.click();
							if(radioButton1.isSelected()||radioButton2.isSelected() ) {
								driver.findElement(By.id("a-autoid-2-announce")).click();
								driver.findElement(By.id("//*[@id=\"yaab-alert-box\"]/div/h4")).isDisplayed();
								driver.close();
							}
						}
					}
					}
				}
				
			}


	}

}
