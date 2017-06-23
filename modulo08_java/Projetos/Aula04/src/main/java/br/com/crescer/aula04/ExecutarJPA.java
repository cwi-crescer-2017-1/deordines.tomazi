/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author deordines.tomazi
 */
public class ExecutarJPA {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        /*
        final Cliente cliente = new Cliente();
        cliente.setId(1l);
        cliente.setNome("Deórdines");
                
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        */
        
        // -------------------------------------- //
        
        /*
        final Cliente cliente = em.find(Cliente.class, 1l);
        System.out.println(cliente.getNome());
        */

        // -------------------------------------- //
        
        /*
        final Cliente cliente = em.find(Cliente.class, 1l);
        em.getTransaction().begin();
        em.remove(cliente);
        em.getTransaction().commit();
        */
        
        // -------------------------------------- //
        
        /*        
        final Cliente cliente;
        cliente = em.find(Cliente.class, 1l);
        
        cliente.setNome("Deórdines Tomazi");
        
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        */
        
        // -------------------------------------- //
        
        /*
        final Cliente cliente;
        cliente = em.find(Cliente.class, 1l);
        
        cliente.setNome("DT");
        
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        */
        
        // -------------------------------------- //
        
        /*
        final Cliente cliente = em.find(Cliente.class, 1l);
        cliente.setNome(null);
        em.detach(cliente);
        
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        */
    }
}