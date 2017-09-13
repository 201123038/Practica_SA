/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yessenia
 */
public class EnvioIT {
    
    public EnvioIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of cargar_Vehiculos method, of class Envio.
     */
    @Test
    public void testCargar_Vehiculos() {
        System.out.println("cargar_Vehiculos");
        Envio instance = new Envio();
        String result = instance.cargar_Vehiculos(123);
        assertEquals("", result);
    }

    /**
     * Test of calcular_costo_viaje method, of class Envio.
     */
    @Test
    public void testCalcular_costo_viaje() {
        System.out.println("calcular_costo_viaje");
        Envio instance = new Envio();
        double result = instance.calcular_costo_viaje(123, 123);
        assertEquals(0, result, 0.0);
    }

    /**
     * Test of guardar_Transferencia method, of class Envio.
     */
    @Test
    public void testGuardar_Transferencia() {
        System.out.println("guardar_Transferencia");
        Envio instance = new Envio();
        boolean result = instance.guardar_Transferencia(123,123);
        assertEquals(false, result);
    }
    
}
