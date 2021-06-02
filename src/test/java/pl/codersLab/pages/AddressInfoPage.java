package pl.codersLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressInfoPage {
    private static WebDriver driver;

    @FindBy(xpath= "//*[@data-link-action='add-address']")
    private WebElement createNewAddress;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement aliasInfoInput;
    private String alias ="//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input";

    @FindBy(name = "address1")
    private WebElement addressInfoInput;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement cityInfoInput;
    private String city = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input";

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement postcodeInfoInput;
    private  String postcode = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input";

    @FindBy(name = "id_country")
    private WebElement countryInfoInput;
    private String country = "id_country";

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneInfoInput;
    private String phone = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input";

    @FindBy(xpath =  "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveAddressButton;

    public AddressInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void setAliasInput(String alias) {
        aliasInfoInput.click();
        aliasInfoInput.clear();
        aliasInfoInput.sendKeys(alias);
    }

    public void setAddressInput(String address) {
        addressInfoInput.click();
        addressInfoInput.clear();
        addressInfoInput.sendKeys(address);
    }

    public void setCityInput(String city) {
        cityInfoInput.click();
        cityInfoInput.clear();
        cityInfoInput.sendKeys(city);
    }

    public void setPostcodeInput(String postcode) {
        //postcodeInfoInput.click();
        postcodeInfoInput.clear();
        postcodeInfoInput.sendKeys(postcode);
    }

    public void setCountryInput(String country) {
        Select id_country = new Select(countryInfoInput);
        id_country.selectByVisibleText(country);
    }

    public void setPhoneInput(String phone) {
        phoneInfoInput.click();
        phoneInfoInput.clear();
        phoneInfoInput.sendKeys(phone);
    }
    public void submitSignInButton() {
        saveAddressButton.click();
    }

    public String getAliasInfoInput() {
        return aliasInfoInput.getText();
    }
}
