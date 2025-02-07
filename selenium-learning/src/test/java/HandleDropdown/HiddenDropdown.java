package HandleDropdown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {
	static WebDriver driver;
public static void main(String[] args) {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
	driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
	WebElement option = driver.findElement(By.xpath("//span[normalize-space(text())='Automaton Tester']"));
	option.click();
}

//public static void Login() {
//	driver.findElement(By.xpath("//input[name='username']")).sendKeys("Admin");
//	driver.findElement(By.xpath("input[name='password']")).sendKeys("admin123");
//	driver.findElement(By.xpath("//button[@type='submit']")).click();
//}
}

