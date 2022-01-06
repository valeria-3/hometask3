import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage3 {
    private WebDriver driver;

    public MainPage3 (WebDriver driver){

        this.driver = driver;
    }

    private By newPaste = By.id("postform-text");
    private By syntax = By.xpath("//span[@id='select2-postform-format-container']");
    private By pasteExpiration = By.xpath("//span[@id='select2-postform-expiration-container']");
    private By title = By.id("postform-name");
    private By submitButton = By.xpath("//button[text()= 'Create New Paste']");





    public MainPage3 typePaste(String newPasteText) {
        driver.findElement(newPaste).sendKeys(newPasteText);
        return this;
    }
    public MainPage3 typeTitle(String titleText) {
        driver.findElement(title).sendKeys(titleText);
        return this;
    }
    public MainPage3 selectSyntax(String syntaxType) {
        driver.findElement(syntax).click();
        String syntaxXpath = "//li[text() = '%s']";
        driver.findElement(By.xpath(String.format(syntaxXpath,syntaxType))).click();
        return this;
    }

    public MainPage3 selectPasteExpiration(String expirationValue) {
        driver.findElement(pasteExpiration).click();
        String expirationXpath = "//li[text() = '%s']";
        driver.findElement(By.xpath(String.format(expirationXpath, expirationValue))).click();
        return this;
    }

    public ResultPage3 clickSubmit(String newPasteText, String titleText, String syntaxType, String expirationValue) {
        this.typePaste(newPasteText);
        this.typeTitle(titleText);
        this.selectSyntax(syntaxType);
        this.selectPasteExpiration(expirationValue);
        driver.findElement(submitButton).click();
        return new ResultPage3(driver);
    }
}
