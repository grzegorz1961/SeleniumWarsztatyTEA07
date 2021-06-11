package pl.codersLab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;


public class AddressInfoPage {
    private static WebDriver driver;

    @FindBy(xpath = "//*[@class='addresses-footer']//a")
    private WebElement createNewAddress;

    @FindBy(xpath = "//div[@class='user-info']//span")
    private static WebElement nameUser;

    @FindBy(xpath = "//section[@id='content']//article/div[@class='address-body']")
    private List<WebElement> listDateAddress;

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

    @FindBy(xpath = "//*[@id='content']//button")
    private WebElement saveAddress;

    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement deleteButton;

    @FindBy(css = "#notifications > div > article > ul > li")
    private WebElement messageDeleteAddress;

    public AddressInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitCreateNewAddress() {
        createNewAddress.click();
    }

    public void setAliasInput(String alias) {
        aliasInfoInput.sendKeys(alias);
    }

    public void setAddressInput(String address) {
        addressInfoInput.sendKeys(address);
    }

    public void setCityInput(String city) {
        cityInfoInput.sendKeys(city);
    }

    public void setPostcodeInput(String postcode) {
        postcodeInfoInput.sendKeys(postcode);
    }

    public void setCountryInput(String country) {
        Select id_country = new Select(countryInfoInput);
        id_country.selectByVisibleText(country);
    }
    public void setPhoneInput(String phone) {
        phoneInfoInput.sendKeys(phone);
    }

    public void submitSaveButton() {
        saveAddress.click();
    }

    public static String getNameUser() {
        return nameUser.getText();
    }

    public void checkAddressList(String listData) {
        int listDataSize = listDateAddress.size();
        String newCreateAddress = listDateAddress.get(listDataSize - 1).getText();
        Assert.assertEquals(listData, newCreateAddress);
    }

    public void submitDeleteButton() {
        deleteButton.click();
    }

    public void checkListEmpty() {
        if (listDateAddress.isEmpty()) {
            Assert.assertEquals("Address successfully deleted!", messageDeleteAddress.getText());
        }
    }
}
