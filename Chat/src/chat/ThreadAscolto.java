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
public class ThreadAscolto extends Thread{
    
    GestionePacchetti gp;
    String comando;
    String messaggio;
    boolean occupato = false;
    String risposta;
    
    public ThreadAscolto(GestionePacchetti gp) throws SocketException{
        this.gp = gp;
    }

    @Override
    public void run() {
        try {
            gp.riceviPacchetto();
            comando = gp.getComando();
            if (occupato == false) {
                if (comando.equals("c")) {
                System.out.println("Connessione avvenuta!");
                occupato = true;
                risposta = "y;nickname";
                gp.invia(risposta);
                }
                else if(comando.equals("m")){
                    System.out.println("Messaggio ricevuto");
                    messaggio = gp.getMessaggio();
                }
                else if(comando.equals("e")){
                    System.out.println("Chiusura connessione");
                }
            }
            else{
                System.out.println("Non puo avvenire la connessione");
                risposta = "n;";
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ThreadAscolto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
