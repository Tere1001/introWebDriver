package cHomeworks.VerificarElencoPelicula;


public class verificaElenco extends ParentTestVerificaElenco {
    public static void main (String[] args) {
        setUp();
        testMovieSearch("It", "Richard Thomas", "1990");
        tearDown();
        verificarElenco();
       // selectMovieAdd();
       //  verifyWatchList();
    }




}
