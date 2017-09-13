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
    public void testCalcular_Impuesto() {
        System.out.println("calcular_Impuesto");
        String linea = "";
        Integer modelo = null;
        Sat instance = new Sat();
        double expResult = 0.0;
        double result = instance.calcular_Impuesto(linea, modelo);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registro_Id_Compra method, of class Sat.
     */
    @Test
    public void testRegistro_Id_Compra() {
        System.out.println("registro_Id_Compra");
        Integer id_Transferencia = null;
        double monto_Compra = 0.0;
        Sat instance = new Sat();
        boolean expResult = false;
        boolean result = instance.registro_Id_Compra(id_Transferencia, monto_Compra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar_Manifiesto method, of class Sat.
     */
    @Test
    public void testGuardar_Manifiesto() {
        System.out.println("guardar_Manifiesto");
        String nombre_Cliente = "";
        Sat instance = new Sat();
        Integer expResult = null;
        Integer result = instance.guardar_Manifiesto(nombre_Cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar_Declaracion method, of class Sat.
     */
    @Test
    public void testGuardar_Declaracion() {
        System.out.println("guardar_Declaracion");
        String entrada = "";
        Sat instance = new Sat();
        Integer expResult = null;
        Integer result = instance.guardar_Declaracion(entrada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Generar_manifiesto method, of class Sat.
     */
    @Test
    public void testGenerar_manifiesto() {
        System.out.println("Generar_manifiesto");
        Integer codigo_Agende = null;
        Integer factura = null;
        Integer doc_Transporte = null;
        Integer titulo_Propiedad = null;
        Integer tarjeta_Circulacion = null;
        double declaracion_Aduanera = 0.0;
        Sat instance = new Sat();
        Integer expResult = null;
        Integer result = instance.Generar_manifiesto(codigo_Agende, factura, doc_Transporte, titulo_Propiedad, tarjeta_Circulacion, declaracion_Aduanera);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcular_Impuesto2 method, of class Sat.
     */
    @Test
    public void testCalcular_Impuesto2() {
        System.out.println("calcular_Impuesto2");
        String tipo = "";
        String marca = "";
        String linea = "";
        Integer centimetros = null;
        Integer cilindraje = null;
        Integer puertas = null;
        Integer asientos = null;
        Integer modelo = null;
        Sat instance = new Sat();
        String expResult = "";
        String result = instance.calcular_Impuesto2(tipo, marca, linea, centimetros, cilindraje, puertas, asientos, modelo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
