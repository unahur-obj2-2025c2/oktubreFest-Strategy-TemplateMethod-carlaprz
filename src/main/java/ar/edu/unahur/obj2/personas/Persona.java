package ar.edu.unahur.obj2.personas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;

public class Persona {

    private Double peso;
    private List<Jarra> jarrasCompradas = new ArrayList<>();
    private Boolean gustaMusicaTradicional;
    private Double aguante;
    private Nacionalidad nacionalidad;

    public Persona(double peso, boolean gustaMusicaTradicional, double aguante, Nacionalidad nacionalidad) {
        this.peso = peso;
        this.gustaMusicaTradicional = gustaMusicaTradicional;
        this.aguante = aguante;
        this.nacionalidad = nacionalidad;
    }

    public void comprarJarra(Jarra jarra) {
        jarrasCompradas.add(jarra);
    }

    public double getTotalAlcoholIngerido() {
        return jarrasCompradas.stream()
                .mapToDouble(j -> j.getGraduacionAlcoholica())
                .sum();
    }

    public boolean estaEbria() {
        return getTotalAlcoholIngerido() * peso > aguante;
    }

    public boolean leGustaMarca(Marca marca) {
        switch (nacionalidad) {
            case Nacionalidad.BELGA:
                return marca.getLupulo() > 4;
            case Nacionalidad.CHECO:
                return marca.getGraduacionAlcoholica() > 0.08; // 8%
            case Nacionalidad.ALEMAN:
                return true;
            default:
                return false;
        }
    }

    public boolean isGustaMusicaTradicional() {
        return gustaMusicaTradicional;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public List<Jarra> getJarrasCompradas() {
        return this.jarrasCompradas;
    }
}
