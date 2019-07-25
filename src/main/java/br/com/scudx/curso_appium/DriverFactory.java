package br.com.scudx.curso_appium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			criarDriver();
		}
		return driver;
	}

	public static void criarDriver() {
		try {

			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

			// Se for dispositivo físico
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "Moto G4");
			desiredCapabilities.setCapability("automation", "uiautomator2");
			desiredCapabilities.setCapability(MobileCapabilityType.APP,
					"C:\\Users\\roger\\Documents\\Workspaces\\Java\\curso-appium\\apk\\agendapp_1.0.apk");

			// Se for dispositivo virtual
			// desiredCapabilities.setCapability("platformName", "Android");
			// desiredCapabilities.setCapability("deviceName", "Moto G4");
			// desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
			// desiredCapabilities.setCapability("appActivity",
			// "com.android.calculator2.Calculator");

			URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

			driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		} catch (Exception e) {
			System.out.printf("Erro ao carregar o driver!");
		}
	}

	public static void fecharDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
