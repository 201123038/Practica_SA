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
public class AduanaTest {
    
    public AduanaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calcular_Costo_Aduana method, of class Aduana.
     */
    @Test
    public void testCalcular_Costo_Aduana() {
        System.out.println("calcular_Costo_Aduana");
        Aduana instance = new Aduana();
        String result = instance.calcular_Costo_Aduana("", 123);
        assertEquals("", result);
    }

    /**
     * Test of guardar_Id_Transferencia method, of class Aduana.
     */
    @Test
    public void testGuardar_Id_Transferencia() {
        System.out.println("guardar_Id_Transferencia");
        Aduana instance = new Aduana();
        boolean result = instance.guardar_Id_Transferencia(123, 123);
        assertEquals(false, result);
    }
    
}
