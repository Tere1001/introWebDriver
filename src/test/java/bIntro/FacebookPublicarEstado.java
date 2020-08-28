package bIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacebookPublicarEstado{
    static WebDriver driver;

    public static void main(String[] args) {
        navegarFacebook();
        verificarHomePage();
        iniciarSesion(Constants.USUARIO, Constants.PASSWORD);
        verificarPaginaPrincipal();
        publicarEstado();
        verificarEstado();
    }


    private static void navegarFacebook() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
    }

    private static void verificarHomePage() {
        //logoFacebook css ".fb_logo"
        WebElement logoFacebook = driver.findElement(By.cssSelector(".fb_logo"));
        //campoUsuario css "#email"
        WebElement campoUsuario = driver.findElement(By.cssSelector("#email"));
        //campoContrasena css "#pass"
        WebElement campoContrasena = driver.findElement(By.cssSelector("#pass"));
        //botonIniciarSesion  css "[value='Iniciar sesión']"
        WebElement botonIniciarSesion = driver.findElement(By.cssSelector("[data-testid='royal_login_button']"));

        if(logoFacebook.isDisplayed()
                && campoUsuario.isDisplayed()
                && campoContrasena.isDisplayed()
                && botonIniciarSesion.isDisplayed()) {
            System.out.println("La pagina de Home cargo correctamente");
        }
        else {
            System.out.println("La pagina de Home no cargo correctamente");
            System.exit(-1);
        }
    }

    private static void iniciarSesion(String usuario, String password) {
        //campoUsuario css "#email"
        WebElement campoUsuario = driver.findElement(By.cssSelector("#email"));
        campoUsuario.sendKeys(usuario);
        //campoContrasena css "#pass"
        WebElement campoContrasena = driver.findElement(By.cssSelector("#pass"));
        campoContrasena.sendKeys(password);
        //botonIniciarSesion  css "[value='Iniciar sesión']"
        WebElement botonIniciarSesion = driver.findElement(By.cssSelector("[data-testid='royal_login_button']"));
        botonIniciarSesion.click();
    }

    private static void verificarPaginaPrincipal() {
        //iconoBusqueda css "[placeholder*='Facebook']"
         WebElement iconoBusqueda= driver.findElement(By.cssSelector("[placeholder*='Facebook']"));
        //quePasa css "h3 + a + div"
        WebElement quePasa =driver.findElement(By.cssSelector("h3 + a + div"));
    }


    private static void publicarEstado() {
        //campoQuePasa css "form[method='POST'] .q5bimw55"
        WebElement campoQuePasa = driver.findElement(By.cssSelector("div .oajrlxb2.b3i9ofy5.qu0x051f.esr5mh6w.e9989ue4.r7d6kgcz.rq0escxv.nhd2j8a9.j83agx80.p7hjln8o.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.cxgpxx05.d1544ag0.sj5x9vvc.tw6a2znq.i1ao9s8h.esuyzwwr.f1sip0of.lzcic4wl.l9j0dhe7.abiwlrkh.p8dawk7l.bp9cbjyn.orhb3f3m.czkt41v7.fmqxjp7s.emzo65vh.btwxx1t3.buofh1pr.idiwt2bm.jifvfom9.ni8dbmo4.stjgntxs.kbf60n1y"));
        //Validar edicion en campo
        campoQuePasa.click();
       // WebElement campoAgregarText = driver.findElement(By.cssSelector("form[method='POST'] .q5bimw55"));
        WebElement campoAgregarText = driver.findElement(By.cssSelector("div .notranslate._5rpu div[data-contents=\"true\"] div[data-offset-key=\"86vse-0-0\"]"));
        // campo editable div[data-editor="ekfpm"]
        campoAgregarText.sendKeys("Publicacion de estado, que hay!");
        //botonPublicar css "form[method='POST'] .oajrlxb2"
        List<WebElement> elementitos = driver.findElements(By.cssSelector("form[method='POST'] .oajrlxb2"));
        int numeroElementitos = elementitos.size();
        WebElement publicar = elementitos.get(numeroElementitos - 1);
        publicar.click();

    }

    private static void verificarEstado() {
     WebElement estadoVerificar = driver.findElement(By.cssSelector("div[class=\"kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql\"]"));

     if(estadoVerificar.getText().contains("Publicacion de estado, que hay!")){
         System.out.println("Se realizo la publicacion correctamente");
     }else{
         System.out.println("Algo salio mal en la publicacion");
         driver.close();
     }


    }

}
