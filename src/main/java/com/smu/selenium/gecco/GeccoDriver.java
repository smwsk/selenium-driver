package com.smu.selenium.gecco;

import com.smu.selenium.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author wangshaokui
 * @version 1.0
 * @className GeccoDriver
 * @time 2018/12/26 16:00
 **/
public class GeccoDriver {
    private final static String CONFIG_PROPERTIES_PATH = "systemConfig.properties";

    private static Properties configProperties = new PropertiesUtil(CONFIG_PROPERTIES_PATH).getProperties();
    /**
     * 获取火狐浏览器驱动
     *
     * @return
     */
    public static FirefoxDriver getFireFoxDriver() {

        System.setProperty("webdriver.gecko.driver", configProperties.getProperty("webdriver.gecko.driver"));
        File pathToBinary = new File(configProperties.getProperty("webdriver.firefox.bin"));
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathToBinary);
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        return driver;
    }

    /**
     * 获取谷歌浏览器驱动
     *
     * @return
     */
    public static ChromeDriver getChromDriver() {
        System.setProperty("webdriver.chrome.driver", configProperties.getProperty("webdriver.chrome.driver"));
        File pathToBinary = new File(configProperties.getProperty("webdriver.chrome.bin"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(pathToBinary);
        chromeOptions.setHeadless(true);
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        return chromeDriver;
    }

    public static void main(String[] args) {
        String url = "https://www.aliexpress.com/category/100003109/women-clothing-accessories.html?spm=2114.11010108.101.1.650c649becIQZn";
        long startMillis = System.currentTimeMillis();
//        FirefoxDriver driver = getFireFoxDriver();
        ChromeDriver driver = getChromDriver();
        try {
            driver.get(url);
            System.out.println("标题：" + driver.getCurrentUrl());
            WebElement nextElement = driver.findElementByClassName("page-next");
            String elementAttribute = nextElement.getAttribute("href");
            driver.get(elementAttribute);
            System.out.println("下一个元素内容" + driver.getCurrentUrl());
        } finally {
            driver.quit();
        }
        long endMillis = System.currentTimeMillis();
        System.out.println("耗时：" + (endMillis - startMillis) / 1000);
    }
}
