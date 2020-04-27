package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static IOSDriver<MobileElement> driver;

    protected static  IOSDriver getDRIVER() {
        return driver;
    }

    public static void createDriver(){
        try {
        File app = new File("src/main/resources/", "app-demo-debug.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "false");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");


            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new IOSDriver<MobileElement>(url, desiredCapabilities);
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
