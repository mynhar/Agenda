/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.ejb.CategoriaFacadeLocal;
import com.mynharcorp.ejb.NotaFacadeLocal;
import com.mynharcorp.model.Categoria;
import com.mynharcorp.model.Nota;
import com.mynharcorp.model.Persona;
import com.mynharcorp.model.Usuario;
import java.io.Serializable;
import java.util.List;
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
public class NotaController implements Serializable{
    
    @EJB
    private NotaFacadeLocal notaFacadeLocal;
    
    @EJB
    private CategoriaFacadeLocal categoriaFacadeLocal;
    
    private List<Categoria> categoriaList;
    
    private Nota nota;
    private Categoria categoria;
    
    @PostConstruct
    public void init(){
        this.nota = new Nota();
        this.categoria = new Categoria();
        this.categoriaList = this.categoriaFacadeLocal.findAll();
    }
    
    /**
     * 
     */
    public void registrar(){
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
                
        try{
        
            this.nota.setPersona(usuario.getPersona());
            this.nota.setCategoria(categoria);
            this.notaFacadeLocal.create(nota);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso!", "Correcto!"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Error!"));
            System.out.println(e.getMessage());
        
        }    
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
