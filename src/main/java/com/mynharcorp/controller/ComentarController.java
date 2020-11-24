/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.controller;

import com.mynharcorp.ejb.NotaFacadeLocal;
import com.mynharcorp.model.Nota;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author harold
 */

@Named
@RequestScoped
public class ComentarController implements Serializable{
    
    @EJB
    private NotaFacadeLocal notaFacadeLocal;
    
    private List<Nota> notaList;
    private Nota nota;
    
    @PostConstruct
    public void init(){
        this.notaList = this.notaFacadeLocal.findAll();
    }

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
}
