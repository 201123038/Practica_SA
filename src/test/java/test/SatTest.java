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
import ws.Sat;

/**
 *
 * @author yessenia
 */
public class SatTest {
    
    public SatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of calcular_Impuesto method, of class Sat.
     */
    @Test
    public void testCalcular_Impuesto_Sat() {
        System.out.println("calcular_Impuesto");
        Sat instance = new Sat();
        String result = instance.calcular_Impuesto("prueba","prueba",123);
        assertEquals("prueba", result);
    }

    /**
     * Test of registro_Id_Compra method, of class Sat.
     */
    @Test
    public void testRegistro_Id_Compra() {
        System.out.println("registro_Id_Compra");
        Sat instance = new Sat();
        String result = instance.registro_Id_Compra(123, 123.0);
        assertEquals("prueba", result);
    }

    /**
     * Test of guardar_Manifiesto method, of class Sat.
     */
    @Test
    public void testGuardar_Manifiesto() {
        System.out.println("guardar_Manifiesto");
        Sat instance = new Sat();
        String result = instance.guardar_Manifiesto("prueba","prueba","prueba","prueba","prueba");
        assertEquals("prueba", result);
    }

    /**
     * Test of guardar_Declaracion method, of class Sat.
     */
    @Test
    public void testGuardar_Declaracion() {
        System.out.println("guardar_Declaracion");
        Sat instance = new Sat();
        String result = instance.guardar_Declaracion("prueba","prueba","prueba","prueba","prueba");
        assertEquals("prueba", result);
    }

    /**
     * Test of Generar_manifiesto method, of class Sat.
     */
    /*
    @Test
    public void testGenerar_manifiesto() {
        System.out.println("Generar_manifiesto");
        Sat instance = new Sat();
        String result = instance.Generar_manifiesto(123, 123, 123, 123, 123, 123);
        assertEquals("", result);
            }

    /**
     * Test of calcular_Impuesto2 method, of class Sat.
     
    @Test
    public void testCalcular_Impuesto2() {
        System.out.println("calcular_Impuesto2");
        Sat instance = new Sat();
        String result = instance.calcular_Impuesto2("prueba", "prueba", "prueba", 123, 123, 123, 123, 123);
        assertEquals("", result);
    }
    */
}
