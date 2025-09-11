package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.graduaciones.Graduable;
import ar.edu.unahur.obj2.graduaciones.GraduacionRoja;
import ar.edu.unahur.obj2.personas.Nacionalidad;

public class Roja extends Marca {

    public Roja(String nombre, Nacionalidad origen, Double lupuloGrPorLitro) {
        super(nombre, origen, lupuloGrPorLitro);
    }

    public Graduable getEstrategia() {
        return GraduacionRoja.getInstance();
    }
}
