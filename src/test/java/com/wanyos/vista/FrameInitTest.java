/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wanyos.vista;

import org.edisoncor.gui.button.ButtonAction;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wanyos
 */
public class FrameInitTest {
    
    public FrameInitTest() {
    }

    /**
     * Test of getPnAbs method, of class FrameInit.
     */
    @Test
    public void testGetPnAbs() {
        System.out.println("getPnAbs");
        FrameInit instance = new FrameInit();
        AbstractPanel expResult = null;
        AbstractPanel result = instance.getPnAbs();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBtnEjecutar method, of class FrameInit.
     */
    @Test
    public void testGetBtnEjecutar() {
        System.out.println("getBtnEjecutar");
        FrameInit instance = new FrameInit();
        ButtonAction expResult = null;
        ButtonAction result = instance.getBtnEjecutar();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTxtMensaje method, of class FrameInit.
     */
    @Test
    public void testSetTxtMensaje() {
        System.out.println("setTxtMensaje");
        String m = "";
        FrameInit instance = new FrameInit();
        instance.setTxtMensaje(m);
        fail("The test case is a prototype.");
    }
    
}
