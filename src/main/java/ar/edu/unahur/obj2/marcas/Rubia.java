package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.graduaciones.Graduable;
import ar.edu.unahur.obj2.graduaciones.GraduacionRubia;
import ar.edu.unahur.obj2.personas.Nacionalidad;

public class Rubia extends Marca {
    private final double graduacionFija;

    public Rubia(String nombre, Nacionalidad origen, Double lupuloGrPorLitro, Double graduacionFija) {
        super(nombre, origen, lupuloGrPorLitro);
        this.graduacionFija = graduacionFija;
    }

    public Graduable getEstrategia() {
        return GraduacionRubia.getInstance();
    }

    public double getGraduacionFija() {
        return graduacionFija;
    }
}
