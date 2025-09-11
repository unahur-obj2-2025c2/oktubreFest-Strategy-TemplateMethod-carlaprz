package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.carpas.Carpa;
import ar.edu.unahur.obj2.graduaciones.GraduacionNegra;
import ar.edu.unahur.obj2.marcas.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.Negra;
import ar.edu.unahur.obj2.marcas.Roja;
import ar.edu.unahur.obj2.marcas.Rubia;
import ar.edu.unahur.obj2.personas.Nacionalidad;
import ar.edu.unahur.obj2.personas.Persona;

public class SegundaParteTest {
    Marca hofBrau = new Roja("Hofbräu", Nacionalidad.ALEMAN, 6.0);
    Jarra jarraCervezaRoja = new Jarra(hofBrau, 0.5);

    Marca guiness = new Negra("Guiness", Nacionalidad.BELGA, 5.0);
    Jarra jarraCervezaNegra = new Jarra(guiness, 1.5);

    Marca corona = new Rubia("Corona", Nacionalidad.CHECO, 3.0, 3.0);
    Jarra jarraCervezaRubia = new Jarra(corona, 1.0);

    Persona dante = new Persona("Dante", 65.00, Boolean.TRUE, 5.60, Nacionalidad.ALEMAN);
    Persona thomas = new Persona("Thomas", 105.50, Boolean.FALSE, 6.35, Nacionalidad.BELGA);
    Persona joaquin = new Persona("Joaquin", 93.25, Boolean.FALSE, 8.00, Nacionalidad.CHECO);
    Persona celeste = new Persona("Celeste", 63.75, Boolean.FALSE, 9.99, Nacionalidad.ALEMAN);
    Persona pedro = new Persona("Pedro", 93.25, Boolean.FALSE, 8.00, Nacionalidad.CHECO);

    Carpa carpaRubia = new Carpa(1, Boolean.FALSE, corona);
    Carpa carpaNegra = new Carpa(15, Boolean.TRUE, guiness);
    Carpa carpaRoja = new Carpa(20, Boolean.TRUE, hofBrau);

    @BeforeEach
    void initialize() {
        GraduacionNegra.setGraduacionReglamentaria(0.064);
    }

    @Test
    void saberSiAPersonaQuiereEntrarAUnaCarpaOk() {
        // when
        assertTrue(carpaNegra.esParLaCantidadDePersonas());
        assertEquals(dante.musicaTradicional(), carpaNegra.getBandaTrdicional());
        // then
        assertTrue(dante.leGustaLaCarpa(carpaNegra));
    }

    @Test
    void saberSiAPersonaNoQuiereEntrarAUnaCarpaNoOk() {
        // when
        assertTrue(carpaRubia.esParLaCantidadDePersonas());
        assertFalse(carpaRubia.getBandaTrdicional());
        // then
        assertFalse(dante.leGustaLaCarpa(carpaRubia));
    }

    @Test
    void saberSiUnaCarpaDejaIngresarOk() {
        // when
        assertTrue(carpaNegra.esParLaCantidadDePersonas());
        assertEquals(dante.musicaTradicional(), carpaNegra.getBandaTrdicional());

        // then
        assertTrue(carpaNegra.puedeEntrar(dante));
    }

    @Test
    void saberSiUnaCarpaNoDejaIngresarPorQueEstaEbria() {
        // when
        assertTrue(carpaNegra.esParLaCantidadDePersonas());
        assertEquals(dante.musicaTradicional(), carpaNegra.getBandaTrdicional());
        dante.comprarJarra(jarraCervezaNegra);
        dante.comprarJarra(jarraCervezaRubia);

        // then
        assertFalse(carpaNegra.puedeEntrar(dante));
    }

    @Test
    void saberSiUnaCarpaNoDejaIngresarPorQueNoTieneMasCapacidad() {
        // when
        assertEquals(1, carpaRubia.getLimiteAdmicion());
        carpaRubia.entrar(joaquin);
        assertEquals(1, carpaRubia.cantidadDeGente());

        // then
        assertFalse(carpaRubia.puedeEntrar(celeste));
    }

    @Test
    void saberSiUnaPersonaQuiereEntrarAUnaCarpaySilaCarpaLoDejaIngresar() {
        // when
        assertTrue(carpaNegra.esParLaCantidadDePersonas());
        assertEquals(dante.musicaTradicional(), carpaNegra.getBandaTrdicional());
        assertEquals(0, carpaNegra.cantidadDeGente());

        // then
        assertTrue(dante.leGustaLaCarpa(carpaNegra));
        assertTrue(carpaNegra.puedeEntrar(dante));
    }

    @Test
    void UnaPersonaQuiereEntrarAUnaCarpaPeroLaCarpaEstaLLena() {
        // when
        assertEquals(1, carpaRubia.getLimiteAdmicion());
        carpaRubia.entrar(joaquin);
        assertEquals(1, carpaRubia.cantidadDeGente());
        assertTrue(pedro.leGustaLaCarpa(carpaRubia));
        assertFalse(carpaRubia.puedeEntrar(pedro));

        // then
        assertThrows(RuntimeException.class, () -> carpaRubia.entrar(pedro),
                "La Persona: " + pedro.getNombre() + " no puede ingresar a la carpa.");
    }

    @Test
    void unaCarpaVendeUnaJarraDeCerveza() {
        // when
        assertEquals(1, carpaRubia.getLimiteAdmicion());
        carpaRubia.entrar(joaquin);
        assertEquals(1, carpaRubia.cantidadDeGente());
        assertEquals(0, joaquin.cantidadDeJarrasCompradas());

        // then

        carpaRubia.venderJarraDeCerveza(joaquin, 1.5);
        assertEquals(1, joaquin.cantidadDeJarrasCompradas());
    }

    @Test
    void unaPersonaQueNoEstaEnCarpaquiereComprarUnaJarraDeCerveza() {
        // when
        assertEquals(0, carpaRubia.cantidadDeGente());

        // then
        assertThrows(RuntimeException.class, () -> carpaRubia.venderJarraDeCerveza(joaquin, 1.5),
                "La Persona: " + joaquin.getNombre() + " no puede comprar por que no esta dentro de la carpa.");
    }

}
