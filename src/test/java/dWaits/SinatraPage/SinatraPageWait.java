package dWaits.SinatraPage;

import cHomeworks.SinatraPagina.Datos;

public class SinatraPageWait extends SinatraPadreWait {

    public static void main(String[] args){
        navegarPagina();
        verificarPaginaHome();
        clickLogin();
        verificarPaginaLogin();
        ingresarCredenciales(Datos.USUARIO, Datos.PASSWORD);
        verificarPaginaSongs();
        verificarMensajeBienvenida();

    }

}
