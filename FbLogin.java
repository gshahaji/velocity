package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Configuration;

public class FbLogin {
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",Configuration.chromePath);
		WebDriver s1 = new ChromeDriver();
		
		s1.get("https://www.facebook.com/");
		
		s1.manage().window().maximize();
		
		s1.findElement(By.xpath("//input[@name='email']")).sendKeys("shahaji123");
		s1.findElement(By.xpath("//input[@type='password']")).sendKeys("123456789");
		
		
		
	}

}
