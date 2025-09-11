package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.graduaciones.GraduacionNegra;
import ar.edu.unahur.obj2.marcas.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.marcas.Negra;
import ar.edu.unahur.obj2.marcas.Roja;
import ar.edu.unahur.obj2.marcas.Rubia;
import ar.edu.unahur.obj2.personas.Nacionalidad;
import ar.edu.unahur.obj2.personas.Persona;

public class PrimeraParteTest {
    Marca hofBrau = new Roja("Hofbräu", Nacionalidad.ALEMAN, 6.0);
    Jarra jarraCervezaRoja = new Jarra(hofBrau, 0.5);

    Marca guiness = new Negra("Guiness", Nacionalidad.BELGA, 5.0);
    Jarra jarraCervezaNegra = new Jarra(guiness, 1.5);

    Marca corona = new Rubia("Corona", Nacionalidad.CHECO, 3.0, 3.0);
    Jarra jarraCervezaRubia = new Jarra(corona, 1.0);

    Persona dante = new Persona(65, Boolean.FALSE, 5.60, Nacionalidad.ALEMAN);
    Persona thomas = new Persona(65, Boolean.FALSE, 6.35, Nacionalidad.BELGA);
    Persona joaquin = new Persona(65, Boolean.FALSE, 8.00, Nacionalidad.CHECO);
    Persona celeste = new Persona(65, Boolean.FALSE, 9.99, Nacionalidad.ALEMAN);

    @BeforeEach
    void initialize() {
        GraduacionNegra.setGraduacionReglamentaria(0.064);
    }

    @Test
    void elContenidoDeAlcoholDeUnaJarra() {
        assertEquals(0.08, hofBrau.getGraduacionAlcoholica());
        assertEquals(0.04, jarraCervezaRoja.getGraduacionAlcoholica());
    }

    @Test
    void elTotalDeAlcohoDeUnaPersona() {
        // when
        dante.comprarJarra(jarraCervezaNegra);
        assertEquals(jarraCervezaNegra.getGraduacionAlcoholica(), dante.getTotalAlcoholIngerido());
        dante.comprarJarra(jarraCervezaRubia);

        // then
        Double totalDeAlcohol = jarraCervezaNegra.getGraduacionAlcoholica()
                + jarraCervezaRubia.getGraduacionAlcoholica();
        assertEquals(totalDeAlcohol, dante.getTotalAlcoholIngerido());
    }

    @Test
    void dadaUnaPersonaEbria_comprobarQueEsteEbria() {
        // when
        assertFalse(dante.estaEbria());
        dante.comprarJarra(jarraCervezaNegra);
        dante.comprarJarra(jarraCervezaRubia);

        // then
        assertTrue(dante.estaEbria());
    }

    @Test
    void dadaUnaPersonaAlemana_comprobarQueleGustenLasCerveza() {
        // when
        assertEquals(Nacionalidad.ALEMAN, celeste.getNacionalidad());

        // then
        assertTrue(celeste.leGustaMarca(guiness));
        assertTrue(celeste.leGustaMarca(corona));
        assertTrue(celeste.leGustaMarca(hofBrau));
    }

    @Test
    void dadaUnaPersonaBelga_comprobarQueleGustenLasCervezaQueTienenMasde4GramosDeLupulo() {
        // when
        assertEquals(Nacionalidad.BELGA, thomas.getNacionalidad());

        // then
        assertFalse(corona.getLupulo() > 4);
        assertFalse(thomas.leGustaMarca(corona));

        assertTrue(guiness.getLupulo() > 4);
        assertTrue(thomas.leGustaMarca(guiness));

        assertTrue(hofBrau.getLupulo() > 4);
        assertTrue(thomas.leGustaMarca(hofBrau));
    }

    @Test
    void dadaUnaPersonaCheca_comprobarQueleGustenLasCervezaQueTienenMasde8PorcientoDeAlcohol() {
        // when
        assertEquals(Nacionalidad.CHECO, joaquin.getNacionalidad());

        // then
        assertFalse(corona.getGraduacionAlcoholica() < 0.8);
        assertFalse(thomas.leGustaMarca(corona));

        assertTrue(guiness.getGraduacionAlcoholica() < 0.8);
        assertTrue(thomas.leGustaMarca(guiness));

        assertTrue(hofBrau.getGraduacionAlcoholica() < 0.8);
        assertTrue(thomas.leGustaMarca(hofBrau));
    }

}
