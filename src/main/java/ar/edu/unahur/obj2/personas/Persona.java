package ar.edu.unahur.obj2.personas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.TreeUI;
import javax.swing.text.StyledEditorKit.BoldAction;

import ar.edu.unahur.obj2.carpas.Carpa;
import ar.edu.unahur.obj2.marcas.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;

public class Persona {

    private final String nombre;
    private Double peso;
    private List<Jarra> jarrasCompradas = new ArrayList<>();
    private Boolean musicaTradicional;
    private Double aguante;
    private Nacionalidad nacionalidad;

    public Persona(String nombre, Double peso, Boolean musicaTradicional, Double aguante,
            Nacionalidad nacionalidad) {
        this.nombre = nombre;
        this.peso = peso;
        this.musicaTradicional = musicaTradicional;
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

    public boolean musicaTradicional() {
        return musicaTradicional;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public List<Jarra> getJarrasCompradas() {
        return this.jarrasCompradas;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean leGustaLaCarpa(Carpa unaCarpa) {

        return this.preferenciaDeMarca(unaCarpa) && this.preferenciaDeMusica(unaCarpa)
                && this.preferenciaAleman(unaCarpa);

    }

    private Boolean preferenciaDeMarca(Carpa unaCarpa) {
        return this.leGustaMarca(unaCarpa.getMarca());
    }

    private Boolean preferenciaDeMusica(Carpa unaCarpa) {
        return unaCarpa.getBandaTrdicional() == this.musicaTradicional();
    }

    private Boolean preferenciaAleman(Carpa unaCarpa) {
        return this.nacionalidad != Nacionalidad.ALEMAN
                || (this.nacionalidad == Nacionalidad.ALEMAN && unaCarpa.esParLaCantidadDePersonas());
    }

    public Integer cantidadDeJarrasCompradas() {
        return jarrasCompradas.size();
    }

    public Boolean esEbrioEmpedernido() {
        return jarrasCompradas.stream().allMatch(j -> j.getCapacidad() > 1.0) && !jarrasCompradas.isEmpty();
    }

    public Boolean esPatriota() {
        return jarrasCompradas.stream().allMatch(j -> j.getMarca().getOrigen() == this.getNacionalidad());
    }
}
