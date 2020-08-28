package dWaits.SeleccionarCelularTelcel;

public class SeleccionarCelularWait extends PaginaBaseWait {


    public static void main(String[] args) throws Exception {
        navegarPagina("https://www.telcel.com/");
        verificarHomePage();
        seleccionarTelefonosYSmartphones();
        verificarModalSeleccionaTuEstado();
        seleccionarEstado("Jalisco");
        verificarListaTelefonos();
        CelularWait cel = capturarInformacionTelefono(15);
        clickTelefono(15);
        verificarInformacionCelular(cel);
        cerrarBrowser();
    }


}
