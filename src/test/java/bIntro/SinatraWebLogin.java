package bIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SinatraWebLogin {
    public static void main(String[] args){
        try{
        //navegar a la pagina
        WebDriver driver;
        //arrancar el navegador
        driver = new ChromeDriver();
        //inicializar las esperas
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //indicarle la url que se abrira.
        driver.get("https://evening-bastion-49392.herokuapp.com/");

        //verificar que exista la liga de login
        //localizar el elemento de login
        WebElement login = driver.findElement(By.cssSelector("footer a[href=\"/login\"]"));

        //preguntar si esta visible
         if(login.isDisplayed()){
             System.out.println("Esta visible el login");
         }
        //darle click
        login.click();
        //localizar los tres elementos

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement botonLogin = driver.findElement(By.cssSelector("[value=\"Log In\""));

        //verificar que existen los campos de username, password, boton login

        if(username.isDisplayed() && password.isDisplayed() && botonLogin.isDisplayed()){
            System.out.println("Se encuentran visibles el login");
        }else{
            System.out.println("No se encuentra visible el login");
            System.exit(-1);
        }
        //preguntar si estan visibles
        if(username.isEnabled() && password.isEnabled() && botonLogin.isEnabled()){
            System.out.println("Se encuentran habilitados los campos");
        }
        //ingresar los datos en campos de username y password
        username.sendKeys("frank");
        password.sendKeys("sinatra");

        //click a login
        botonLogin.click();


        //verificar el mensaje de bienvenida
        WebElement messageWelcome = driver.findElement(By.cssSelector("div .flash"));
        //encontar el elemento del mensaje
        //preguntar si esta visible, y contiene el texto necesario
        if(messageWelcome.isDisplayed() && messageWelcome.getText().contains("You are now logged in as frank")){
            //verificar que aparece la pagina de 'Songs'
            WebElement pageSong= driver.findElement(By.cssSelector("div .flash"));
            if(pageSong.isDisplayed()){
                System.out.println("Se encuentra visible el mensaje de bienvenida");
            }else{
                System.out.println("No se encuentra visble el mensaje de bienvenida");
            }
            //encontar el header
            WebElement header = driver.findElement(By.cssSelector("header"));
            //encontrar la liga de create a new song
            WebElement createSong= driver.findElement(By.cssSelector("[href=\"/songs/new\"]"));
            //preguntar si estan visibles
            if(createSong.isDisplayed()){
                System.out.println("Esta visible");
            }else{
                System.out.println("No se encuentra visible");
            }

        }

        }catch (Exception ex){
            throw ex;
        }

    }
}
