package GID.AID;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class DataDrivenTesting {
  @Test(dataProvider = "inputdata") //method name
  public void testcase1(String username, String password) {
	  
	  
	    System.setProperty("webdriver.chrome.driver", "C:\\Selenium Downloads\\Browser Drivers\\chromedriver_win32 (3)\\chromedriver.exe");//click the browser
		WebDriver br = new ChromeDriver(); 
		br.get("http://apps.qaplanet.in/hrm/login.php");
	     br.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(username);
		br.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).sendKeys(password);
		br.findElement(By.xpath("//tbody/tr[4]/td[1]/input[1]")).click();
		String m=br.findElement(By.xpath("//li[contains(text(),'Welcome qaplanet1')]")).getText();
		System.out.println(m);
				
				
		Assert.assertEquals(m, "Welcome qaplanet1");
		
		System.out.println("test case pass yeh!!!!");
		
					
	     br.close();
  }

  @DataProvider
  public Object[][] inputdata() {
	  Object[][] Cred = new Object[4][2];                  
	  Cred[0][0] = "qaplanet1";
	  Cred[0][1] = "lab1";

	  Cred[1][0] = "qaplanet1";
	  Cred[1][1] = "lab1";

	  Cred[2][0] = "qaplanet1";
	  Cred[2][1] = "lab";

	  Cred[3][0] = "qaplanet1";
	  Cred[3][1] = "lab1";
	  return Cred;
}
}
