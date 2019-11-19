/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenar;

import almacenar.Paquete;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author b6
 */
public class PaqueteTest {
    
    public PaqueteTest() {
    }
    
   

    /**
     * Test of getVolumen method, of class Paquete.
     */
    @Test
    public void testGetVolumen() {
        System.out.println("getVolumen");
        Paquete instance = new Paquete(1.0);
        double esperado = 1.0;
        double result = instance.getVolumen();
        assertEquals(esperado, result, 0.00);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
