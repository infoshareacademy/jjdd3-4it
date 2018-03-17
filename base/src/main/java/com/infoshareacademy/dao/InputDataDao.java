package com.infoshareacademy.dao;

import com.infoshareacademy.model.InputData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class InputDataDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(InputData inputData) {
        Query query = entityManager.createQuery("SELECT s FROM InputData s WHERE s.currency=? AND s.date=?");
        query.setParameter(1, inputData.getCurrency());
        query.setParameter(2, inputData.getDate());
        if (query.getResultList().isEmpty()) {
            entityManager.persist(inputData);
        }
    }

    public List<InputData> findAllData() {
        Query query = entityManager.createQuery("SELECT s FROM InputData s");
        return query.getResultList();
    }

    public void delete(Long id) {
        InputData deletedData = entityManager.find(InputData.class, id);
        if (deletedData != null) {
            entityManager.remove(deletedData);
        }
    }

}
