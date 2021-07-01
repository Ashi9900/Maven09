package GID.AID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	
	WebDriver br;
  @Test
  public void f() {
	  
	  br.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("qaplanet1");
		br.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys("lab1");
		br.findElement(By.xpath("//tbody/tr[4]/td[1]/input[1]")).click();
		String m=br.findElement(By.xpath("//li[contains(text(),'Welcome qaplanet1')]")).getText();
		System.out.println(m);
				
				
		Assert.assertEquals(m, "Welcome qaplanet1");
		
		System.out.println("test case pass yeh!!!!");
					
		
		
		
  }
  
  @BeforeMethod
  @Parameters("browser")
  void buildExe(String ibr){
	  if (ibr.equalsIgnoreCase("FF")){
		  System.setProperty("webdriver.gecko.driver", "C:\\Selenium Downloads\\Browser Drivers\\geckodriver-v0.29.1-win64 (2)\\geckodriver.exe");
	         br=new FirefoxDriver();
	        System.out.println("running with FF");
		}
		else if(ibr.equalsIgnoreCase("gg"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Selenium Downloads\\Browser Drivers\\chromedriver_win32 (3)\\chromedriver.exe");
			 br=new ChromeDriver();
			System.out.println("running with chrome");
		}
  }
	  
	  
	  @AfterMethod
	  void buildclose(){
	 	  
	   }
	   
}
