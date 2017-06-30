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
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author deordines.tomazi
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByDatanascimento", query = "SELECT u FROM Usuario u WHERE u.datanascimento = :datanascimento"),
    @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo")})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Email
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SENHA")
    private String senha;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATANASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXO")
    private Character sexo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Comentario> comentarioCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Curtida> curtidaCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario1")
    private Collection<Amizade> amizadeCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario2")
    private Collection<Amizade> amizadeCollection1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitante")
    private Collection<SolicitacaoAmizade> solicitacaoAmizadeCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitado")
    private Collection<SolicitacaoAmizade> solicitacaoAmizadeCollection1;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String email, String senha, String nome, Date datanascimento, Character sexo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
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

    @XmlTransient
    public Collection<Amizade> getAmizadeCollection() {
        return amizadeCollection;
    }

    public void setAmizadeCollection(Collection<Amizade> amizadeCollection) {
        this.amizadeCollection = amizadeCollection;
    }

    @XmlTransient
    public Collection<Amizade> getAmizadeCollection1() {
        return amizadeCollection1;
    }

    public void setAmizadeCollection1(Collection<Amizade> amizadeCollection1) {
        this.amizadeCollection1 = amizadeCollection1;
    }

    @XmlTransient
    public Collection<SolicitacaoAmizade> getSolicitacaoAmizadeCollection() {
        return solicitacaoAmizadeCollection;
    }

    public void setSolicitacaoAmizadeCollection(Collection<SolicitacaoAmizade> solicitacaoAmizadeCollection) {
        this.solicitacaoAmizadeCollection = solicitacaoAmizadeCollection;
    }

    @XmlTransient
    public Collection<SolicitacaoAmizade> getSolicitacaoAmizadeCollection1() {
        return solicitacaoAmizadeCollection1;
    }

    public void setSolicitacaoAmizadeCollection1(Collection<SolicitacaoAmizade> solicitacaoAmizadeCollection1) {
        this.solicitacaoAmizadeCollection1 = solicitacaoAmizadeCollection1;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.social.entidades.Usuario[ id=" + id + " ]";
    }
}
