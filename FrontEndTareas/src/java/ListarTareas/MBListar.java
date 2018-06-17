/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListarTareas;

import IntegracionLogin.Usuarios;
import IntegracionTareas.Tareas;
import IntegracionTareas.WebServiceTareas_Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Felipe
 */
@Named(value = "MBListar")
@RequestScoped
public class MBListar {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServiceTareas/WebServiceTareas.wsdl")
    private WebServiceTareas_Service service;

    /**
     * Creates a new instance of MBListar
     */
    public MBListar() {
    }
    
    private List<Tareas> tareas= new ArrayList<>();

    public List<Tareas> getTareas() {
        if(tareas.isEmpty()){
            Usuarios u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if(u!=null){
                IntegracionTareas.Usuarios user = new IntegracionTareas.Usuarios();
                user.setId(u.getId());
                tareas=this.getTareas(user);
            }
        }
        return tareas;
    }

    public void setTareas(List<Tareas> tareas) {
        this.tareas = tareas;
    }
    
    

    private java.util.List<IntegracionTareas.Tareas> getTareas(IntegracionTareas.Usuarios u) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        IntegracionTareas.WebServiceTareas port = service.getWebServiceTareasPort();
        return port.getTareas(u);
    }
    
    public String logOut(){
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            sessionMap.put("usuario", null);
        return "index";
    }
    
    public String agregar(){
       Usuarios u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       if(u!=null){
         return "agregar"; 
       }else{
         return "index";  
       }
    }
    
    public String eliminar(Tareas tarea) throws IOException{
       Usuarios u = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       if(u!=null){
         this.remove(tarea);
         ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
       }else{
         return "index";  
       }
       return "tareas";
    }

    private void remove(IntegracionTareas.Tareas entity) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        IntegracionTareas.WebServiceTareas port = service.getWebServiceTareasPort();
        port.remove(entity);
    }
    
}
