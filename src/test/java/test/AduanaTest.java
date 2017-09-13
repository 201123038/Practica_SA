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
import ws.Aduana;

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
        String linea = "";
        Integer modelo = null;
        Aduana instance = new Aduana();
        String expResult = "";
        String result = instance.calcular_Costo_Aduana(linea, modelo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar_Id_Transferencia method, of class Aduana.
     */
    @Test
    public void testGuardar_Id_Transferencia() {
        System.out.println("guardar_Id_Transferencia");
        Integer id_Transferencia = null;
        Integer monto_Compra = null;
        Aduana instance = new Aduana();
        boolean expResult = false;
        boolean result = instance.guardar_Id_Transferencia(id_Transferencia, monto_Compra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
