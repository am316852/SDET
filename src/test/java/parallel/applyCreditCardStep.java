package parallel;

import static org.junit.Assert.assertTrue;

import driverfactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ApplyCreditCardPage;

public class applyCreditCardStep {

	ApplyCreditCardPage loginStepPage = new ApplyCreditCardPage(DriverFactory.getDriver());
	private static String title;

	@Given("user is on apply credit card page")
	public void user_is_on_apply_credit_card_page() {
		DriverFactory.getDriver()
		.get("http://localhost:3000/");

	}

	@When("user see the title of the page")
	public void user_see_the_title_of_the_page() {
		title = loginStepPage.getLoginPageTitle();
	}

	@Then("page  title should be {string}")
	public void page_title_should_be(String pageTitle) {
		
		assertTrue(title.equals(pageTitle));
	}

	@When("user enters name {string}")
	public void user_enters_name(String name1) {
	loginStepPage.enterName(name1);
	}

	@When("user enters email {string}")
	public void user_enters_email(String mail) {
		loginStepPage.enterEmail(mail);
	}

	@When("user enters address {string}")
	public void user_enters_address(String add) {
		loginStepPage.enterAddress(add);
	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		loginStepPage.clickSubmitButton();
	
	}

	@Then("user should the eligible credit card name {string}")
	public void user_should_the_eligible_credit_card_name(String card) {
		String cards= loginStepPage.getCardType();
		
		assertTrue("no card available for user",cards.equals(card));

			}
	
	
	@Then("user should be displayed declined message")
	public void user_should_be_displayed_declined_message() {
		String msg= loginStepPage.getDecllinedMsg();
		
		assertTrue("Unfortunately you're not eligible for any cards".equals(msg));

			}


}
