package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorAcademias {
    private static List<Academia> listaAcademias = new ArrayList<>();

    public static void cadastrarAcademia(Academia academia) {
        listaAcademias.add(academia);
    }

    public static List<Academia> getListaAcademias() {
        return listaAcademias;
    }
}
