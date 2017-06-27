///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.crescer.aula05;
//
//import br.com.crescer.aula04.exercicio.dao.FuncionarioDAO;
//import br.com.crescer.aula04.exercicio.entidades.Funcionario;
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
///**
// *
// * @author Deordines
// */
//
//@Stateless
//public class FuncionarioBean {
//    
//    @PersistenceContext(unitName = "crescer")
//    private EntityManager entityManager;
//    
//    public Funcionario save(Funcionario funcionario) {
//        return new FuncionarioDAO().save(funcionario);
//    }
//    
//    public List<Funcionario> findAll() {
//        return new FuncionarioDAO().findAll();
//    }
//}
