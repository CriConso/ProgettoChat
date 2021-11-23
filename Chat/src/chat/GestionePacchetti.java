/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Consonni_Cristian
 */
public class GestionePacchetti {
    
    private DatagramSocket server;
    DatagramPacket pacchetto;
    String messaggioRicevuto;
    
    public GestionePacchetti() throws SocketException{
        server = new DatagramSocket(2003);
    }
    
    public void riceviPacchetto() throws SocketException, IOException{
        DatagramSocket server = new DatagramSocket(2003);
        byte[] buffer = new byte[1500];
        pacchetto = new DatagramPacket(buffer,buffer.length);
        server.receive(pacchetto);
        
        byte[] datiRicevuti = pacchetto.getData();
        messaggioRicevuto = new String(datiRicevuti,0,pacchetto.getLength());
        
    }
    
    public void invia(String messaggio) throws IOException {
        String risposta = messaggio;

        byte[] responseBuffer = risposta.getBytes();

        DatagramPacket pacchettoRisposta = new DatagramPacket(responseBuffer, responseBuffer.length);

        pacchettoRisposta.setAddress(pacchetto.getAddress());

        pacchettoRisposta.setPort(pacchetto.getPort());

        server.send(pacchettoRisposta);
    }
    
    public String getMessaggio() {
        String[] campi = messaggioRicevuto.split(";");
        String messaggio = campi[1];
        return messaggio;
    }
    
    public String getComando() {
        String[] campi = messaggioRicevuto.split(";");
        String comando = campi[0];
        return comando;
    }
    
    
}
