package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.graduaciones.Graduable;
import ar.edu.unahur.obj2.graduaciones.GraduacionNegra;

public class Negra extends Marca {

    protected Negra(String nombre, String origen, Double lupulo) {
        super(nombre, origen, lupulo);
    }

    public Graduable getEstrategia() {
        return GraduacionNegra.getInstance();
    }
}
