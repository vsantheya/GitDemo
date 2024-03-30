package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public ConfirmationPage confirmationPage ;

	
	@Given("I landed on login page")
	public void I_Landed_loginpage() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^logged in with username(.+) and password(.+)$")
	public void Logged_with_username_password(String userName, String passWord) {
		productCatalogue = landingPage.loginApplication(userName, passWord);
	}

	@When("^I add product(.+) to cart$")
	public void Add_product_toCart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		//productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
	}

	@When("^checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed in confirmation page")
	public void message_displayed_inconfirmationpage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	/*
	@Then("{abc} message is displayed in login page")
	public void message_displayed_loginpage(String abc)
	{
		String msg = landingPage.getErrorMessage();
	Assert.assertTrue(msg.equalsIgnoreCase(abc));
	driver.close();
	}*/
}
