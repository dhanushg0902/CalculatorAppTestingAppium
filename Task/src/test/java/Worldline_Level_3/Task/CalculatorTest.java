package Worldline_Level_3.Task;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {
        try {
            openCalculator();
        } catch (Exception exp) {
            System.out.println("Exception occurred: " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    public static void openCalculator() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "14");
        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
        System.out.println("Application Started.....");
        
        MobileElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement four = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
       
        two.click();
        plus.click();
        four.click();
        equals.click();
        
        MobileElement result = driver.findElement(By.className("android.widget.TextView"));
        
        String res = result.getText();
        System.out.println("Result is :"+ res );
        System.out.println("Completed....");
        
    }
}
