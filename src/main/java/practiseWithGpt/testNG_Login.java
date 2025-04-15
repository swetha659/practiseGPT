package practiseWithGpt;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNG_Login {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	@Test
	public void positiveLoginTest()
	{
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[@id='loop-container']/div/article/div[2]/p[1]/strong")
	        )).getText();
		System.out.println(text);
		String expectedTxt="Congratulations student. You successfully logged in!";
		assertEquals(text,expectedTxt,"User not logged in");
		
	}
	@Test
	public void negativeInvalidUser()
	{
		driver.findElement(By.id("username")).sendKeys("nostudent");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.id("error"))).getText();
		System.out.println(text);
		String expectedTxt="Your username is invalid!";
		assertEquals(text,expectedTxt,"valid user");
		
	}
	@Test
	public void negativeInvalidPwd()
	{
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password12345");
		driver.findElement(By.id("submit")).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.id("error"))).getText();
		System.out.println(text);
		String expectedTxt="Your password is invalid!";
		assertEquals(text,expectedTxt,"valid pwd");
		
	}
	@AfterMethod
    public void tearDown() {
        driver.quit();

}
}