package HandleCheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBox {
	public static void delay(int milliseconds) throws InterruptedException{
		Thread.sleep(milliseconds);
	}
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	
	//(1)select spesific check box
	//driver.findElement(By.xpath("//input[@id='sunday']")).click();
	
	//(2)select all checkbox
	List <WebElement> checkboxes =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//	for(int i=0;i<checkboxes.size();i++) {
//		checkboxes.get(i).click();
//	}
	
//	for(WebElement checkbox:checkboxes) {
//		checkbox.click();
//	}
	
	//(3)check last 3 checkbox
//	for(int i=4;i<checkboxes.size();i++) {
//		checkboxes.get(i).click();
//	}
	
	//(4)check first 2 checkbox
//	for(int i=0;i<2;i++) {
//		checkboxes.get(i).click();
//	}
	
	//(5)unselect checkboxes if they are selected
	for (int i=0;i<2;i++) {
		checkboxes.get(i).click();
	}
	try {
		delay(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i =0;i<checkboxes.size();i++) {
		if(checkboxes.get(i).isSelected()) {
			checkboxes.get(i).click();
		}
	}
	
	
}
}
