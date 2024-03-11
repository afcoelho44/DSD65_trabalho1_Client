/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package udesc.dsd.dsd65_t1_client;

import java.io.IOException;
import udesc.dsd.dsd65_t1_client.Socket.ConnectionService;
import udesc.dsd.dsd65_t1_client.Views.HomeView;

/**
 *
 * @author ana
 */
public class DSD65_T1_Client {

    public static void main(String[] args) throws IOException {
        /*String cpf = "1234567895";
        String name = "testName";
        String address = "testAddress";
        String type = String.valueOf(1);
        String speciality = "morning";
        String departmentId = "1";

        String[] messageData = new String[]{"INSERT", cpf, name, address, type, speciality, departmentId};
        String message = String.join(": ", messageData);

        String response = new ConnectionService().SendAndReceiveMessage(message);

        System.out.println(response);
*/
        new HomeView().setVisible(true);
    }
}
