/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.ejb.CategoriaFacadeLocal;
import com.mynharcorp.model.Categoria;
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
public class CategoriaController implements Serializable{
 
    @EJB
    private CategoriaFacadeLocal categoriaFacadeLocal;
    
    private Categoria categora;
    
    @PostConstruct
    public void init(){
        this.categora = new Categoria();
    }
    
    /**
     * 
     */
    public void registrar(){
        try{
            
            this.categoriaFacadeLocal.create(categora);            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso!", "Correcto!"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Error!"));
            System.out.println(e.getMessage());
        }
    }

    public Categoria getCategora() {
        return categora;
    }

    public void setCategora(Categoria categora) {
        this.categora = categora;
    }
    
}
