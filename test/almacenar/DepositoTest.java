/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author b6
 */
public class DepositoTest {

    private Deposito deposito = null;
    private int cantidadPaquetes = 5;
    private int cantidadDeposito = cantidadPaquetes - 1;
    private Paquete[] paquetes = null;
    private double unidadVolumenPaquete = 10.0;

    public DepositoTest() {
    }

    @Before
    public void setUp() {
        System.out.println("setup");
        double capacidadDeposito = 0;
        paquetes = new Paquete[cantidadPaquetes];
        for (int i = 0; i < cantidadPaquetes; i++) {
            if (i < cantidadDeposito) {
                capacidadDeposito += (i + 1) * unidadVolumenPaquete;
            }
            paquetes[i] = new Paquete((i + 1) * unidadVolumenPaquete);
            System.out.println(paquetes[i].getVolumen());
        }
        deposito = new Deposito(capacidadDeposito);
    }

    @After
    public void tearDown() {
        deposito = null;
    }

    /**
     * Test of agregar method, of class Deposito.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        deposito.limpiar();
        System.out.println("capacidadDeposito" + deposito.maxCapacidad);
        System.out.println("cantidadDeposito" + cantidadDeposito);
        System.out.println("deposito.cantidad:" + deposito.cantidad());
        for (int j = 0; j < deposito.cantidad(); j++) {
            System.out.println(deposito.getPaquete(j).getVolumen());
        }
        for (int i = 0; i < cantidadDeposito; i++) {
            System.out.println("paquetes["+ i + "]" + paquetes[i].getVolumen());
            assertTrue("Fallo al agregar paquete a deposito" + i, deposito.agregar(paquetes[i]));
            assertFalse("Debe fallar al agregar mismo paquete dos veces", deposito.agregar(paquetes[i]));
            assertTrue("Fallo si no contiene el paquete despues de agregarlo", deposito.contiene(paquetes[i]));
        }
        for (int i = cantidadDeposito; i < cantidadPaquetes; i++) {
            assertFalse("Fallo si permite agregar mas paquetes que el limite", deposito.agregar(paquetes[i]));
        }
    }

    /**
     * Test of getPaquetes method, of class Deposito.
     */
    @Test
    public void testGetPaquetes() {
        System.out.println("getPaquetes");
        Random rnd = new Random();
        deposito.limpiar();
        LinkedList<Paquete> lista = new LinkedList<>();
        for (int i = 0; i < cantidadDeposito; i++) {
            lista.add(paquetes[i]);
        }
        for (int i = 0; i < cantidadDeposito; i++) {
            deposito.agregar(lista.remove(rnd.nextInt(lista.size())));
        }
        Iterator<Paquete> iterador = deposito.getPaquetes();
        int cantidad = 0;
        while (iterador.hasNext() && cantidad < cantidadDeposito) {
            Paquete paquete = iterador.next();
            assertTrue("Fallo no retorna paquetes en el orden correcto", paquetes[cantidad] == paquete);
            if (paquetes[cantidad] != paquete) {
                break;
            }
            cantidad++;
        }
        assertEquals("Fallo no retorna todos los paquetes", cantidadDeposito, cantidad);
    }

}
