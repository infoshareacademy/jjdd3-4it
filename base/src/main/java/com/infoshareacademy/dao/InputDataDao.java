package com.infoshareacademy.dao;

import com.infoshareacademy.model.InputData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InputDataDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOG = LoggerFactory.getLogger(InputDataDao.class);

    public void save(InputData inputData) {
        Query query = entityManager.createQuery("SELECT s FROM InputData s WHERE s.currency=? AND s.date=?");
        query.setParameter(1, inputData.getCurrency());
        query.setParameter(2, inputData.getDate());
        if (query.getResultList().isEmpty()) {
            LOG.info("Data exist in database");
            entityManager.persist(inputData);
        }
    }

    public List<InputData> findAllData() {
        Query query = entityManager.createQuery("SELECT s FROM InputData s");
        return query.getResultList();
    }

}
