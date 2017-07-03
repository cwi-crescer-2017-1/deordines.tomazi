package br.com.crescer.social.entidade;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "POSTAGEM")
public class Postagem implements Serializable {

    private static final String SEQ_NAME = "SEQ_POSTAGEM";

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "ID_POSTAGEM")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATA_POSTAGEM")
    private Date dataPostagem;
    
    @ManyToOne
    @JoinColumn(name = "USUARIO")
    private Usuario usuario;
    
    @ManyToMany(cascade = ALL)
    private List<Curtida> curtidas;
    
    @ManyToMany(cascade = ALL)
    private List<Comentario> comentarios;

    public Postagem() {
        
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
     * @return the conteudo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return the dataPostagem
     */
    public Date getDataPostagem() {
        return dataPostagem;
    }

    /**
     * @param dataPostagem the dataPostagem to set
     */
    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the curtidas
     */
    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    /**
     * @param curtidas the curtidas to set
     */
    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    /**
     * @return the comentarios
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
