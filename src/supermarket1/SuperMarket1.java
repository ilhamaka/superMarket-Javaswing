/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermarket1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AKARID
 */
public class SuperMarket1 {      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //  Splash splash = new Splash();
        //splash.ShowSplash();

        // Une fois l'écran de démarrage fermé, vous pouvez lancer votre interface de connexion
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
                
            }
        });
      
      
        }
    }

    

