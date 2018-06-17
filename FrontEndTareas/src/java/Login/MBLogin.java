/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import IntegracionLogin.Usuarios;
import IntegracionLogin.WebServiceLogin_Service;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Felipe
 */
@Named(value = "MBLogin")
@RequestScoped
public class MBLogin {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServiceLogin/WebServiceLogin.wsdl")
    private WebServiceLogin_Service service;

    /**
     * Creates a new instance of LoginMB
     */
    public MBLogin() {
    }

    Usuarios user= new Usuarios();

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
    
    private Usuarios login(IntegracionLogin.Usuarios u) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        IntegracionLogin.WebServiceLogin port = service.getWebServiceLoginPort();
        return port.login(u);
    }
    
    public String iniciarSesion(){
        Usuarios u=login(this.user);
        if(u!=null){
            this.user=u;
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            sessionMap.put("usuario", this.user);
            //return "menu";        
            FacesContext ctx= FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario válido", "Usuario válido"));
        }
        else{
            FacesContext ctx= FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o contraseña no válidos", "Usuario o contraseña no válidos"));
        }
        return "index";
    }
}
