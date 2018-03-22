package com.infoshareacademy.dao;

import com.infoshareacademy.model.CurrencyStatistic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CurrencyStatisticDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyStatisticDao.class);

    public void save(CurrencyStatistic currencyStatistic){
        Query query = entityManager.createQuery("SELECT s FROM CurrencyStatistic s WHERE s.value=?");
        query.setParameter(1, currencyStatistic.getValue());
        if(query.getResultList().isEmpty()){
            LOG.info("Data exist in database");
            entityManager.persist(currencyStatistic);
        }
    }

}
