package com.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

	static {

		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setup() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
		    driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
		    driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
		    WebDriverManager.edgedriver().setup();
		    EdgeOptions option = new EdgeOptions();
		    option.addArguments("--inprivate");
		    driver = new EdgeDriver(option);
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

	}

	@After
	public void tearDown(Scenario status) {
		if (status.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(src,
						new File(System.getProperty("user.dir") + "/Screenshots/" + status.getName() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		driver.quit();
	}

	public WebElement waitForElement(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

	}

	public void selectByVisibleText(By ele, String value) {
		Select s = new Select(driver.findElement(ele));
		s.selectByVisibleText(value);

	}

	public void selectByIndex(By ele, int num) {
		Select s = new Select(driver.findElement(ele));
		s.selectByIndex(num);
	}

	public void selectByValue(By ele, String value) {
		Select s = new Select(driver.findElement(ele));
		s.selectByValue(value);
	}

	public void MouseHover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();

	}

	public void selectBootStrapDropdownValue(List<WebElement> list, String value) {
		for (WebElement ele : list) {
			String v = ele.getText();
			if (v.equals(value)) {
				ele.click();
				break;

			}

		}

	}

	public void WindowHandle(Set<String> windows, String expectedTitle) {

		for (String s : windows) {

			driver.switchTo().window(s);

			String actualTitle = driver.getTitle();

			if (actualTitle.contains(expectedTitle)) {
				break;

			}

		}

	}

	public void selectAlertPopup() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void selectFrame(String name) {
		driver.switchTo().frame(name);

	}

	public void clearAndEnterText(By ele, String value) {
		driver.findElement(ele).clear();
		driver.findElement(ele).sendKeys(value);
	}

	public void clickOnElement(By ele) {
		try {
			driver.findElement(ele).click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click;", driver.findElement(ele));
		}
	}

	public void ValidateText(By ele, String expectedText) {

		String actualText = driver.findElement(ele).getText();
		assertEquals(expectedText, actualText);
	}
	
}
