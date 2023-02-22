package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BGColorPage {

	WebDriver driver;

	public BGColorPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.CSS, using = "#extra > button:nth-child(12)")
	WebElement SkyBlueBGColorButton;
	@FindBy(how = How.CSS, using = "#extra > button:nth-child(13)")
	WebElement WhiteBGColorButton;
	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement WhiteBGColorBody;
	@FindBy(how = How.TAG_NAME, using = "body")
	WebElement SkyBlueBGColorBody;

	public boolean skyBlueButtonExists() {
		return SkyBlueBGColorButton.isDisplayed();
	}

	public boolean whiteButtonExists() {
		return WhiteBGColorButton.isDisplayed();
	}

	public void clickOnWhiteBG() {
		SkyBlueBGColorButton.click();
	}

	public void clickOnSkyBlueBG() {
		WhiteBGColorButton.click();
	}
	public String validateSkyBlueBGColor() {
		String domAttribute = SkyBlueBGColorBody.getAttribute("style");
		System.out.println(domAttribute);
		return domAttribute;
	}
	
	public String validateWhiteBGColor() {
		String domAttribute = WhiteBGColorBody.getAttribute("style");
		System.out.println(domAttribute);
		return domAttribute;
	}


	}

