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
    public void i_am_logged_in_to_CodersLab_shop_and_click_to_button_Addresses() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
        this.addressInfoPage = new AddressInfoPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("krwrseepkmzaomxhbv@twzhhq.online", "Pass123");

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    @When("^I enter my \"([^\"]*)\" in the alias input$")
    public void i_enter_my_in_the_alias_input(String alias) {
        addressInfoPage.setAliasInput(alias);
    }

    @And("^I enter my \"([^\"]*)\" in the address input$")
    public void i_enter_my_in_the_address_input(String address) {
        addressInfoPage.setAddressInput(address);
    }

    @And("^I enter my \"([^\"]*)\" in the city input$")
    public void i_enter_my_in_the_city_input(String city) {
        addressInfoPage.setCityInput(city);
    }

    @And("^I enter my \"([^\"]*)\" in the postcode input$")
    public void i_enter_my_in_the_zip_postal_code_input(String postcode) {
        addressInfoPage.setPostcodeInput(postcode);
    }

    @And("^I select my \"([^\"]*)\" in the country input$")
    public void i_select_my_in_the_country_input(String country) {
        addressInfoPage.setCountryInput(country);
    }

    @And("^I enter my \"([^\"]*)\" in the phone input$")
    public void i_enter_my_in_the_phone_input(String phone) {
        addressInfoPage.setPhoneInput(phone);
    }

    @And("^I click the Submit button$")
    public void i_click_the_Submit_button() {
        addressInfoPage.submitSignInButton();
    }

    @And("^I check if \"([^\"]*)\" in the alias added address is correct$")
    public void i_check_if_my_in_the_alias_added_address_is_correct(String alias) {
        Assert.assertEquals("alias", addressInfoPage.getAliasCheckAddress());
    }

    @And("^I check if \"([^\"]*)\" in the address added address is correct$")
    public void i_check_if_my_in_the_address_added_address_is_correct(String address1) {
        Assert.assertEquals("address1", addressInfoPage.getAddressCheck());
    }

    @And("^I check if \"([^\"]*)\" in the city added address is correct$")
    public void i_check_if_my_in_the_city_added_address_is_correct(String city) {
        Assert.assertEquals("city", addressInfoPage.getCityCheckAddress());
        ;
    }

    @And("^I check if \"([^\"]*)\" in the the postcode added address is correct$")
    public void i_check_if_my_in_the_the_zip_postal_added_address_is_correct(String postcode)  {
        Assert.assertEquals("postcode", addressInfoPage.getPostcodeCheck());
    }

    @And("^I check if \"([^\"]*)\"in the country added address is correct$")
    public void i_check_if_my_in_the_country_added_address_is_correct(String country)  {
        Assert.assertEquals("country", addressInfoPage.getCountryCheckAddress());
    }

    @And("^I check if \"([^\"]*)\" in the phone added address is correct$")
    public void i_check_if_my_in_the_phone_added_address_is_correct(String phone)  {
        Assert.assertEquals("phone", addressInfoPage.getPhoneCheckAddress());
    }

    @Then("^I deletes the added address$")
    public void i_deletes_the_added_address() {
        addressInfoPage.submitDeleteButton();
    }
}

