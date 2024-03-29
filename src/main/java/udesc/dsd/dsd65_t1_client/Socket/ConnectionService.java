/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udesc.dsd.dsd65_t1_client.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ana
 */
public class ConnectionService {
    
    private BufferedReader in; 
    
    private PrintWriter out;
    
    private  Socket conn ;
            
    private static String ip;
    
    
    public String SendAndReceiveMessage(String message) throws IOException {

        //179.190.121.102 - maquina Ana
        // 192.168.0.101- maquina nicolas
        try {
            this.conn = new Socket(ip, 65000);
            System.out.println("service connected.");

            setOut();
            setIn();

            out.println(message);

            System.out.println("Waiting response...");
            String response = in.readLine();
            System.out.println("Response: " + response);
            return response;

        } catch (Exception e) {
            System.out.println("Error");
            return e.getMessage();
        } finally {
            if (conn != null) {
                conn.close();
                System.out.println("Socket closed.");
            }
        }

    }
    public void setIn() throws IOException{
         this.in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    }
    public void setOut() throws IOException{
        this.out= new PrintWriter(conn.getOutputStream(), true); // true para autoflush
    }
    
    public void setIP(String ip){
        this.ip=ip;
    }
    
}
