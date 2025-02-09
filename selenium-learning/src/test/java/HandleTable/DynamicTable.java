package HandleTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTable {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demoadmin");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demopass");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	boolean isRedirected = false;
	try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("dashboard&user_token="));
		isRedirected = true;
	}catch(Exception e){
		isRedirected = false;
	}
	
	if(isRedirected) {
		System.out.println("Halaman sudah dialihkan");
	}else {
		System.out.println("Halaman Belum dialihkan");
	}
	driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
	driver.findElement(By.xpath("//ul[@id='collapse9']//a[contains(text(),'Customers')]")).click();
	
}
}
