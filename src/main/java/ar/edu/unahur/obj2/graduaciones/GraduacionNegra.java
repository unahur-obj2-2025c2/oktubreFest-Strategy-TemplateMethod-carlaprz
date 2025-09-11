package ar.edu.unahur.obj2.graduaciones;

import ar.edu.unahur.obj2.marcas.Marca;

public class GraduacionNegra implements Graduable {
    private static double graduacionReglamentaria;
    private static GraduacionNegra instance = new GraduacionNegra();

    private GraduacionNegra() {
    }

    public static GraduacionNegra getInstance() {
        return instance;
    }

    @Override
    public double calcularGraduacion(Marca marca) {
        return Math.min(graduacionReglamentaria, 2 * marca.getLupulo());
    }

    public static void setGraduacionReglamentaria(double nueva) {
        graduacionReglamentaria = nueva;
    }

    public static double getGraduacionReglamentaria() {
        return graduacionReglamentaria;    }

}
