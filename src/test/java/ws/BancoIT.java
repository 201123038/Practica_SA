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
public class BancoIT {
    
    public BancoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of transferencia_cuenta method, of class Banco.
     */
    @Test
    public void testTransferencia_cuenta() {
        System.out.println("transferencia_cuenta");
        Banco instance = new Banco();
        boolean result = instance.transferencia_cuenta(123, 123, 123);
        assertEquals(false, result);
    }
    
}
