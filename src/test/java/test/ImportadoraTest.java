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
        String username = "";
        String password = "";
        Importadora instance = new Importadora();
        Boolean expResult = null;
        Boolean result = instance.validar_Sesion(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear_Cuenta method, of class Importadora.
     */
    @Test
    public void testCrear_Cuenta() {
        System.out.println("crear_Cuenta");
        String nombre = "";
        String username = "";
        String password = "";
        String no_Tarjeta = "";
        Importadora instance = new Importadora();
        Boolean expResult = null;
        Boolean result = instance.crear_Cuenta(nombre, username, password, no_Tarjeta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitar_Catalogo_Vehiculos method, of class Importadora.
     */
    @Test
    public void testSolicitar_Catalogo_Vehiculos() {
        System.out.println("solicitar_Catalogo_Vehiculos");
        Importadora instance = new Importadora();
        String expResult = "";
        String result = instance.solicitar_Catalogo_Vehiculos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cotizar_Vehiculo method, of class Importadora.
     */
    @Test
    public void testCotizar_Vehiculo() {
        System.out.println("cotizar_Vehiculo");
        String linea = "";
        String modelo = "";
        Importadora instance = new Importadora();
        String expResult = "";
        String result = instance.cotizar_Vehiculo(linea, modelo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprar_Vehiculo method, of class Importadora.
     */
    @Test
    public void testComprar_Vehiculo() {
        System.out.println("comprar_Vehiculo");
        Integer id_Cliente = null;
        String no_Tarjeta = "";
        Integer id_Vehiculo = null;
        Importadora instance = new Importadora();
        String expResult = "";
        String result = instance.comprar_Vehiculo(id_Cliente, no_Tarjeta, id_Vehiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
