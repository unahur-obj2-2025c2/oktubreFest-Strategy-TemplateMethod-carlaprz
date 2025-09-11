package ar.edu.unahur.obj2.graduaciones;

import ar.edu.unahur.obj2.marcas.Marca;

public class GraduacionRoja implements Graduable {

    private static GraduacionRoja instance = new GraduacionRoja();

    private GraduacionRoja() {
    }

    public static GraduacionRoja getInstance() {
        return instance;
    }

    @Override
    public double calcularGraduacion(Marca marca) {
        return GraduacionNegra.getGraduacionReglamentaria() * 1.25;
    }
}
