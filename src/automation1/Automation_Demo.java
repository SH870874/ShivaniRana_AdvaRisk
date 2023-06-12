package automation1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Automation_Demo {

	
	public static void Login()throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SIDHARTH\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		
		//----------------------------- LOGIN ------------------------------
		
		//Successful login with correct creds
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		driver.findElement(By.id("login-button")).click();
	    //System.out.println("Login successful!");
		Thread.sleep(3000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Login successful!");
	    
		Thread.sleep(3000);
	    
		//Unsuccessful login with invalid creds
	    driver.findElement(By.id("user-name")).sendKeys("standard_use");
		driver.findElement(By.id("password")).sendKeys("secret_sauc");	
		driver.findElement(By.id("login-button")).click();
		String actual = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
		System.out.println(actual);
		String expected = "Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(actual,expected);
	    
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("password")).clear();
		driver.get("https://www.saucedemo.com/");
		driver.navigate().refresh();
		
		//Unsuccessful login without password
		driver.findElement(By.id("user-name")).sendKeys("standard_user");	
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("login-button")).click();
		String actualWP = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		System.out.println(actualWP);
		String expectedWP = "Epic sadface: Password is required";
		Assert.assertEquals(actualWP,expectedWP);
		
		
		//Unsuccessful login without username
	    
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("password")).clear();
		driver.get("https://www.saucedemo.com/");
		driver.navigate().refresh();
	
		//driver.findElement(By.id("user-name")).clear();	
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String actualWU = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
		System.out.println(actualWU);
		String expectedWU = "Epic sadface: Username is required";
		Assert.assertEquals(actualWU,expectedWU);
		
		 
		
		//Fetch page title on successful login
		Thread.sleep(3000);
		
		driver.findElement(By.id("password")).clear();
		driver.get("https://www.saucedemo.com/");
		driver.navigate().refresh();
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		driver.findElement(By.id("login-button")).click();
		String title=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
		System.out.println("Home Page Title:"+title);
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Login successful!");
			   
//		
		//
		
		}
	
	public static void Cart( )throws InterruptedException {
		
		
		//Verify adding a product to the cart
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SIDHARTH\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
	    Thread.sleep(3000);
	    
		//Verify removing a product from the cart
		
	    
	    driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("react-burger-menu-btn")).click();
	    Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		
		//Verify adding multiple products to the cart
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	    
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

		
		//Verify removing multiple products from the cart
		
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-bike-light\"]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id("react-burger-menu-btn")).click();
		 driver.findElement(By.id("logout_sidebar_link")).click();
		
		
		//Verify counting number display on Cart after adding product to the cart
		
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		 driver.findElement(By.id("login-button")).click();
		 Thread.sleep(3000);
		    
			driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
			Thread.sleep(3000);
			String countOfItems = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
			System.out.println("Count of total items is:" + countOfItems);
			Thread.sleep(3000);
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.id("logout_sidebar_link")).click();
			
			
	}

	public static void Checkout( )throws InterruptedException{
		//Verify successful checkout
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SIDHARTH\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("checkout")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("first-name")).sendKeys("Shivani");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("last-name")).sendKeys("Rana");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("postal-code")).sendKeys("123456");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("finish")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("back-to-products")).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
//	    
	    //verify unsuccessful checkout due to missing information
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");	
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("checkout")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("first-name")).sendKeys("Shivani");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("last-name")).sendKeys("Rana");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("postal-code")).sendKeys("");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
        
        String actual2 = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")).getText();
		System.out.println(actual2);
		String expected2 = "Error: Postal Code is required";
		
		Assert.assertEquals(actual2,expected2);
	    
		Thread.sleep(3000);
		
    
		//verify Cancel button functionality for selected product
		
	    
	    driver.findElement(By.id("cancel")).click();
	    Thread.sleep(2000);
		//Verify Continue Shopping button functionality on Checkout
		
	    
	    driver.findElement(By.id("continue-shopping")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
	    Thread.sleep(2000);
	   //Verify Filter functionality for checkout product
	    WebElement from=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
	    Select dropdown=new Select(from);
	    dropdown.selectByIndex(1);
	    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("checkout")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("first-name")).sendKeys("Shivani");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("last-name")).sendKeys("Rana");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("postal-code")).sendKeys("123456");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("finish")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("back-to-products")).click();
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
	@Test
	public static void main(String[] args) throws InterruptedException {
		//Login();
		//Cart();
		Checkout();
		
	}

}
	
