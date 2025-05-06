package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucedemoLoginTest {
    private AndroidDriver driver;
    private long startTime;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Configurar as Desired Capabilities usando BaseOptions
        BaseOptions options = new BaseOptions();
        options.setCapability("platformName", "Android");
        options.setCapability("deviceName", "emulator-5554");
        options.setCapability("automationName", "UiAutomator2");
        options.setCapability("browserName", "Chrome");
        options.setCapability("noReset", true);

        // Inicializar o driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void testLoginSaucedemo() {
        System.out.println("Iniciando teste de login no Saucedemo...");
        startTime = System.currentTimeMillis();

        // Acessar o site
        driver.get("https://www.saucedemo.com/");

        // Preencher o usuário
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Preencher a senha
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Clicar no botão de login
        driver.findElement(By.id("login-button")).click();

        // Verificar se o login foi bem-sucedido
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html", "Login falhou!");

        // Calcular o tempo de execução
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000;
        System.out.println("Tempo de execução: " + duration + " segundos");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}