/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.ejb.NotaFacadeLocal;
import com.mynharcorp.model.Nota;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author harold
 */

@Named
@ViewScoped
public class ValorarController implements Serializable{
    
    @EJB
    private NotaFacadeLocal notaFacadelocal;
    
    @Inject
    private ComentarController comentarController;
    
    private Nota nota;
    
    @PostConstruct
    public void init(){
        this.nota = this.comentarController.getNota();
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
    /**
     * 
     */
    public void edit(){        
         try{
            
            this.notaFacadelocal.edit(nota);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso!", "Se comentó correctamente!"));
            
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Error!"));
            System.out.println(e.getMessage());
        }finally{
             /*
             Consepto: flash scoped
             Para guardar los mensages, cuando se esta navegando de una pagina a otra.
             El comportamiento normal es que se muestren en la misma pagina.
             En el finally se busca mantener el estado de los mensages...
             */
             FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }
    
}
