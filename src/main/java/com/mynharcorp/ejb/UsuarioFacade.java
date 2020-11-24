/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.ejb;

import com.mynharcorp.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author harold
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "agendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
    @Override
    public Usuario iniciarSesion(Usuario obj){
    
        Usuario usuario = null;
        String qlString;
        
        try{
            
            qlString = "from Usuario u where u.usuario = ?1 and u.clave = ?2";
            Query query = em.createQuery(qlString);
            query.setParameter(1, obj.getUsuario());
            query.setParameter(2, obj.getClave());
            
            List<Usuario> lista = query.getResultList();
            
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
            
        
        }catch(Exception e){
            e.getStackTrace();
        }
        
        return usuario;
    }
    
}
