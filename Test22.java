package Pack1;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test22 {
    private static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeClass
    public static void setup() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.chase.com");
    }

    @Test
    public void test01_pagetitle() throws Exception {
        Assert.assertEquals("Credit Card, Mortgage, Banking, Auto | Chase Online | Chase.com", driver.getTitle());
    }

    @Test
    public void test02_pageloaded() throws Exception {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }

    @Test
    public void test03_pagescroll() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void test04_pagecheck() throws Exception {
        Assert.assertEquals("© 2018 JPMorgan Chase & Co.", driver.findElement(By.xpath("/html/body/div/footer/div/div[3]/div/div/div/div[2]/p[2]")).getText());
    }

    @Test
    public void test05_clickOB() throws Exception {
        driver.findElement(By.xpath("/html/body/div/footer/div/div[2]/div/div/div[2]/div[2]/ul/li[1]/a")).click();
    }

    @Test
    public void test06_clickEN() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"started\"]/div[1]/div/div/div/div[3]/div/a")); // прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"started\"]/div[1]/div/div/div/div[3]/div/a")).click();
    }

    @Test
    public void test07_usernameinput() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"userId-text-input-field\"]")); // прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"userId-text-input-field\"]")).sendKeys("bmametyarov1");
    }

    @Test
    public void test08_usernamecheck1() throws Exception {
        Assert.assertEquals(" Green Check. Meets requirement:Must be 8-32 characters long", driver.findElement(By.xpath("//*[@id=\"userIdRequirementsArea\"]/div[1]")).getAttribute("innerText"));
        Assert.assertEquals(" Green Check. Meets requirement:Must contain at least 1 letter and 1 number", driver.findElement(By.xpath("//*[@id=\"userIdRequirementsArea\"]/div[2]")).getAttribute("innerText"));
        Assert.assertEquals(" Green Check. Meets requirement:Must not contain special characters (&, %, *, etc.)", driver.findElement(By.xpath("//*[@id=\"userIdRequirementsArea\"]/div[3]")).getAttribute("innerText"));
        WebElement chk1 = driver.findElement(By.xpath("//*[@id=\"userId-text-input-field\"]"));




        
    }


    @AfterClass
    public static void test99_quit() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }


}
