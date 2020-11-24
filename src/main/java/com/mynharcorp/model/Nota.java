/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author harold
 */
@Entity
@Table(name="nota")
public class Nota implements Serializable{
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNota;
    
    @ManyToOne
    @JoinColumn(name="idPersona", nullable = false)
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name="idCategoria", nullable = false)
    private Categoria categoria;
    
    @Column(name="encabezado")
    private String encabezado;
    
    @Column(name="cuerpo")
    private String cuerpo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha",insertable = false)
    private Date fecha;
    
    @Column(name="comentarioAdmin")
    private String comentarioAdmin;
    
    @Column(name="valorizacion")
    private Integer valorizacion=1;

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarioAdmin() {
        return comentarioAdmin;
    }

    public void setComentarioAdmin(String comentarioAdmin) {
        this.comentarioAdmin = comentarioAdmin;
    }

    public Integer getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(Integer valorizacion) {
        this.valorizacion = valorizacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (this.idNota != other.idNota) {
            return false;
        }
        if (!Objects.equals(this.encabezado, other.encabezado)) {
            return false;
        }
        if (!Objects.equals(this.cuerpo, other.cuerpo)) {
            return false;
        }
        if (!Objects.equals(this.comentarioAdmin, other.comentarioAdmin)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.valorizacion, other.valorizacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nota{" + "idNota=" + idNota + ", persona=" + persona + ", categoria=" + categoria + ", encabezado=" + encabezado + ", cuerpo=" + cuerpo + ", fecha=" + fecha + ", comentarioAdmin=" + comentarioAdmin + ", valorizacion=" + valorizacion + '}';
    }
    
    
}
