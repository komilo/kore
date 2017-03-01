/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.komilo.kore.dao;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import tg.komilo.kore.entities.User;

/**
 *
 * @author komilo
 */
@Stateless
public class UserDAOBean extends GenericDAOBean<User, Long> implements UserDAOBeanLocal {

    public UserDAOBean() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        try {
            String jpql = "SELECT u FROM User u WHERE u.username = :username";
            Query query = this.em.createQuery(jpql);
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void addOne(User e) {
//        List<Role> roles = new LinkedList<>();
//        for (Role role : e.getRoles()) {
//            roles.add(this.em.merge(role));
//        }
//        e.setRoles(roles);
        e.getRoles().size();
        super.addOne(e);
    }

//    @Override
//    public User getOne(Long id) {
//        User user = super.getOne(id);
//        user.getRoles().size();
//        return user;
//    }

    @Override
    public String getPassword(Long userId) {
        try {
            String jpql = "SELECT u.password FROM User u WHERE u.id = :userId";
            Query query = this.em.createQuery(jpql);
            query.setParameter("userId", userId);
            return (String) query.getSingleResult();
        } catch (NoResultException e) {
            return "";
        }
    }
}
