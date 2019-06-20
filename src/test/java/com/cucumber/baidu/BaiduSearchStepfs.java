package com.cucumber.baidu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
public class BaiduSearchStepfs {
    private WebDriver driver;

    @Given("^Go to baidu\\.com$")
    public void go_to_baidu_com() throws Exception {
        // Write code here that turns the phrase above into concrete actionsT)
        String chromedriverpath="D:\\Program\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromedriverpath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com/");
        //  throw new PendingException();
    }

    @When("^I find baidu logo$")
    public WebElement i_find_baidu_logo() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='lg']/img"))));

        return element;
    }

    @And("^Type the search text \"([^\"]*)\"$")
    public void type_the_search_text(String searchText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //  throw new PendingException();
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys(searchText);
    }

    @And("^Click the submit$")
    public void click_the_submit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        driver.findElement(By.id("su")).click();
    }

    @Then("^wait the query result$")
    public void wait_the_query_result() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
        Thread.sleep(10000);
        Assert.assertEquals("selenium_百度搜索",driver.getTitle());
    }

}
