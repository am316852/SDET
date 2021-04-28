package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import configreaders.PropertiesReader;
import driverfactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	Properties prop;
	private PropertiesReader propertiesReader;
	private DriverFactory driverfactory;
	WebDriver driver;

	@Before(order = 0)
	public void getProperty() {

		propertiesReader = new PropertiesReader();
		prop = propertiesReader.getProperties();

	}

	@Before(order = 1)
	public void launchBrowser() {
		driverfactory = new DriverFactory();
		driver = driverfactory.initDriver(prop.getProperty("browser"));

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}

	}
}
