package com.infoshareacademy.dao;

import com.infoshareacademy.model.CurrencyStatistic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CurrencyStatisticDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyStatisticDao.class);

    public void save(CurrencyStatistic currencyStatistic) {
        entityManager.persist(currencyStatistic);
    }

    public CurrencyStatistic update(CurrencyStatistic currencyStatistic) {
        return entityManager.merge(currencyStatistic);
    }

    public CurrencyStatistic findStatisticByCurrency(String name) {
        return entityManager.find(CurrencyStatistic.class, name);
    }

    public List<CurrencyStatistic> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM CurrencyStatistic s");
        return query.getResultList();
    }

}
