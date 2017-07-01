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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deordines.tomazi
 */
@Entity
@Table(name = "COMENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findById", query = "SELECT c FROM Comentario c WHERE c.id = :id"),
    @NamedQuery(name = "Comentario.findByTexto", query = "SELECT c FROM Comentario c WHERE c.texto = :texto"),
    @NamedQuery(name = "Comentario.findByDataComentario", query = "SELECT c FROM Comentario c WHERE c.dataComentario = :dataComentario")})
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMENTARIO")
    @SequenceGenerator(name = "SEQ_COMENTARIO", sequenceName = "SEQ_COMENTARIO", allocationSize = 1)
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
    @Size(min = 1, max = 255)
    @Column(name = "DATA_COMENTARIO")
    private String dataComentario;
    
    @JoinColumn(name = "ID_PUBLICACAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Publicacao idPublicacao;
    
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Comentario() {
    }

    public Comentario(Long id) {
        this.id = id;
    }

    public Comentario(Long id, String texto, String dataComentario) {
        this.id = id;
        this.texto = texto;
        this.dataComentario = dataComentario;
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

    public String getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(String dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Publicacao getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Publicacao idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entidades.Comentario[ id=" + id + " ]";
    }
}
