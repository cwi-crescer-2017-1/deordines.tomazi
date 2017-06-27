/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula04.exercicio.dao;

import java.util.List;
import br.com.crescer.aula04.exercicio.interfaces.ICrudDAO;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Deordines
 */
public abstract class AbstractCrudDAO<Entity, ID> implements ICrudDAO<Entity, ID> {

    private final EntityManager entityManager;
    
    private Class<Entity> entityClass;
    
    public AbstractCrudDAO(Class<Entity> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }
    
    @Override
    public Entity save(Entity e) {
        entityManager.persist(e);
        return e;
    }

    @Override
    public void remove(Entity e) {
        entityManager.remove(e);
    }

    @Override
    public Entity loadById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery("select e from " + entityClass.getSimpleName() + " e").getResultList();
    }
}
