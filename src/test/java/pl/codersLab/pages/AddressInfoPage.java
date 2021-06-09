package pl.codersLab.pages;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressInfoPage {
    private static WebDriver driver;

    @FindBy(xpath = "//*[@id=\"address-link\"]/span")
    private WebElement addFirstAddressButton;

    @FindBy(xpath = "//*[@id=\"addresses-link\"]/span")
    private WebElement addressesButton;

    @FindBy(xpath = "//*[@data-link-action='add-address']")
    private WebElement createNewAddress;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasInfoInput;
    private String alias = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input";

    @FindBy(name = "address1")
    private WebElement addressInfoInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement cityInfoInput;
    private String city = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input";

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement postcodeInfoInput;
    private String postcode = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input";

    @FindBy(name = "id_country")
    private WebElement countryInfoInput;
    private String country = "id_country";

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneInfoInput;
    private String phone = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input";

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveAddressButton;
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//section[@id='content']//div[@class='address-body']/h4/text()[1]")
    //div[@class='address-body']/address/text()[3]
    private WebElement aliasCheckAddress;
    //--------------------------------------------------------------------------------------------------------------------------------------------
    //Potraktować to jak jeden zbiór i iterować po nim
    //section[@id='content']//div[@class='address-body']/address
    //-------------------------------------------------------------------------------------------------------------------------------------------

    @FindBy(xpath = "//section[@id='content']//div[@class='address-body']/address/text()[2]")
    private WebElement addressCheckAddress;

    @FindBy(xpath = "//section[@id='content']//div[@class='address-body']/address/text()[3]")
    private WebElement cityCheckAddress;

    @FindBy(xpath = "//section[@id='content']//div[@class='address-body']/address/text()[4]")
    private WebElement postcodeCheckAddress;

    @FindBy(xpath = "//section[@id='content']//div[@class='address-body']/address/text()[5]")
    private WebElement countryCheckAddress;

    @FindBy(xpath = "//section[@id='content']//div[@class='address-body']/address/text()[6]")
    private WebElement phoneCheckAddress;
//----------------------------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement deleteButton;

    public AddressInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitAddFirstAddressButton() {
        try {
            addFirstAddressButton.click();
        } catch (ElementClickInterceptedException e) {
            e.getMessage();
            System.out.println("The first shipping address has been added");
        }
    }

    public void submitAddressesButton() {
        addressesButton.click();
    }

    public void submitCreateNewAddress() {
        createNewAddress.click();
    }

    public void setAliasInput(String alias) {
        aliasInfoInput.click();
        aliasInfoInput.clear();
        aliasInfoInput.sendKeys(alias);
        System.out.println("I entered my alias to address form: " + alias);
    }

    public void setAddressInput(String address) {
        addressInfoInput.click();
        addressInfoInput.clear();
        addressInfoInput.sendKeys(address);
        System.out.println("I entered my address1 to address form: " + address);
    }

    public void setCityInput(String city) {
        cityInfoInput.click();
        cityInfoInput.clear();
        cityInfoInput.sendKeys(city);
        System.out.println("I entered my city to address form: " + city);
    }

    public void setPostcodeInput(String postcode) {
        //postcodeInfoInput.click();
        postcodeInfoInput.clear();
        postcodeInfoInput.sendKeys(postcode);
        System.out.println("I entered my postcode to address form: " + postcode);
    }

    public void setCountryInput(String country) {
        Select id_country = new Select(countryInfoInput);
        id_country.selectByVisibleText(country);
        System.out.println("I entered my country to address form: " + country);
    }

    public void setPhoneInput(String phone) {
        phoneInfoInput.click();
        phoneInfoInput.clear();
        phoneInfoInput.sendKeys(phone);
        System.out.println("I entered my phone to address form: " + phone);
    }

    public void submitSignInButton() {
        saveAddressButton.click();
    }

    public String getAliasCheckAddress() {
        return aliasCheckAddress.getText();
    }

    public String getAddressCheck() {
        return addressCheckAddress.getText();
    }

    public String getPostcodeCheck() {
        return postcodeCheckAddress.getText();
    }

    public String getCityCheckAddress() {
        return cityCheckAddress.getText();
    }

    public String getCountryCheckAddress() {
        return countryCheckAddress.getText();
    }

    public String getPhoneCheckAddress() {
        return phoneCheckAddress.getText();
    }

    public void submitDeleteButton() {
        deleteButton.click();
    }

    public void showData() {
        System.out.println(addressCheckAddress.getText());
        System.out.println(postcodeCheckAddress.getText());
        System.out.println(cityCheckAddress.getText());
        System.out.println(countryCheckAddress.getText());
        System.out.println(phoneCheckAddress.getText());
    }
}
