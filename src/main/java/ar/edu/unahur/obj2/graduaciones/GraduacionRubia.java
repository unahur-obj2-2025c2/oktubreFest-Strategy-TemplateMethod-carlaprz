package ar.edu.unahur.obj2.graduaciones;

import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.Rubia;

public class GraduacionRubia implements Graduable {
    private static GraduacionRubia instance = new GraduacionRubia();

    private GraduacionRubia() {
    }

    public static GraduacionRubia getInstance() {
        return instance;
    }

    @Override
    public double calcularGraduacion(Marca marca) {
        return ((Rubia) marca).getGraduacionFija();
    }
}
