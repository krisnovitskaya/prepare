package les05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.io.Serializable;
import java.util.List;

public class Dao<T, ID extends Serializable> {

    private Class<T> type;
    private Class<ID> idType;

    private SessionFactory factory;

    private Session currentSession;

    private Transaction currentTransaction;

    public Dao(Class<T> type, Class<ID> idType) {
        this.type = type;
        this.idType = idType;
        factory = getSessionFactory();
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }


    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void saveOrUpdate(T entity) {
        try {
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.save(entity);
        } finally {
            currentSession.getTransaction().commit();
        }
    }

    public ID save(T entity) {
        try {
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.save(entity);
            return (ID) currentSession.save(entity);
        } finally {
            currentSession.getTransaction().commit();
        }
    }


    public T findById(ID id) {
        try {
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            T entity = currentSession.get(type, id);
            return entity;
        } finally {
            currentSession.getTransaction().commit();
        }
    }

    public void delete(T entity) {
        try {
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.delete(entity);
        } finally {
            currentSession.getTransaction().commit();
        }
    }

    public void deleteById(ID id) {
        try {
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            String hql = "DELETE " + type.getSimpleName() + " WHERE id = :param";
            Query query = currentSession.createQuery(hql);
            query.setParameter("param", id);
            query.executeUpdate();
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException();
        } finally {
            currentSession.getTransaction().commit();
        }
    }

    public void deleteAll(){
        try {
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();
            String hql = "DELETE FROM " + type.getSimpleName();
            Query query = currentSession.createQuery(hql);
            query.executeUpdate();
        } finally {
            currentSession.getTransaction().commit();
        }
    }

    public List<T> findAll() {
        try {
            currentSession = factory.getCurrentSession();
            currentSession.beginTransaction();

            String hql = "FROM " + type.getSimpleName();
            Query query = currentSession.createQuery(hql);
            List<T> list = (List<T>) query.list();
            return list;
        } finally {
            currentSession.getTransaction().commit();
        }
    }


    public void close() {
        factory.close();
        if (currentSession != null) {
            currentSession.close();
        }
    }

}
