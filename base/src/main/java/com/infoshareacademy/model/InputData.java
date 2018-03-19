package com.infoshareacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "INPUT_DATA", uniqueConstraints = @UniqueConstraint(columnNames = {"date", "currency"}))
public class InputData  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "date")
    @NotNull
    private LocalDate date;

    @Column(name = "price")
    @NotNull
    private  Double price;

    @Column(name = "currency")
    @NotNull
    private String currency;

    public InputData() {
    }

    public InputData(LocalDate date, Double price) {
        this.date = date;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return date +
                " " + price +
                " " + currency;
    }
}
