import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainClassTest3 {
    private WebDriver driver;
    private MainPage3 mainPage;

    @BeforeMethod
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage3(driver);



    }
    @Test
    public void comparePasteTest(){
        String pasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String titleText = "how to gain dominance among developers";
        String syntaxType = "Bash";
        String expirationValue = "10 Minutes";
        ResultPage3 resultPage = mainPage.clickSubmit(pasteText, titleText, syntaxType,expirationValue);
        String actualResultPaste= resultPage.getResultText(syntaxType);
        Assert.assertEquals(actualResultPaste, pasteText);

    }

    @Test
    public void compareSyntaxTest () {
        String pasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String titleText = "how to gain dominance among developers";
        String syntaxType = "Bash";
        String expirationValue = "10 Minutes";
        ResultPage3 resultPage = mainPage.clickSubmit(pasteText, titleText, syntaxType,expirationValue);
        String actualResultSyntax= resultPage.getSyntax();
        Assert.assertEquals(actualResultSyntax, syntaxType);
    }

    @Test
    public void compareTitleTest () {
        String pasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String titleText = "how to gain dominance among developers";
        String syntaxType = "Bash";
        String expirationValue = "10 Minutes";
        ResultPage3 resultPage = mainPage.clickSubmit(pasteText, titleText, syntaxType,expirationValue);
        String actualResultTitle= resultPage.getTitle();
        Assert.assertEquals(titleText + " - Pastebin.com", driver.getTitle());
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }
}
