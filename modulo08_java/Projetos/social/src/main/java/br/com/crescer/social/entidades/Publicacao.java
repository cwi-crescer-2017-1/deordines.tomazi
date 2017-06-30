/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author deordines.tomazi
 */
@Entity
@Table(name = "PUBLICACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicacao.findAll", query = "SELECT p FROM Publicacao p"),
    @NamedQuery(name = "Publicacao.findById", query = "SELECT p FROM Publicacao p WHERE p.id = :id"),
    @NamedQuery(name = "Publicacao.findByTexto", query = "SELECT p FROM Publicacao p WHERE p.texto = :texto"),
    @NamedQuery(name = "Publicacao.findByDataPublicacao", query = "SELECT p FROM Publicacao p WHERE p.dataPublicacao = :dataPublicacao")})
public class Publicacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TEXTO")
    private String texto;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_PUBLICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPublicacao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPublicacao")
    private Collection<Comentario> comentarioCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPublicacao")
    private Collection<Curtida> curtidaCollection;

    public Publicacao() {
    }

    public Publicacao(Long id) {
        this.id = id;
    }

    public Publicacao(Long id, String texto, Date dataPublicacao) {
        this.id = id;
        this.texto = texto;
        this.dataPublicacao = dataPublicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @XmlTransient
    public Collection<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(Collection<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    @XmlTransient
    public Collection<Curtida> getCurtidaCollection() {
        return curtidaCollection;
    }

    public void setCurtidaCollection(Collection<Curtida> curtidaCollection) {
        this.curtidaCollection = curtidaCollection;
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
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entidades.Publicacao[ id=" + id + " ]";
    }
}
