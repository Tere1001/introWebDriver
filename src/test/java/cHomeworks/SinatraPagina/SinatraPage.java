package cHomeworks.SinatraPagina;


public class SinatraPage extends SinatraPadre {

    public static void main(String[] args){
        navegarPagina(Datos.URL);
        verificarPaginaHome();
        clickLogin();
        verificarPaginaLogin(Datos.CAMUSUARIO, Datos.CAMPASSWORD, Datos.BUTTON);
        ingresarCredenciales(Datos.USUARIO, Datos.PASSWORD);
        verificarPaginaSongs();
        verificarMensajeBienvenida();

    }

}
