package MINI.PROJECT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GoogleProject extends DriverSetup {

	// Getting Url And Print Urls

	public void printurl() {

		List<WebElement> allUrls = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links in the Page is =" + " " + allUrls.size());
		for (WebElement link : allUrls) {
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
	}

	// Search Options And Printing You Can Type Anything And Search As Per Our Liking

	public void searchoptionsdisplayed() throws InterruptedException {

		WebElement e = driver.findElement(By.name("q"));
		// Here i gave hyderabad u can give anthing u want 
		e.sendKeys("hyderabad");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("aajZCb"))));
		List<WebElement> allSuggestions = driver.findElements(By.className("aajZCb"));
		for (WebElement webElement : allSuggestions) {
			List<WebElement> list = driver.findElements(By.className("sbct"));
			System.out.println("Number Of Search Options =" + " " + list.size());
			System.out.println(webElement.getText());
		}

	}

	// Screenshot Of Options Displayed

	public void screenshotoftheoptionsdisplayed() {

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshot, new File("Screenshot/screenshotofoptions.png"));
		} catch (Exception e1) {

			System.out.println(e1);
		}

	}

	// Enter Btn

	public void enter() {

		driver.findElement(By.className("gNO89b")).click();
	}

	// Search Results

	public void numberofsearchresults() throws InterruptedException {

		String t = driver.findElement(By.id("result-stats")).getText();
		System.out.println("Total Results" + " " + t);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	// Full Page Screenshot Of Search Results

	public void fullpagescreenshotofsearchresultspage() {

		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(fpScreenshot.getImage(), "PNG", new File("Screenshot/FullPageScreenshotResults.png"));
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	// Close Browser

	public void CloseBrowser() {

		{
			driver.quit();
		}
	}

}
