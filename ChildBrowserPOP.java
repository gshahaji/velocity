package popup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.Configuration;

public class ChildBrowserPOP {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",Configuration.chromePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		
		Set<String> window = driver.getWindowHandles();  //to identify total number of windows
		System.out.println(window.size());
		
		Iterator<String> itr = window.iterator();	
		
		while(itr.hasNext()) {                 //itr.hasNext() => true
			String mainWin = itr.next();  //id of main window
			String childWin = itr.next(); //id of child window
			
			System.out.println(mainWin);
			System.out.println(childWin);
			
			driver.switchTo().window(childWin); //switch control to child window
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.manage().window().minimize();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.close();
			
			
			driver.switchTo().window(mainWin); //switch control to main window
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.manage().window().minimize();
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.close();
			
		}
	}

}
