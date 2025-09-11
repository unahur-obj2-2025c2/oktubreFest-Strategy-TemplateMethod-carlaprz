package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.graduaciones.Graduable;
import ar.edu.unahur.obj2.personas.Nacionalidad;

public abstract class Marca {
    private String nombre;
    private Double lupulo;
    private Nacionalidad origen;

    protected Marca(String nombre, Nacionalidad origen, Double lupulo) {
        this.nombre = nombre;
        this.origen = origen;
        this.lupulo = lupulo;
    }

    public double getGraduacionAlcoholica() {
        return getEstrategia().calcularGraduacion(this);
    }

    public double getLupulo() {
        return lupulo;
    }

    public Nacionalidad getOrigen() {
        return origen;
    }

    public String getNombre() {
        return nombre;
    }

    abstract Graduable getEstrategia();
}
