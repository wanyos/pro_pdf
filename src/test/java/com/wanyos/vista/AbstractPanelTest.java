/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wanyos.vista;

import java.io.File;
import java.util.List;
import javax.swing.JPanel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wanyos
 */
public class AbstractPanelTest {
    
    public AbstractPanelTest() {
    }

    /**
     * Test of setFileRutaPdf method, of class AbstractPanel.
     */
    @Test
    public void testSetFileRutaPdf() {
        System.out.println("setFileRutaPdf");
        File f = null;
        AbstractPanel instance = new AbstractPanel();
        instance.setFileRutaPdf(f);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFileRutaArchivoPdf method, of class AbstractPanel.
     */
    @Test
    public void testSetFileRutaArchivoPdf() {
        System.out.println("setFileRutaArchivoPdf");
        File f = null;
        AbstractPanel instance = new AbstractPanel();
        instance.setFileRutaArchivoPdf(f);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFileRutaDestino method, of class AbstractPanel.
     */
    @Test
    public void testSetFileRutaDestino() {
        System.out.println("setFileRutaDestino");
        File f = null;
        AbstractPanel instance = new AbstractPanel();
        instance.setFileRutaDestino(f);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreDestino method, of class AbstractPanel.
     */
    @Test
    public void testSetNombreDestino() {
        System.out.println("setNombreDestino");
        String n = "";
        AbstractPanel instance = new AbstractPanel();
        instance.setNombreDestino(n);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaseDatos method, of class AbstractPanel.
     */
    @Test
    public void testSetBaseDatos() {
        System.out.println("setBaseDatos");
        boolean b = false;
        AbstractPanel instance = new AbstractPanel();
        instance.setBaseDatos(b);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPns method, of class AbstractPanel.
     */
    @Test
    public void testGetPns() {
        System.out.println("getPns");
        AbstractPanel instance = new AbstractPanel();
        List<JPanel> expResult = null;
        List<JPanel> result = instance.getPns();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSinCabecera method, of class AbstractPanel.
     */
    @Test
    public void testSetSinCabecera() {
        System.out.println("setSinCabecera");
        boolean b = false;
        AbstractPanel instance = new AbstractPanel();
        instance.setSinCabecera(b);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTodosArchivos method, of class AbstractPanel.
     */
    @Test
    public void testSetTodosArchivos() {
        System.out.println("setTodosArchivos");
        boolean todos_archivos = false;
        AbstractPanel instance = new AbstractPanel();
        instance.setTodosArchivos(todos_archivos);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNuevaBD method, of class AbstractPanel.
     */
    @Test
    public void testSetNuevaBD() {
        System.out.println("setNuevaBD");
        String nombre_bd = "";
        AbstractPanel instance = new AbstractPanel();
        instance.setNuevaBD(nombre_bd);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNuevoActualizar method, of class AbstractPanel.
     */
    @Test
    public void testSetNuevoActualizar() {
        System.out.println("setNuevoActualizar");
        boolean nuevo = false;
        AbstractPanel instance = new AbstractPanel();
        instance.setNuevoActualizar(nuevo);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutaPdf method, of class AbstractPanel.
     */
    @Test
    public void testGetRutaPdf() {
        System.out.println("getRutaPdf");
        AbstractPanel instance = new AbstractPanel();
        File expResult = null;
        File result = instance.getRutaPdf();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutaArchivoPdf method, of class AbstractPanel.
     */
    @Test
    public void testGetRutaArchivoPdf() {
        System.out.println("getRutaArchivoPdf");
        AbstractPanel instance = new AbstractPanel();
        File expResult = null;
        File result = instance.getRutaArchivoPdf();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutaDestino method, of class AbstractPanel.
     */
    @Test
    public void testGetRutaDestino() {
        System.out.println("getRutaDestino");
        AbstractPanel instance = new AbstractPanel();
        File expResult = null;
        File result = instance.getRutaDestino();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreDestino method, of class AbstractPanel.
     */
    @Test
    public void testGetNombreDestino() {
        System.out.println("getNombreDestino");
        AbstractPanel instance = new AbstractPanel();
        String expResult = "";
        String result = instance.getNombreDestino();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSinCabecera method, of class AbstractPanel.
     */
    @Test
    public void testGetSinCabecera() {
        System.out.println("getSinCabecera");
        AbstractPanel instance = new AbstractPanel();
        boolean expResult = false;
        boolean result = instance.getSinCabecera();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTodosArchivos method, of class AbstractPanel.
     */
    @Test
    public void testIsTodosArchivos() {
        System.out.println("isTodosArchivos");
        AbstractPanel instance = new AbstractPanel();
        boolean expResult = false;
        boolean result = instance.isTodosArchivos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArchivoNuevo method, of class AbstractPanel.
     */
    @Test
    public void testGetArchivoNuevo() {
        System.out.println("getArchivoNuevo");
        AbstractPanel instance = new AbstractPanel();
        boolean expResult = false;
        boolean result = instance.getArchivoNuevo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseDatos method, of class AbstractPanel.
     */
    @Test
    public void testGetBaseDatos() {
        System.out.println("getBaseDatos");
        AbstractPanel instance = new AbstractPanel();
        boolean expResult = false;
        boolean result = instance.getBaseDatos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreBD method, of class AbstractPanel.
     */
    @Test
    public void testGetNombreBD() {
        System.out.println("getNombreBD");
        AbstractPanel instance = new AbstractPanel();
        String expResult = "";
        String result = instance.getNombreBD();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
