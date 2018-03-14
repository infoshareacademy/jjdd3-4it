package com.infoshareacademy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "INPUT_DATA")
public class InputData  {

    @Id
    @Column(name= "date")
    private final LocalDate date;

    @Column(name = "price")
    @NotNull
    private final Double price;

    InputData(LocalDate date, Double price) {
        this.date = date;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}
