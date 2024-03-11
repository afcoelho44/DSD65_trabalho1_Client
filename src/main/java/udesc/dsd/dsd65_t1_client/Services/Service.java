/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udesc.dsd.dsd65_t1_client.Services;

/**
 *
 * @author ana
 */
public abstract class Service {
    
    protected String[] request;
    
    public Service (String[] request){
        this.request= request;
    }
    public abstract String send();
    
    
}
