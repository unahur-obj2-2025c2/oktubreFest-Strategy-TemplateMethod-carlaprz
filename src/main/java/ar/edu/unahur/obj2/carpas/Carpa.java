package ar.edu.unahur.obj2.carpas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import ar.edu.unahur.obj2.marcas.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.personas.Persona;

public class Carpa {
    private final Integer limiteAdmicion;
    private final Boolean bandaTrdicional;
    private final Marca marca;
    private HashSet<Persona> personas = new HashSet<>();

    public Carpa(Integer limiteAdmicion, Boolean bandaTrdicional, Marca marca) {
        this.limiteAdmicion = limiteAdmicion;
        this.bandaTrdicional = bandaTrdicional;
        this.marca = marca;
    }

    public Integer getLimiteAdmicion() {
        return limiteAdmicion;
    }

    public Boolean getBandaTrdicional() {
        return bandaTrdicional;
    }

    public Marca getMarca() {
        return marca;
    }

    public void venderJarraDeCerveza(Persona persona, double cantidad) {
        if (!personas.contains(persona)) {
            throw new RuntimeException(
                    "La Persona: " + persona.getNombre() + " no puede comprar por que no esta dentro de la carpa.");
        }

        Jarra jarraAvender = new Jarra(marca, cantidad);
        persona.comprarJarra(jarraAvender);
    }

    public Boolean esParLaCantidadDePersonas() {
        return personas.size() % 2 == 0;
    }

    public Boolean puedeEntrar(Persona unaPersona) {
        return personas.size() + 1 <= this.limiteAdmicion && !unaPersona.estaEbria();
    }

    public Integer cantidadDeGente() {
        return personas.size();
    }

    public void entrar(Persona unaPersona) {
        if (puedeEntrar(unaPersona) && unaPersona.leGustaLaCarpa(this)) {
            personas.add(unaPersona);
        } else {
            throw new RuntimeException(
                    "La Persona: " + unaPersona.getNombre() + " no puede ingresar a la carpa.");
        }
    }

    private List<Persona> ebriosEmpedernidos() {
        return personas.stream().filter(p -> p.esEbrioEmpedernido()).toList();
    }

    public Integer cantidadDeEbriosEmpedernidos() {
        return ebriosEmpedernidos().size();
    }

}
