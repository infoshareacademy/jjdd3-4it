package com.infoshareacademy.dao;

import com.infoshareacademy.model.InputData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Stateless
public class InputDataDao {

    @PersistenceContext
    private EntityManager entityManager;

    public LocalDate save(InputData inputData){
        entityManager.persist(inputData);
        return inputData.getDate();
    }

}
