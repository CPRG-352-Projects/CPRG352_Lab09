
package dataaccess;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.User;

public class UserDB {
    
public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } finally {
            em.close();
        }
}
    
    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally { 
            em.close();
        }
    }
    
    public void insert(User newUser) throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(newUser);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(User userToDelete) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(userToDelete));
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
            
        
        public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
