/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Consonni_Cristian
 */
public class ThreadInvia extends Thread{
    String daInviare;

    @Override
    public void run() {
        try {
            GestionePacchetti gp = new GestionePacchetti();
            gp.invia(daInviare);
            
        } catch (SocketException ex) {
            Logger.getLogger(ThreadInvia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThreadInvia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
