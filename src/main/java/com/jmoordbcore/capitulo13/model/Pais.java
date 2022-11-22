/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.AutogeneratedActive;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author avbravo
 */
@Entity(jakartaSource = JakartaSource.JAKARTA)
public class Pais {

    @Id(autogeneratedActive = AutogeneratedActive.ON)
    private Long idpais;
    @Column
    private String pais;

    @Column
    private Date fecha;

    public Pais(Long idpais, String pais, Date fecha) {
        this.idpais = idpais;
        this.pais = pais;
        this.fecha = fecha;
    }

    public Pais() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Pais{" + "idpais=" + idpais + ", pais=" + pais + ", fecha=" + fecha + '}';
    }

}
