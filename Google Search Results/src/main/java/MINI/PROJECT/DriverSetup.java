package MINI.PROJECT;

import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	WebDriver driver;
	FileReader fr;
	Properties p;

	public void driverSetup() {
		try

		{
			driver = null;
			fr = new FileReader("Configure Properties/Config.properties");
			Properties p = new Properties();
			p.load(fr);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice\n1.Chrome Browser\n2.Firefox Browser");
			int ch = sc.nextInt();
			if (ch == 1) {
				System.setProperty("webdriver.chrome.driver", ".\\WebDriver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(p.getProperty("Url"));
			} else if (ch == 2) {
				fr = new FileReader("Configure Properties/Config.properties");
				Properties p1 = new Properties();
				p1.load(fr);
				System.setProperty("webdriver.gecko.driver", ".\\WebDriver\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(p.getProperty("Url"));

			}

		} catch (Exception e) {

			System.out.println(e);
		}
	}

}
