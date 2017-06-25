/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04.exercicios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Deordines
 */

@Entity
@Table(name = "VIDEO")
public class Video implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO", allocationSize = 1)
    @Column(name = "ID", length = 12, nullable = false)
    private Long id;
    
    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;
    
    @Column(name = "DURACAO", length = 50)
    private String duracao;
    
    @ManyToOne
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID")
    private Genero idGenero;
    
    @Column(name = "NOME", length = 50)
    private String nome;
    
    @Column(name = "QUANTIDADE_ESTÉOQUE")
    private int quantidadeEstoque;
    
    @Column(name = "DATA_LANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date lancamento;

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
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the duracao
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the idGenero
     */
    public Genero getIdGenero() {
        return idGenero;
    }

    /**
     * @param idGenero the idGenero to set
     */
    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
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
     * @return the quantidadeEstoque
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the lancamento
     */
    public Date getLancamento() {
        return lancamento;
    }

    /**
     * @param lancamento the lancamento to set
     */
    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }
}
