package pl.codersLab.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pl.codersLab.function.LoginSetUp;
import pl.codersLab.pages.AddressInfoPage;
import pl.codersLab.pages.LoginPage;

public class AddNewAddressSteps {
    private WebDriver driver;
    AddressInfoPage addressInfoPage;
    String listDataString;

    @Given("I am logged in to CodersLab$")
    public void i_am_logged_in_to_CodersLab_shop_and_click_to_button_Addresses() {
        this.driver = LoginSetUp.setUp();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

        this.addressInfoPage = new AddressInfoPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("krwrseepkmzaomxhbv@twzhhq.online", "Pass123");
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
    }

    @When("^I and create new address$")
    public void i_and_create_new_address() {
        addressInfoPage = new AddressInfoPage(driver);
        addressInfoPage.submitCreateNewAddress();
    }

    @And("^I enter my \"([^\"]*)\" in the alias input$")
    public void i_enter_my_in_the_alias_input(String alias) {
        addressInfoPage = new AddressInfoPage(driver);
        addressInfoPage.setAliasInput(alias);
        listDataString = alias + "\n" + AddressInfoPage.getNameUser();
    }

    @And("^I enter my \"([^\"]*)\" in the address input$")
    public void i_enter_my_in_the_address_input(String address1) {
        addressInfoPage.setAddressInput(address1);
        listDataString += "\n" + address1;
    }

    @And("^I enter my \"([^\"]*)\" in the city input$")
    public void i_enter_my_in_the_city_input(String city) {
        addressInfoPage.setCityInput(city);
        listDataString += "\n" + city;
    }

    @And("^I enter my \"([^\"]*)\" in the postcode input$")
    public void i_enter_my_in_the_zip_postal_code_input(String postcode) {
        addressInfoPage.setPostcodeInput(postcode);
        listDataString += "\n" + postcode;
    }

    @And("^I select my \"([^\"]*)\" in the country input$")
    public void i_select_my_in_the_country_input(String country) {
        addressInfoPage.setCountryInput(country);
        listDataString += "\n" + country;
    }

    @And("^I enter my \"([^\"]*)\" in the phone input$")
    public void i_enter_my_in_the_phone_input(String phone) {
        addressInfoPage.setPhoneInput(phone);
        listDataString += "\n" + phone;
    }

    @And("^I click the Submit button$")
    public void i_click_the_Submit_button() {
        addressInfoPage.submitSaveButton();
    }

    @Then("^I check the correctness of the saved address$")
    public void i_check_the_correctness_of_the_saved_address() {
        addressInfoPage.checkAddressList(listDataString);
        // The second way to check the correctness of the entered address
        Assert.assertTrue(listDataString.contains("janek01"));
        Assert.assertTrue(listDataString.contains("Nawrot 24"));
        Assert.assertTrue(listDataString.contains("Lodz"));
        Assert.assertTrue(listDataString.contains("91-609"));
        Assert.assertTrue(listDataString.contains("United Kingdom"));
        Assert.assertTrue(listDataString.contains("+48 687-896-567"));
    }

    @Then("^I delete the entered address$")
    public void i_delete_the_entered_address() {
        addressInfoPage.submitDeleteButton();
    }

    @Then("^I check if the address has been removed$")
    public void i_check_if_the_address_has_been_removed() {
        addressInfoPage.checkListEmpty();
        // The second way to check if the address has been removed
        Assert.assertTrue(listDataString.contains(""));
        System.out.println("I checked that the address has been removed");
    }
}

