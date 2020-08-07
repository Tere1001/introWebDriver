package bIntro;

import org.openqa.selenium.WebDriver;

public class SeleccionarCelular {
    static WebDriver driver;

    private static void main(String[] args) {
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


    }

    private static void verificarHomePage() {
    }

    private static void seleccionarTelefonosYSmartphones() {
    }

    private static void verificarModalSeleccionaTuEstado() {
    }

    private static void seleccionarEstado(String estado) {
    }

    private static void verificarListaTelefonos() {
    }

    private static Celular capturarInformacionTelefono(int i) {
        return null;
    }

    public static void clickTelefono(int numTelefono) {

    }

    public static void verificarInformacionCelular(Celular cel) {

    }
}
