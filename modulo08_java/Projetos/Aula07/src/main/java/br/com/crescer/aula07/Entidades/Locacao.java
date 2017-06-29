/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula07.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Deordines
 */
public class Locacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO", allocationSize = 1)
    @Column(name = "ID", length = 12, nullable = false)
    private Long id;
    
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    
    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID")
    private Funcionario idFuncionario;
            
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    private Cliente idCliente;
        
    @ManyToOne
    @JoinColumn(name = "ID_VIDEO", referencedColumnName = "ID")
    private Video idVideo;
    
    @Column(name = "DATA_DEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date devolucao;

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
     * @return the valorTotal
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the idFuncionario
     */
    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idCliente
     */
    public Cliente getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idVideo
     */
    public Video getIdVideo() {
        return idVideo;
    }

    /**
     * @param idVideo the idVideo to set
     */
    public void setIdVideo(Video idVideo) {
        this.idVideo = idVideo;
    }

    /**
     * @return the devolucao
     */
    public Date getDevolucao() {
        return devolucao;
    }

    /**
     * @param devolucao the devolucao to set
     */
    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }
}