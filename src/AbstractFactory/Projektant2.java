/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;
/**
 *
 * @author MK
 */
public class Projektant2 implements Projektant{

    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel1(); // Promenljivo!!!
        EkranskaForma ip = new EkranskaForma1(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }

    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka() {
        BrokerBazePodataka dbbr = new BrokerBazePodataka2(); // Promenljivo!!!
        return dbbr;
    }

    @Override
    public Kontroler kreirajKontroler(EkranskaForma ef, BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler1(ef, dbbr); // Promenljivo!!!
        return kon;
    }
}
