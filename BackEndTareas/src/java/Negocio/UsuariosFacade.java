/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Felipe
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "BackEndTareasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios validarUsuario(Usuarios u){
    
        
     if(u.getNombreusuario().trim().length() != 0 && u.getPassword().trim().length() !=0){
         Usuarios user = (Usuarios)this.getEntityManager().createNamedQuery("Usuarios.findByNombreusuario").setParameter("nombreUsuario", u.getNombreusuario()).getSingleResult();
         if (user.getPassword().equals(u.getPassword())){
             return user;
         }
         return null;
     }
     
     return null;
 }

    
}
