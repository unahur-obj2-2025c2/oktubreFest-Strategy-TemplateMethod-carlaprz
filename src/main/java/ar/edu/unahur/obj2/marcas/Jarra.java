package ar.edu.unahur.obj2.marcas;

public class Jarra {
    private Marca marca;
    private Double capacidad;

    public Jarra(Marca marca, Double capacidad) {
        this.marca = marca;
        this.capacidad = capacidad;
    }

    public Marca getMarca() {
        return marca;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public Double getGraduacionAlcoholica() {
        return this.marca.getGraduacionAlcoholica() * capacidad;
    }

}
