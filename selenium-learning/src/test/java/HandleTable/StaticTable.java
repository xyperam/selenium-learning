package HandleTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	List<WebElement> row = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
	System.out.println(row.size());
	for(WebElement rows:row) {
		System.out.println(rows.getText());
	}
	List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
	System.out.println(columns.size());
	for(WebElement col:columns) {
		System.out.println(col.getText());
	}
	//how to read data spesific row and column?
	String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[2]")).getText();
	System.out.println(author);
	
	//how to read all data 

	for(int r = 2;r<=row.size();r++) {
		for (int c = 1;c<=columns.size();c++) {
			String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
			System.out.print(value + "\t");
		}
		System.out.println();
	}
	//total price
	int total = 0;
	for (int r=2;r<=row.size();r++) {
		String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
		total = total + Integer.parseInt(price);
	}
	System.out.println("total price = " + total);
}
}
