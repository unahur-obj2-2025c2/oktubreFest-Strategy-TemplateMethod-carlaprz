package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.graduaciones.Graduable;
import ar.edu.unahur.obj2.graduaciones.GraduacionNegra;
import ar.edu.unahur.obj2.personas.Nacionalidad;

public class Negra extends Marca {

    public Negra(String nombre, Nacionalidad origen, Double lupulo) {
        super(nombre, origen, lupulo);
    }

    public Graduable getEstrategia() {
        return GraduacionNegra.getInstance();
    }
}
