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
@Table(name = "SOLICITACAO_AMIZADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitacaoAmizade.findAll", query = "SELECT s FROM SolicitacaoAmizade s"),
    @NamedQuery(name = "SolicitacaoAmizade.findById", query = "SELECT s FROM SolicitacaoAmizade s WHERE s.id = :id")})
public class SolicitacaoAmizade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITACAO_AMIZADE")
    @SequenceGenerator(name = "SEQ_SOLICITACAO_AMIZADE", sequenceName = "SEQ_SOLICITACAO_AMIZADE", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    @JoinColumn(name = "ID_SOLICITANTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idSolicitante;
    
    @JoinColumn(name = "ID_SOLICITADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idSolicitado;

    public SolicitacaoAmizade() {
    }

    public SolicitacaoAmizade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Usuario idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public Usuario getIdSolicitado() {
        return idSolicitado;
    }

    public void setIdSolicitado(Usuario idSolicitado) {
        this.idSolicitado = idSolicitado;
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
        if (!(object instanceof SolicitacaoAmizade)) {
            return false;
        }
        SolicitacaoAmizade other = (SolicitacaoAmizade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entidades.SolicitacaoAmizade[ id=" + id + " ]";
    }
}
