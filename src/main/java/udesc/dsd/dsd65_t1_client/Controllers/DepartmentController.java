/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udesc.dsd.dsd65_t1_client.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import udesc.dsd.dsd65_t1_client.Commons.Constants;
import static udesc.dsd.dsd65_t1_client.Commons.Constants.DELIMITER;
import udesc.dsd.dsd65_t1_client.Observer.Observer;
import udesc.dsd.dsd65_t1_client.Services.DepartmentService;

/**
 *
 * @author ana
 */
public class DepartmentController {
    private DepartmentService service;
    private String department;
    private List<Observer> obss = new ArrayList<>();
    private List<String> departments= new ArrayList<>();
    
    
    public DepartmentController(){}
    
    public void append(Observer obs){
        obss.add(obs);
    }
    
    public void create(String [] request){
       
        service = new DepartmentService(request);
        
        
        String notify = service.send();
        
        for(Observer obs: obss){
            obs.notifyView(notify);
        }
    }
    public void update(String [] request){
         service = new DepartmentService(request);
        
        
        String notify = service.send();
        
        for(Observer obs: obss){
            obs.notifyView(notify);
        }
        
    }
    public void delete(String [] request){
         service = new DepartmentService(request);
        
        
        String notify = service.send();
        
        for(Observer obs: obss){
            obs.notifyView(notify);
        }
    }
    public void getByIDDepartment(String [] request){
          service = new DepartmentService(request);
        
        
        String response = service.send();
        /*
        {"1", "Security", "Sem Gerente", [pessoa;pessoa;pessoa]}
            split(", ")
        */
        
        String[] value = response.split(Constants.DELIMITER);
        
        if(response.contains(Constants.OBJECT_RESPONSE)){
            this.department= value[1];
        }else{
            this.department="";
            for(Observer obs: obss){
            obs.notifyView(value[1]);
        }
        }
        
    }
    public void listDepartment(String [] request){
         service = new DepartmentService(request);
        
        String response = service.send();
        
        String[] msg = response.split(Constants.DELIMITER);
        
        
        if(response.contains(Constants.OBJECT_RESPONSE)){
          for(int i=1; i< msg.length; i++){
              departments.add(msg[i]);
          }
        
        }else{
            for(Observer obs: obss){
                obs.notifyView(msg[1]);
            }
        }
         
    }
    public List<String> getDepartments(){
        return this.departments;
    }

    public String getDepartment() {
        return department;
    }
    
    
}
