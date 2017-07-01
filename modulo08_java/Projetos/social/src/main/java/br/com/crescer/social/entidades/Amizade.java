/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deordines.tomazi
 */
@Entity
@Table(name = "AMIZADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amizade.findAll", query = "SELECT a FROM Amizade a"),
    @NamedQuery(name = "Amizade.findById", query = "SELECT a FROM Amizade a WHERE a.id = :id")})
public class Amizade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AMIZADE")
    @SequenceGenerator(name = "SEQ_AMIZADE", sequenceName = "SEQ_AMIZADE", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @JoinColumn(name = "ID_USUARIO_1", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario1;
    
    @JoinColumn(name = "ID_USUARIO_2", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario2;

    public Amizade() {
    }

    public Amizade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizade)) {
            return false;
        }
        Amizade other = (Amizade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entidades.Amizade[ id=" + id + " ]";
    }
}
