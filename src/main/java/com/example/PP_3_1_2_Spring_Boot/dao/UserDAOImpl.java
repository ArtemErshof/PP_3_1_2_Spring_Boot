package com.example.PP_3_1_2_Spring_Boot.dao;

import com.example.PP_3_1_2_Spring_Boot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Query query = entityManager.createQuery("delete from User u where u.id =:id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =:id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
