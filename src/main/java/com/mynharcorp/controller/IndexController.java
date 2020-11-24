/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.ejb.UsuarioFacadeLocal;
import com.mynharcorp.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author harold
 */

@Named
@ViewScoped
public class IndexController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;
    
    
    @PostConstruct
    public void init(){
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * 
     * @return 
     */
    public String iniciarSesion(){
        String redireccion = null;
        try{
            Usuario obj = this.usuarioFacadeLocal.iniciarSesion(usuario);
            if(obj!=null){                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", obj);
                redireccion = "/protegido/principal?faces-redirect=true";
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Aviso","Credenciales incorrectas!"));
            }
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
            e.getStackTrace();
        }
        
        return redireccion;
    }
    
}
