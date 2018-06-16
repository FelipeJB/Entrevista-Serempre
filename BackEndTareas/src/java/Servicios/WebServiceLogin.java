/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Datos.Usuarios;
import Negocio.FacadeLogin;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Felipe
 */
@WebService(serviceName = "WebServiceLogin")
@Stateless()
public class WebServiceLogin {

    @EJB
    private FacadeLogin ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "Login")
    public Usuarios Login(@WebParam(name = "u") Usuarios u) {
        return ejbRef.Login(u);
    }
    
}
