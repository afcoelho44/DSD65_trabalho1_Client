/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udesc.dsd.dsd65_t1_client.Services;

import java.io.IOException;
import static udesc.dsd.dsd65_t1_client.Commons.Constants.DELIMITER;
import udesc.dsd.dsd65_t1_client.Socket.ConnectionService;

/**
 *
 * @author ana
 */
public class UserService extends Service {
    

    public UserService(String[] request) {
        super(request);
    }

    @Override
    public String send() {
         String message = String.join(DELIMITER, request);
        try {
            return new ConnectionService().SendAndReceiveMessage(message);
        } catch (IOException ex) {
             return ex.getMessage();
        }
    }
    
    
}
