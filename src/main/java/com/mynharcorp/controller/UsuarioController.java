/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.ejb.UsuarioFacadeLocal;
import com.mynharcorp.model.Persona;
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
public class UsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    
    private Usuario usuario;
    private Persona persona;
    
    @PostConstruct
    public void init(){
        this.persona = new Persona();
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * 
     */
    public void registrar(){
        try{
            
            this.usuario.setPersona(persona);
            usuarioFacadeLocal.create(this.usuario);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se Registró"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error!"));
            System.out.println(e.getMessage());
        }
    }
    
}
