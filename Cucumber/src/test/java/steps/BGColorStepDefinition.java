package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.BGColorPage;
import pages.testBase;

public class BGColorStepDefinition extends testBase {

	BGColorPage bGColorPage;

	@Before
	public void beforeRun() throws InterruptedException {
		initDriver();
		bGColorPage = PageFactory.initElements(driver, BGColorPage.class);
		driver.get("https://techfios.com/test/102/");
	}

	@Given("{string} button exists")
	public void buttonExists(String Button) {
		if (Button.equalsIgnoreCase("Set SkyBlue Background")) {
			Assert.assertTrue(bGColorPage.skyBlueButtonExists());
		} else if (Button.equalsIgnoreCase("Set SkyWhite Background")) {

			Assert.assertTrue(bGColorPage.whiteButtonExists());
		}
	}

	@When("I click on the {string}")
	public void set_skyblue_BG(String Button) {
		if (Button.equalsIgnoreCase("Set SkyBlue Background")) {
			bGColorPage.clickOnSkyBlueBG();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @When("I click on the button") public void set_white_BG(String Button) { if
	 * (Button.equalsIgnoreCase("Set White Background")) {
	 * bGColorPage.clickOnWhiteBG(); } try { Thread.sleep(3000); } catch
	 * (InterruptedException e) { e.printStackTrace(); } }
	 */

@Then("The background color will change to {string}")
public void bgColorCangeToSkyBlue(String bgColor) {
	if (bgColor.equalsIgnoreCase("SkyBlue")) {
//Assert.assertEquals("background-color: skyblue;" bGColorPage.validateSkyBlueBGColor());
	bGColorPage.validateSkyBlueBGColor();
	}
	else if (bgColor.equalsIgnoreCase("White")) {
//		Assert.assertEquals("background-color: white;" bGColorPage.validateWhiteBGColor());
		bGColorPage.validateWhiteBGColor();
	}
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
