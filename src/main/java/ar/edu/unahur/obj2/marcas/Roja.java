package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.graduaciones.Graduable;
import ar.edu.unahur.obj2.graduaciones.GraduacionRoja;

public class Roja extends Marca {

    protected Roja(String nombre, String origen, Double lupuloGrPorLitro) {
        super(nombre, origen, lupuloGrPorLitro);
    }

    public Graduable getEstrategia() {
        return GraduacionRoja.getInstance();
    }
}
