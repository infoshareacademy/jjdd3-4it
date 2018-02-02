package com.infoshareacademy.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CryptoValues {

    // class fields declaration
    private String name;
    private String ticker;
    private String description;

    // constructor
    public CryptoValues (String name, String ticker, String description){
        this.name = name;
        this.ticker = ticker;
        this.description = description;
        initMap();
    }

    private void initMap() {
        newmap.put(CryptoNames.BITCOIN, cryptoValue1);
        CryptoValues value = newmap.get(CryptoNames.BITCOIN);
        value.
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    CryptoValues cryptoValue1 = new CryptoValues("Bitcoin", "BTC, XBT", "Most popular cryptovalue on the market.");
    CryptoValues cryptoValue2 = new CryptoValues("DogeCoin", "", "Currency gaining traction as an Internet tipping system.");
    CryptoValues cryptoValue3 = new CryptoValues("Ethereum, ", "", "Ethereum is an open-source, public, blockchain-based distributed computing platform.");
    CryptoValues cryptoValue4 = new CryptoValues("LiteCoin", "", "Peer-to-peer cryptocurrency and open source software project released under the MIT/X11 license.");
    CryptoValues cryptoValue5 = new CryptoValues("Monero", "", "Open-source cryptocurrency that focuses on privacy and decentralization.");

    Map<CryptoNames, CryptoValues> newmap = new HashMap<>();


}
