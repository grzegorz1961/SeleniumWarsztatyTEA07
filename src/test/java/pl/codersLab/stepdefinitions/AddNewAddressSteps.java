package pl.codersLab.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.codersLab.pages.AddressInfoPage;
import pl.codersLab.pages.LoginPage;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;


public class AddNewAddressSteps {
    private WebDriver driver;
    AddressInfoPage addressInfoPage;

    @Given("I am logged in to CodersLab and create new address$")
    public void i_am_logged_in_to_CodersLab_shop_and_click_to_button_Addresses(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
        this.addressInfoPage = new AddressInfoPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("nkssnglcxxajzysope@twzhhq.com", "Kasia2021!");

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    @When("^I enter my \"([^\"]*)\" in the alias input$")
    public void i_enter_my_in_the_alias_input(String alias){
        addressInfoPage.setAliasInput(alias);
    }

    @And("^I enter my \"([^\"]*)\" in the address input$")
    public void i_enter_my_in_the_address_input(String address) {
        addressInfoPage.setAddressInput(address);
    }

    @And("^I enter my \"([^\"]*)\" in the city input$")
    public void i_enter_my_in_the_city_input(String city){
        addressInfoPage.setCityInput(city);
    }
    @And("^I enter my \"([^\"]*)\" in the zip/postal code input$")
    public void i_enter_my_in_the_zip_postal_code_input(String postcode) {
        addressInfoPage.setPostcodeInput(postcode);
    }

    @And("^I select my \"([^\"]*)\" in the country input$")
    public void i_select_my_in_the_country_input(String country)  {
        addressInfoPage.setCountryInput(country);
    }

    @And("^I enter my \"([^\"]*)\" in the phone input$")
    public void i_enter_my_in_the_phone_input(String phone)  {
        addressInfoPage.setPhoneInput(phone);
    }

    @And("^I click the Submit button$")
    public void i_click_the_Submit_button() {
        addressInfoPage.submitSignInButton();
    }

//    @Then("^I check if \"([^\"]*)\" in the added address is correct$")
//    public void iCheckIfInTheAddedAddressIsCorrect(String alias) throws Throwable {
//        assertEquals("alias",addressInfoPage.getAliasInfoInput());
//        throw new PendingException();
//    }
}

