/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ws.Importadora;

/**
 *
 * @author yessenia
 */
public class ImportadoraTest {
    
    public ImportadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validar_Sesion method, of class Importadora.
     */
    @Test
    public void testValidar_Sesion() {
        System.out.println("validar_Sesion");
        Importadora instance = new Importadora();
        String result = instance.validar_Sesion("prueba", "prueba");
        assertEquals("", result);
    }

    /**
     * Test of crear_Cuenta method, of class Importadora.
     */
    @Test
    public void testCrear_Cuenta() {
        System.out.println("crear_Cuenta");
        Importadora instance = new Importadora();
        String result = instance.crear_Cuenta("prueba", "prueba", "prueba", "prueba");
        assertEquals("", result);
    }

    /**
     * Test of solicitar_Catalogo_Vehiculos method, of class Importadora.
     */
    @Test
    public void testSolicitar_Catalogo_Vehiculos() {
        System.out.println("solicitar_Catalogo_Vehiculos");
        Importadora instance = new Importadora();
        String result = instance.solicitar_Catalogo_Vehiculos();
        assertEquals("", result);
    }

    /**
     * Test of cotizar_Vehiculo method, of class Importadora.
     */
    @Test
    public void testCotizar_Vehiculo() {
        System.out.println("cotizar_Vehiculo");
        Importadora instance = new Importadora();
        String result = instance.cotizar_Vehiculo("prueba", "prueba");
        assertEquals("", result);
    }

    /**
     * Test of comprar_Vehículo method, of class Importadora.
     */
    @Test
    public void testComprar_Vehiculo() {
        System.out.println("comprar_Vehiculo");
        Importadora instance = new Importadora();
        String result = instance.comprar_Vehiculo(123,"prueba",123,123.0,123.0,123.0,123.0,123.0,123.0,"prueba","prueba");
        assertEquals("", result);
    }
    
}
