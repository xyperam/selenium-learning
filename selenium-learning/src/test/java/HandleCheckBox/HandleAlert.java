package HandleCheckBox;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HandleAlert {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//(1) Normal alert with OK button
//	driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
//	Thread.sleep(5000);
//	driver.switchTo().alert().accept();
//	Alert myalert = driver.switchTo().alert();
//	System.out.println(myalert.getText());
//	myalert.accept();
	
	//(2) Confirmation alert with OK & Cancel
//	driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
//	Thread.sleep(5000);
//	driver.switchTo().alert().dismiss();
	//(3) prompt alert
//	driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
//	Thread.sleep(5000);
//	Alert myalert= driver.switchTo().alert();
//	myalert.sendKeys("HAHA");
//	myalert.accept();
	
	//(4) Handle alert with explicit wait
	driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
	Alert myalert= mywait.until(ExpectedConditions.alertIsPresent());
	System.out.println(myalert.getText());
	myalert.accept();
}
}
