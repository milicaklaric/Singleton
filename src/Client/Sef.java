/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import AbstractFactory.*;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

/**
 *
 * @author MK
 */
class SoftverskiSistemSingleton // Singleton
{

    static Sef.SoftverskiSistem ss;
    static boolean jedinstvenoPojavljivanje = false;

    static Sef.SoftverskiSistem Instance(EkranskaForma ef1, BrokerBazePodataka bbp1, Kontroler kon1) {
        if (jedinstvenoPojavljivanje == false) {
            ss = new Sef.SoftverskiSistem(ef1, bbp1, kon1);
            jedinstvenoPojavljivanje = true;
        }
        return ss;
    }
}

public class Sef { // Client

    Projektant proj; // Abstract Factory   

    public static class SoftverskiSistem // Complex Product
    {

        EkranskaForma ef; // AbstractProductA 
        BrokerBazePodataka bbp; // AbstractProductB 
        Kontroler kon; // AbstractProductC 

        public SoftverskiSistem(EkranskaForma ef1, BrokerBazePodataka bbp1, Kontroler kon1) {
            ef = ef1;
            bbp = bbp1;
            kon = kon1;
        }

        void prikaziEkranskuFormu() {
            ef.prikaziEkranskuFormu();
        }

    }

    Sef(Projektant proj1) {
        proj = proj1;
    }

    public static void main(String args[]) {
        Sef sef;
// ConcreteFactory1
        Projektant proj = new Projektant4(); // Promenljivo!!!
        sef = new Sef(proj);
        sef.Kreiraj();
    }

    void Kreiraj() {
        EkranskaForma ef = proj.kreirajEkranskuFormu();
        BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
        Kontroler kon = proj.kreirajKontroler(ef, bbp);
        Sef.SoftverskiSistem ss = SoftverskiSistemSingleton.Instance(ef, bbp, kon);
        System.out.println(ss);
        ss.prikaziEkranskuFormu();
        Sef.SoftverskiSistem ss1 = SoftverskiSistemSingleton.Instance(ef, bbp, kon);
        System.out.println(ss1);
    }

}
