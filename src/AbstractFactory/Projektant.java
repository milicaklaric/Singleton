/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 *
 * @author MK
 */
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public interface Projektant {

    EkranskaForma kreirajEkranskuFormu();

    BrokerBazePodataka kreirajBrokerBazePodataka();

    Kontroler kreirajKontroler(EkranskaForma ef, BrokerBazePodataka dbbr);
}
