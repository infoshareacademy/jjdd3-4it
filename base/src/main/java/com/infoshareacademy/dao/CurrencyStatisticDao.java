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

    public void save(CurrencyStatistic currencyStatistic){
        if(findExistCurrency(currencyStatistic).isEmpty()){
            LOG.info("Data exist in database");
            entityManager.persist(currencyStatistic);
        }
    }



    public List<CurrencyStatistic> findExistCurrency(CurrencyStatistic currencyStatistic){
        Query query = entityManager.createQuery("SELECT s FROM CurrencyStatistic s WHERE s.name=?");
        query.setParameter(1, currencyStatistic.getName());

        return query.getResultList();
    }


    public CurrencyStatistic update(CurrencyStatistic currencyStatistic) {
        return entityManager.merge(currencyStatistic);
    }
//
//    public void delete(Long id) {
//        final Computer c = entityManager.find(Computer.class, id);
//        if (c != null) {
//            entityManager.remove(c);
//        }
//    }
//
//    public Computer findById(Long id) {
//        return entityManager.find(Computer.class, id);
//    }
//
//    public List<Computer> findAll() {
//        final Query query = entityManager.createQuery("SELECT s FROM Computer s");
//
//        return query.getResultList();
//    }
}
