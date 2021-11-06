
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

public class UserService {
    
     public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
        
    }
      
    public void insert(String email, boolean active, String firstname, String lastname, String password, int role) throws Exception{
        System.out.println("In user service - inserted new user");
        User newUser = new User(email, active, firstname, lastname, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(newUser);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User getUser = userDB.get(email);
        userDB.delete(getUser);
    }
    
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void update(String email, String firstName, String lastName, String password, int roleId) throws Exception {
        UserDB userDB = new UserDB();
        User getUser = userDB.get(email);
        getUser.setFirstName(firstName);
        getUser.setLastName(lastName);
        getUser.setPassword(password);
        RoleDB roleDB = new RoleDB();
        Role updateRole = roleDB.get(roleId);
        getUser.setRole(updateRole);
        userDB.update(getUser);
    }
}
