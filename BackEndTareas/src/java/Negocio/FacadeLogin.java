/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Usuarios;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Felipe
 */
@Stateless
@LocalBean
public class FacadeLogin {

    @EJB
    private UsuariosFacade usuariosFacade;

    public Usuarios Login(Usuarios u){
        
        
        Usuarios user =  usuariosFacade.validarUsuario(u);
        
        if(user != null){
            return user;
        }
    
        return null;    
        
    }
    
}
