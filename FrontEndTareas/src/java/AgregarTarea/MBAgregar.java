/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgregarTarea;

import IntegracionLogin.Usuarios;
import IntegracionTareas.Tareas;
import IntegracionTareas.WebServiceTareas_Service;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Felipe
 */
@Named(value = "MBAgregar")
@RequestScoped
public class MBAgregar {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServiceTareas/WebServiceTareas.wsdl")
    private WebServiceTareas_Service service;

    /**
     * Creates a new instance of MBAgregar
     */
    public MBAgregar() {
    }
    
    Tareas tarea= new Tareas();

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }
    

    private void create(IntegracionTareas.Tareas entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        IntegracionTareas.WebServiceTareas port = service.getWebServiceTareasPort();
        port.create(entity);
    }
    
    public String crear(){
       Usuarios u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       if(u!=null){
         this.tarea.setIdusuario(u.getId());
         //this.tarea.setId((short) 0);
         this.create(tarea);
         return "tareas"; 
       }else{
         return "index";
       }               
    }
    
    public String back(){
        
        return "tareas";
    }
    
    
    
}
