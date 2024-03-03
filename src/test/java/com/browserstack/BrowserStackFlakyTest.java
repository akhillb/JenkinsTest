package com.browserstack;
import java.util.Random;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserStackFlakyTest extends SeleniumTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addFlakyTest() throws Exception {
        int min = 0; // Minimum value of the range (inclusive)
        int max = 2; // Maximum value of the range (exclusive)
        // navigate to bstackdemo
        driver.get("https://www.bstackdemo.com");

        // Check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));

        // Save the text of the product for later verify
        String productOnScreenText = driver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        // Click on add to cart button
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();

        // See if the cart is opened or not
        Assert.assertTrue(driver.findElement(By.cssSelector(".float\\-cart__content")).isDisplayed());

        // Check the product inside the cart is same as of the main page
        String productOnCartText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]")).getText();
        Random random = new Random();
        int randomNumber = random.nextInt(max - min) + min;
        System.out.println(randomNumber);

            Assert.assertEquals("JaiminFlakyTest", productOnCartText);
        }
    }
