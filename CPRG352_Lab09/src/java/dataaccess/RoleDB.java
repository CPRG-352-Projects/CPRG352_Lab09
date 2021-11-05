package dataaccess;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.Role;

/**
 *
 * @author mikep
 */
public class RoleDB {
    
    public List<Role> getAll() throws Exception{
        List<Role> roles = new ArrayList<>();
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            roles = em.createNamedQuery("Role.findAll").getResultList();
            return roles;
        } finally {
            em.close();
        }
    }
    
    public Role get(int roleId) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Role role = em.find(Role.class, roleId);
            return role;
        } finally {
            em.close();
        }
    }
    
}
