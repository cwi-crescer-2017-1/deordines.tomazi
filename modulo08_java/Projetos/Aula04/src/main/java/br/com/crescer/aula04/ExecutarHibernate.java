/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author deordines.tomazi
 */
public class ExecutarHibernate {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        final Session session = em.unwrap(Session.class);
        
        /*
        final Cliente cliente = new Cliente();
        cliente.setId(1l);
        cliente.setNome("Deórdines");
        
        em.getTransaction().begin();
        session.saveOrUpdate(cliente);
        em.getTransaction().commit();
        */
        
        final Cliente cliente = (Cliente)session.load(Cliente.class, 1l);
        System.out.println(cliente.getNome());
//        cliente.setNome("Deórdines Tomazi");       
//        em.getTransaction().begin();
//        session.saveOrUpdate(cliente);
//        em.getTransaction().commit();

    }
}
