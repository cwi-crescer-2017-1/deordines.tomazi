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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 *
 * @author Deordines
 */

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO", allocationSize = 1)
    @Column(name = "ID", length = 12, nullable = false)
    private Long id;
    
    @Column(name = "NOME", length = 60, nullable = false)
    private String nome;
    
    @Column(name = "BAIRRO", length = 60)
    private String bairro;
    
    @Column(name = "CIDADE", length = 60)
    private String cidade;

    @Column(name = "NUMERO_CASA", length = 10)
    private String numeroCasa;

    @Column(name = "RUA", length = 80)
    private String rua;
    
    @Column(name = "RG", length = 15, nullable = false)
    private String rg;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "TELEFOME", length = 50)
    private String telefone;
    
    @Column(name = "CELULAR", length = 50)
    private String celular;
    
    @Column(name = "SALARIO")
    private BigDecimal salario;

    @Column(name = "FUNCAO", length = 50)
    private String funcao;

    @Column(name = "CPF", length = 11)
    private String cpf;
    
    @Column(name = "NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date nascimento;

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
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the numeroCasa
     */
    public String getNumeroCasa() {
        return numeroCasa;
    }

    /**
     * @param numeroCasa the numeroCasa to set
     */
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
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
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nascimento
     */
    public Date getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
