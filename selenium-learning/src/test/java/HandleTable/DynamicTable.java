package HandleTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTable {
public static void main(String[] args) throws InterruptedException {
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
	String text = driver.findElement(By.xpath("//div[contains(text(),('Pages'))]")).getText();
	System.out.println(text);
	int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
	
	for(int p=1;p<=3;p++) {
		if(p>1) {
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
			active_page.click();
			Thread.sleep(3000);
		}
	
	int noRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
	for(int r =1 ;r<=noRows;r++) {
		String username = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]//td[2]")).getText();
		String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]//td[3]")).getText();
		System.out.println(username+"\t"+email);
	}
}
}
}
