package cHomeworks.SeleccionarCelular;

import dWaits.SeleccionarCelularTelcel.CelularWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleccionarCelular {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        navegarPagina("https://www.telcel.com/");
        verificarHomePage();
        seleccionarTelefonosYSmartphones();
        verificarModalSeleccionaTuEstado();
        seleccionarEstado("Jalisco");
        verificarListaTelefonos();
        Celular cel = capturarInformacionTelefono(1);
        clickTelefono(1);
        verificarInformacionCelular(cel);

    }

    private static void navegarPagina(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get(url);

    }

    private static void verificarHomePage() {
        WebElement botonpaginahome= driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        if(botonpaginahome.isDisplayed()){
            System.out.println("elemento boton encontrado: tienda en linea");
        }else{
            System.out.println("No se encontro el elemento");
            driver.close();
        }

    }

    private static void seleccionarTelefonosYSmartphones() {
        WebElement logo= driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        WebElement menucel= driver.findElement(By.cssSelector("ul .dropdown-menu a[data-nombreboton='Telefonos y smartphones']"));
       if(logo.isDisplayed() && menucel.isDisplayed()){
           logo.click();
           menucel.click();
           System.out.println("Si accedio a tienda en linea sup");
       } else{
           System.out.println("Fallo al entrar a la opcion de telefonos y smartphones");
           System.exit(-1);
       }
    }

    private static void verificarModalSeleccionaTuEstado() {
        WebElement modal= driver.findElement(By.cssSelector(".chosen-single span"));
        if(modal.isEnabled()){
            System.out.println("Modal presente");
        }else{
            System.out.println("No muestra el modal");
            System.exit(-1);
        }
    }

    private static void seleccionarEstado(String estado) {
        WebElement modal= driver.findElement(By.cssSelector(".chosen-single span"));
        modal.click();
        WebElement capturaestado= driver.findElement(By.cssSelector(".chosen-search input"));
        capturaestado.sendKeys(estado);
        WebElement seleccionalista= driver.findElement(By.cssSelector(".chosen-results li"));
        seleccionalista.click();
        WebElement botonPerfil= driver.findElement(By.cssSelector("#entrarPerfilador"));
        botonPerfil.click();
    }

    private static void verificarListaTelefonos() {
        List<WebElement> listaCelulares = driver.findElements(By.cssSelector("[ng-repeat*='devices']"));
        for ( WebElement cel : listaCelulares) {
            WebElement mosaicoN = listaCelulares.get(0); // revisar !!!!
        }


    }

    private static Celular capturarInformacionTelefono(int i) {
        List<WebElement> listaCelulares = driver.findElements(By.cssSelector("[ng-repeat*='devices']"));
        WebElement mosaicoN = listaCelulares.get(i - 1);

        WebElement nombreEquipo = mosaicoN.findElement(By.cssSelector(".telcel-mosaico-equipos-nombre-equipo"));
        String nombreEquipoCel = nombreEquipo.getText();

        WebElement elemPrecioEquipo = mosaicoN.findElement(By.cssSelector(".telcel-mosaico-equipos-precio"));
        String precioEquipo = elemPrecioEquipo.getText();
        double precio = Double.parseDouble(precioEquipo.replace("$", "").replace(",", ""));
        //.telcel-mosaico-equipos-capacidad-numero
        WebElement elemCapacidad = mosaicoN.findElement(By.cssSelector(".telcel-mosaico-equipos-capacidad-numero"));
        String capacidad = elemCapacidad.getText();
        int capac = Integer.parseInt(capacidad.split(" ")[0]);
        return new Celular(nombreEquipoCel, capac, precio);

        //return null;
    }

    public static void clickTelefono(int numTelefono) {
        List<WebElement> listaCelulares = driver.findElements(By.cssSelector("[ng-repeat*='devices']"));
        WebElement mosaicoN = listaCelulares.get(numTelefono - 1);
        mosaicoN.click();
    }

    public static void verificarInformacionCelular(Celular cel) throws Exception {
        WebElement nombreEquipo = driver.findElement(By.cssSelector(".ecommerce-ficha-tecnica-opciones-compra-titulo #ecommerce-ficha-tecnica-nombre"));
        String nombreEquipoCel = nombreEquipo.getText();

        WebElement elemPrecioEquipo = driver.findElement(By.cssSelector(".ecommerce-ficha-tecnica-precio-pagos #ecommerce-ficha-tecnica-precio-obj"));
        String precioEquipo = elemPrecioEquipo.getText();
        double precio = Double.parseDouble(precioEquipo.replace("$", "").replace(",", ""));
        //.telcel-mosaico-equipos-capacidad-numero

        WebElement elemCapacidad = driver.findElement(By.cssSelector("li[ng-repeat*='capacidades'] a"));

        String capacidad = elemCapacidad.getText();
        int capac = Integer.parseInt(capacidad.split(" ")[0]);

        if(cel.getNombre().equals(nombreEquipoCel)
                && cel.getPrecio() == precio
                && cel.getCapacidad() == capac) {
            System.out.println("Los datos coinciden");
        } else {
            System.out.println("Los datos  no coinciden");
            throw new Exception("Los datos  no coinciden");
        }
    }
}
