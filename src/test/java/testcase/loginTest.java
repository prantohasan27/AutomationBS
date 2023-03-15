package testcase;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver.Timeouts;

import base.baseTest;


public class loginTest extends baseTest{

    // TC -7861
    @Test
    public static void LoginTC() throws InterruptedException {



        driver.findElement(By.id("username")).sendKeys("vinod.bendre@axtria.com.int");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("@xtria@123");
        Thread.sleep(2000);
        driver.findElement(By.id("Login")).click();

        driver.findElement(By.xpath("//a[@title='Inquiry']")).click();


        driver.findElement(By.xpath("//button[contains(text(),\"Create Inquiry\")]")).click();
    }

    @Test
    public static void SecondTC() throws InterruptedException {
        driver.findElement(By.xpath("sd")).click();
    }

}
