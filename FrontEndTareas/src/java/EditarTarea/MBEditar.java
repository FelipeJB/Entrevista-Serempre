/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditarTarea;

import IntegracionLogin.Usuarios;
import IntegracionTareas.Tareas;
import IntegracionTareas.WebServiceTareas_Service;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Felipe
 */
@Named(value = "MBEditar")
@RequestScoped
public class MBEditar {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServiceTareas/WebServiceTareas.wsdl")
    private WebServiceTareas_Service service;

    /**
     * Creates a new instance of MBEditar
     */
    public MBEditar() {
    }
    
    private Tareas tarea= (Tareas) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("editar");

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }

    private void edit(IntegracionTareas.Tareas entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        IntegracionTareas.WebServiceTareas port = service.getWebServiceTareasPort();
        port.edit(entity);
    }
    
        public String editar(){
       Usuarios u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       if(u!=null){
         this.edit(tarea);
         return "tareas"; 
       }else{
         return "index";
       }               
    }
    
    public String back(){
        
        return "tareas";
    }
    
}
