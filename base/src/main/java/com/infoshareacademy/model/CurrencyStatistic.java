package com.infoshareacademy.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CURRENCY_STATISTIC")
public class CurrencyStatistic {

    @Id
    @Column(name = "name")

    private String name;

    @Column(name = "value")
    @NotNull
    private Integer value;

    public CurrencyStatistic() {
    }

    public CurrencyStatistic(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name +
                " " + value;
    }
}
