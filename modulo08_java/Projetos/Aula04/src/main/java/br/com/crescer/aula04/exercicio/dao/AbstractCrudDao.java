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

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final Session session = entityManager.unwrap(Session.class);
    private Class<Entity> entityClass;
    
    public AbstractCrudDAO(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }
    
    @Override
    public Entity save(Entity e) {
        entityManager.getTransaction().begin();
        session.saveOrUpdate(e);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return e;
    }

    @Override
    public void remove(Entity e) {
        entityManager.getTransaction().begin();
        session.delete(e);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Entity loadById(ID id) {
        return (Entity) session.load(entityClass, (Serializable) id);
    }

    @Override
    public List<Entity> findAll() {
        Criteria criteria = session.createCriteria(entityClass);
        return criteria.list();
    }
}
