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
public class Projektant3 implements Projektant {
        
    @Override
    public EkranskaForma kreirajEkranskuFormu() {
        Panel pan = new Panel2(); // Promenljivo!!!
        EkranskaForma ip = new EkranskaForma2(); // Promenljivo!!!
        ip.setPanel(pan);
        return ip;
    }   
    
    @Override
    public BrokerBazePodataka kreirajBrokerBazePodataka () 
      { BrokerBazePodataka dbbr = new BrokerBazePodataka1(); // Promenljivo!!!
        return dbbr;}  
    
    @Override
    public Kontroler kreirajKontroler (EkranskaForma ef,BrokerBazePodataka dbbr) {
        Kontroler kon = new Kontroler2(ef,dbbr); // Promenljivo!!!
        return kon;
    }
        
   
}
