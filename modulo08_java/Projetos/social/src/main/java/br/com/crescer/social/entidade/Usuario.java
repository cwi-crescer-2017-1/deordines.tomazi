package br.com.crescer.social.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    private static final String SEQ_NAME = "SEQ_USUARIO";

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;

    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;

    @Basic(optional = true)
    @Column(name = "IMAGEM_PERFIL")
    private String imagemPerfil;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    
    @Basic(optional = false)
    @Column(name = "GENERO")
    private Character genero;
    
    @JsonIgnore
    @ManyToMany(cascade = ALL)
    private List<Usuario> amigos;

    @JsonIgnore
    @ManyToMany(cascade = ALL)
    private List<Usuario> amigosPendentes;

    public Usuario() {
        
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the imagemPerfil
     */
    public String getImagemPerfil() {
        return imagemPerfil;
    }

    /**
     * @param imagemPerfil the imagemPerfil to set
     */
    public void setImagemPerfil(String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the genero
     */
    public Character getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Character genero) {
        this.genero = genero;
    }

    /**
     * @return the amigos
     */
    public List<Usuario> getAmigos() {
        return amigos;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    /**
     * @return the amigosPendentes
     */
    public List<Usuario> getAmigosPendentes() {
        return amigosPendentes;
    }

    /**
     * @param amigosPendentes the amigosPendentes to set
     */
    public void setAmigosPendentes(List<Usuario> amigosPendentes) {
        this.amigosPendentes = amigosPendentes;
    }
}
