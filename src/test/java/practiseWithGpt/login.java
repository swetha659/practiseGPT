package practiseWithGpt;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[@id='loop-container']/div/article/div[2]/p[1]/strong")
	        )).getText();
		System.out.println(text);
		String expectedTxt="Congratulations student. You successfully logged in!";
		assertEquals(text,expectedTxt,"User not logged in");
		driver.quit();
	}

}
