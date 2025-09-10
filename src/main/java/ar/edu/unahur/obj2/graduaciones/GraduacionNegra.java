package ar.edu.unahur.obj2.graduaciones;

import ar.edu.unahur.obj2.marcas.Marca;

public class GraduacionNegra implements Graduable {
    private double graduacionReglamentaria;
    private static GraduacionNegra instance = new GraduacionNegra();

    private GraduacionNegra() {
    }

    public static GraduacionNegra getInstance() {
        return instance;
    }

    @Override
    public double calcularGraduacion(Marca marca) {
        double porLupulo = 2.0 * marca.getLupulo() / 100.0;
        return Math.min(graduacionReglamentaria, porLupulo);
    }

    public void setGraduacionReglamentaria(double nueva) {
        this.graduacionReglamentaria = nueva;
    }

}
