package util;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class JunitListener extends TestWatcher {

    private WebDriver driver;
    private String screenshotsReportFolder = "target/screenshot/";

    @Override
    protected void failed(Throwable e, Description description) {
        takeScreenShot(description);
        System.err.println("!!! A test has failed !!! " + description.getMethodName());
    }

    @Override
    protected void succeeded(Description description) {
        System.out.println("=== The test(s) has succeeded its execution === " + description.getMethodName());
    }

    @Override
    public void finished(Description description) {
        System.out.println("========= THE TEST EXECUTION HAS BEEN COMPLETED =========" + description.getMethodName());
        driver.quit();
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private void takeScreenShot(Description description) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenshotsReportFolder + description.getMethodName() + ".png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}