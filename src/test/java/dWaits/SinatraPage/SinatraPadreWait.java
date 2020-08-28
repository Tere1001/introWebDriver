package dWaits.SinatraPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SinatraPadreWait {

    static WebDriver driver;
    static WebDriverWait wait;
    public static void navegarPagina() {
        driver= new ChromeDriver();
        //inicializar las esperas
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        //indicarle la url que se abrira.
        driver.get("https://evening-bastion-49392.herokuapp.com/");

    }

    public static void verificarPaginaHome() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt=\"Frank Sinatra\"]")));
    }

    public static void clickLogin() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("footer a[href=\"/login\"]"))).click();
    }

    public static void verificarPaginaLogin() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[value=\"Log In\"")));

    }

    public static void ingresarCredenciales(String u, String p) {
        //ingresar los datos en campos de username y password
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username"))).sendKeys(u);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).sendKeys(p);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[value=\"Log In\""))).click();
    }

    public static void verificarPaginaSongs() {
       wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div .flash")));
    }

    public static void verificarMensajeBienvenida() {
        //verificar el mensaje de bienvenida
        WebElement Mensaje= driver.findElement(By.cssSelector("div .flash"));
        wait.until(ExpectedConditions.textToBePresentInElement(Mensaje,"You are now logged in as frank"));
        System.out.println("Se verifica mensaje bienvenida");
    }

}
