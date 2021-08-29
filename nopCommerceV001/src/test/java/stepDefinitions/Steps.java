package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class Steps
{
    public WebDriver driver;
    public LoginPage lp; // global methods
    @Given("User launch chrome browser")
    public void user_launch_chrome_browser()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver");
        driver=new ChromeDriver();
        lp = new LoginPage(driver);
    }
    @When("User opens URL {string}")
    public void user_opens_URL(String url)
    {
        driver.get(url);
    }
    @When("User enters Email as {string} and Password as {String}")
    public void user_enters_Email_as_and_Password_as_(String email, String password2)
    {
        lp.setUserName(email);
        lp.setPassword(password2);
    }
    @When("Click on Login")
    public void click_on_Login()
    {
        lp.clickLogin();
    }
    @Then("Page Title should be {String}")
    public void page_Title_should_be (String title)
    {
        if(driver.getPageSource().contains("Login was unsuccessful."))
        {
            driver.close();
            Assert.assertTrue(false);
        } else
        {
            Assert.assertEquals(title, driver.getTitle());
        }
    }
    @When("User click on logout link")
    public void user_click_on_logout_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }
    @Then("lose browser")
    public void close_browser ()
    {
        driver.quit();
    }

}