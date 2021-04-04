/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cat_app;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int opMenu = -1;
        String[] botones = {"1.ver gatos", "2.salir"};
        do {
            String opcion = (String) JOptionPane.showInputDialog(null, "gatitos random", "menu principal", JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])) {
                    opMenu = i;

                }
            }
            switch (opMenu) {
                case 0: {
                    GatosService.vergatos();
                    break;
                }

            }
        } while (opMenu != 1);
        // TODO code application logic here
    }

}
