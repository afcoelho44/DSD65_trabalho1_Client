/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udesc.dsd.dsd65_t1_client.Controllers;


import java.util.ArrayList;
import java.util.List;
import udesc.dsd.dsd65_t1_client.Commons.Constants;
import static udesc.dsd.dsd65_t1_client.Commons.Constants.DELIMITER;
import udesc.dsd.dsd65_t1_client.Observer.Observer;
import udesc.dsd.dsd65_t1_client.Services.UserService;

/**
 *
 * @author ana
 */
public class UserController {
    
    private UserService service;
    private List<String> listUsers = new ArrayList<>();
    private List<Observer> obss = new ArrayList<>();
    
    private String person;
    
    
    public UserController(){}
    
    public void append(Observer obs){
        obss.add(obs);
    }
    
    public void create(String [] request){
       
        service = new UserService(request);
        
        // INSERT METHOD {"class", "method", "departmentId", "cpf", "name", "address", "type", "speciality"}
        
        String notify = service.send();
        
        for(Observer obs: obss){
            obs.notifyView(notify);
        }
    }
    public void update(String [] request){
         service = new UserService(request);
        
        
        String notify = service.send();
        
        for(Observer obs: obss){
            obs.notifyView(notify);
        }
        
    }
    public void delete(String [] request){
         service = new UserService(request);
        
        
        String notify = service.send();
        
        for(Observer obs: obss){
            obs.notifyView(notify);
        }
    }
    public void getByIDUser(String [] request){
          service = new UserService(request);
        
        String response = service.send();
        String[] msg = response.split(Constants.DELIMITER);
        
        if(response.contains(Constants.OBJECT_RESPONSE)){            
            this.person = msg[1];
        }else{
            person= "";
            for(Observer obs: obss){
            obs.notifyView(msg[1]);
        }
        
        }
        
    }
    public void listUsers(String [] request){
         service = new UserService(request);
       
        
        String response = service.send();
       
        String[] list = response.split(DELIMITER);
        
        
        if(response.contains(Constants.OBJECT_RESPONSE)){
            for(int i=1; i< list.length; i++){
              listUsers.add(list[i]);
          }
        }else{
            for(Observer obs: obss){
                obs.notifyView(response);
            }
        }
        
        
    }

    public String getPerson() {
        return person;
    }

    public List<String> getListUsers() {
        return listUsers;
    }
    
    
    
    
    
    
    
    
}
