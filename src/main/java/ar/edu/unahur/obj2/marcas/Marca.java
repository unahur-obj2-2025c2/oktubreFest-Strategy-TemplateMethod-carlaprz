package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.graduaciones.Graduable;

public abstract class Marca {
    private String nombre;
    private Double lupulo;
    private String origen;

    protected Marca(String nombre, String origen, Double lupulo) {
        this.nombre = nombre;
        this.origen = origen;
        this.lupulo = lupulo;
    }

    public double abv() {
        return getEstrategia().calcularGraduacion(this);
    }

    public double getLupulo() {
        return lupulo;
    }

    public String getPais() {
        return origen;
    }

    public String getNombre() {
        return nombre;
    }

    abstract Graduable getEstrategia();

}
