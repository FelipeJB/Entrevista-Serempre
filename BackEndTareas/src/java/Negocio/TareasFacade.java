/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Tareas;
import Datos.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe
 */
@Stateless
public class TareasFacade extends AbstractFacade<Tareas> {

    @PersistenceContext(unitName = "BackEndTareasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareasFacade() {
        super(Tareas.class);
    }
    
    public List<Tareas> getTareas(Usuarios u){    
        
     if(u!=null){         
         List<Tareas> tareas = this.getEntityManager().createNamedQuery("Tareas.findByIdusuario").setParameter("idusuario", u.getId()).getResultList();         
         return tareas;
     }
     
     return null;
    }
    
}
